# 🛠️ Reseam Patch Development & Advanced Reverse Engineering Guide (v0.45.0)

> **Master Architecture & Implementation Manual**  
> Synthesized from production Reseam patch source code (`reseam-patches-0.45.0`). This guide details the complete Kotlin DSL, bytecode transformation engine, extension architecture, native syscall trapping, anti-tamper/signature spoofing, and advanced reverse engineering paradigms.

---

## 📑 Table of Contents

1. [Workspace Architecture & Module Organization](#1-workspace-architecture--module-organization)
2. [Reseam Fingerprinting & Symbol Resolution DSL](#2-reseam-fingerprinting--symbol-resolution-dsl)
3. [Patch Lifecycle, Options & Execution Engine](#3-patch-lifecycle-options--execution-engine)
4. [Advanced Bytecode Transformations & CodeScope Operations](#4-advanced-bytecode-transformations--codescope-operations)
5. [Runtime Extensions Architecture (`@Export` & Generated Bindings)](#5-runtime-extensions-architecture-export--generated-bindings)
6. [Signature Killer & Native Seccomp File Redirection](#6-signature-killer--native-seccomp-file-redirection)
7. [Device Identity, Registration & Anti-Ban Engineering](#7-device-identity-registration--anti-ban-engineering)
8. [GmsCore / MicroG Support & Device Spoofing (Pixel XL)](#8-gmscore--microg-support--device-spoofing-pixel-xl)
9. [Resource Scope Utilities & ART Baseline Profile Purging](#9-resource-scope-utilities--art-baseline-profile-purging)
10. [Build, Packaging & Terminal Verification Protocols](#10-build-packaging--terminal-verification-protocols)

---

## 1. Workspace Architecture & Module Organization

A production Reseam workspace uses a modular Gradle structure separating patch bytecode rules from Kotlin runtime extensions.

```
reseam-workspace/
├── manifest.toml               # Global workspace manifest (engine version, bundle metadata)
├── settings.gradle.kts         # Root Gradle setup configuring Reseam plugin v0.34.0 / 0.45.0
├── build.gradle.kts            # Root build definitions
├── apps/
│   ├── shared/                 # Shared utility patches and extension utilities
│   │   ├── patch/              # Global resource Scope / Manifest helpers
│   │   └── extensions/         # ClearURLs, URL sanitizers, shared rules
│   ├── universal/              # System-wide patches reusable across any APK
│   │   ├── patch/              # SignatureKillerPatch, HidePackagesPatch, ForceExtractNativeLibs
│   │   └── extensions/         # SignatureKiller native lib (libSignatureKiller.so), HiddenPackages API
│   └── <app_name>/             # Specific target app workspace (e.g. capcut, adguard, googlephotos, niagara)
│       ├── patch/              # Fingerprints & Patch declarations (DEX modification rules)
│       │   └── src/main/kotlin/<pkg>/patches/<app>/
│       │       ├── <Feature>Fingerprints.kt
│       │       └── <Feature>Patch.kt
│       └── extensions/         # Extension DEX classes compiled and injected into target APK
│           └── src/main/kotlin/<pkg>/<app>/<feature>/
│               └── <ExtensionClass>.kt
```

---

## 2. Reseam Fingerprinting & Symbol Resolution DSL

Fingerprints locate obfuscated classes, methods, fields, and instruction points across varying APK releases using semantic and structural anchors.

### A. Class Resolution (`klass`)
```kotlin
// By explicit name
internal val appClass = klass("com.adguard.android.AdGuardApplication")

// By unique diagnostic string literals
internal val paidLicenseState = klass("paidLicenseState") {
    strings("PaidLicense(licenseKey=")
}

// By enum constants present in class
internal val licenseTypes = klass("licenseTypes") {
    enumConstants("Family")
    custom { descriptor in paidLicenseConstructor.parameterTypes }
}
```

### B. Method Resolution (`method`)
```kotlin
// Exact method signature
internal val isPremiumMethod = klass("je3").method("isPremiumCached") {
    returns(Type.Boolean)
    params("android.content.Context")
}

// Structural matching: calledBy, calls, inClass, strings
internal val initialCachedState = method("initialCachedState") {
    calledBy(licenseKeyMethod)
    inClass(klass(licenseKeyMethod.owner))
}

internal val fetchBackendState = method("fetchBackendState") {
    strings("The Backend response is null, let's provide the Unknown Plus state")
}

// Instruction calls matching
internal val nativeSigningCertificate = method("nativeSigningCertificate") {
    returns(Type.Object)
    hasParam(Type.Long)
    calls { 
        owner("android.content.pm.Signature")
        name("toByteArray") 
    }
}
```

### C. Field & Enum Resolution (`fieldTarget`, `enumConstant`)
```kotlin
// Finding a static singleton field of a resolved class
internal val lifetimeInstance = fieldTarget("lifetimeInstance") {
    val lifetimeClass = lifetimeDuration.classDef
    lifetimeClass.staticFields.singleOrNull { it.fieldType == lifetimeClass.descriptor }?.ref
        ?: error("Expected exactly one Lifetime singleton field")
}

// Resolving enum constant
internal val familyLicense = licenseTypes.enumConstant("Family")
```

### D. Instruction Point Capture (`point`)
Locates specific instruction sequences within a method body:
```kotlin
internal val installerCheckPoint = splashOnCreate.point {
    invokeStatic {
        owner("k22")
        name("a")
    }
}.next { 
    resultOf(Type.Boolean) 
}.captureAs("isInstallerValid")
```

---

## 3. Patch Lifecycle, Options & Execution Engine

Patches define high-level metadata, user-configurable options, dependency graphs, and two-phase execution (`execute` and `afterDependents`).

```kotlin
val hidePackages = patch("Hide packages") {
    description("Hides the chosen packages from the app's PackageManager queries.")

    // Declare configurable options
    val packageNamesOption = stringListOption(
        "packageNames",
        title = "Packages to hide",
        description = "Package names the app must not see.",
        required = true,
    )
    
    val diagnostics = boolOption(
        "diagnostics",
        title = "Log diagnostics",
        description = "Enable detailed logcat logging.",
        default = false,
    )

    // Dependencies (executes dependent patch first)
    dependsOn(signatureKiller)

    // Phase 1: Main bytecode manipulation phase
    execute {
        log.info("Executing primary transformations...")
    }

    // Phase 2: Runs after all dependent patches have completed their edits
    afterDependents {
        val selectedPackages = options[packageNamesOption]
        log.info("Processing options after dependent patches: $selectedPackages")
    }
}
```

---

## 4. Advanced Bytecode Transformations & CodeScope Operations

Inside `.before`, `.after`, `.replace`, and `execute` blocks, Reseam provides a powerful `CodeScope` for synthesizing DEX instructions.

### A. Return Value Overrides
```kotlin
// Return direct primitives / null / void
isPremiumCachedMethod.before { returnValue(bool(true)) }
loadBannerAdMethod.before { returnVoid() }
injectionDetectionEnabled.alwaysReturn(false)
abnormalPackageToast.alwaysReturn()
```

### B. Instantiating Objects in Bytecode
```kotlin
private fun CodeScope.lifetimeLicense(): ValueRef = newInstance(
    paidLicenseState.descriptor,
    paidLicenseConstructor.proto,
    string(PATCH_ATTRIBUTION), // License key
    staticField(familyLicense), // Enum parameter
    staticField(lifetimeInstance), // Singleton parameter
    int(67),                    // Active devices
    int(69),                    // Device limit
    string("Licensed User"),    // Account owner name
)
```

### C. Accessing Parameters & Fields
```kotlin
// Parameters
param(0)                         // First method parameter
paramOfType(Type.String)         // Parameter matching type
paramOfType("android.content.Context")
lastParam                        // Final parameter in signature

// Fields
val context = thisObject.field(weatherContext)
staticField(kotlinUnit)
```

### D. Invoking Methods (Virtual, Static, Interface)
```kotlin
// Static Call
callStatic(
    "android.util.Base64", "decode", proto("[B", Type.String, Type.Int),
    string(encodedCertificate), int(0)
)

// Virtual Call
payload.callVirtual(
    "org.json.JSONObject", "put", proto("org.json.JSONObject", Type.String, Type.Object),
    string("sig_hash"), string(registrationDigest)
)

// Interface Call
val response = chain.callInterface(
    "com.bytedance.retrofit2.intercept.Interceptor\$Chain",
    "proceed",
    proto("com.bytedance.retrofit2.SsResponse", "com.bytedance.retrofit2.client.Request"),
    request
)

// Invoking Injected Extension Class via Generated Bindings
call(
    DeviceRegistration.preparePayload,
    paramOfType(Type.String),
    paramOfType(JSONObjectClass)
)
```

### E. Bytecode Redirection Across Entire APK
Redirect all calls to standard Android SDK APIs across the entire codebase to an extension method:
```kotlin
// Redirect PackageManager queries across all DEX files in the APK
val packageChecks = bytecode.redirectCalls(
    "android.content.pm.PackageManager", 
    "hasSigningCertificate", 
    SignatureChecks.hasSigningCertificate
)

val properties = bytecode.redirectCalls(
    "android.os.SystemProperties", 
    "get", 
    PixelXlIdentity.get
)
```

### F. Control Flow Constructs in Bytecode
```kotlin
whenTrue(call(DeviceRegistration.excludeAppHeaders, paramOfType(RETROFIT_REQUEST))) {
    returnTrue()
}

whenNotNull(payloadNode) {
    payloadNode.callVirtual(...)
}
```

### G. Instruction String Replacement
```kotlin
// Replaces every occurrence of old String constant with new String constant in DEX instructions
val count = method.replaceAllStrings("https://old-api.com", "https://new-api.com")
```

---

## 5. Runtime Extensions Architecture (`@Export` & Generated Bindings)

Extension modules allow writing complex Java/Kotlin code that compiles into DEX files and gets packaged into the patched APK alongside binding bridges.

### A. Writing an Extension (`@Export`)
```kotlin
@file:JvmName("DeviceRegistration")

package top.madkarma.capcut.integrity

import android.content.Context
import app.reseam.runtime.Export
import org.json.JSONObject

@Export
@Synchronized
fun initialize(context: Context?) {
    if (context == null) return
    // Thread-safe initialization logic
}

@Export
fun preparePayload(serialized: String?, header: JSONObject?): String {
    val payload = JSONObject(checkNotNull(serialized))
    // Process JSON headers
    return payload.toString()
}
```

### B. Auto-Generated Bindings
When Reseam builds the project, it automatically generates Kotlin binding definitions under `bindings` package (e.g. `top.madkarma.capcut.integrity.bindings.DeviceRegistration`).
In the patch file, invoke these bindings cleanly:
```kotlin
import top.madkarma.capcut.integrity.bindings.DeviceRegistration

deviceRegistrationInit.before {
    call(DeviceRegistration.initialize, paramOfType("android.content.Context"))
}
```

---

## 6. Signature Killer & Native Seccomp File Redirection

When an app validates its v2/v3 signing certificate or performs self-checksum verification against the physical `/data/app/.../base.apk` file, `SignatureKiller` provides double-tier spoofing:

### Tier 1: PackageInfo & Reflection Spoofing
1. Overrides `PackageInfo.CREATOR` to dynamically replace `signatures` and `signingInfo` arrays upon parcel deserialization.
2. Evicts system caches using reflection:
   - Clears `PackageManager.sPackageInfoCache`
   - Clears `Parcel.mCreators` and `Parcel.sPairedCreators`
3. Hooks early during Pairip startup or `attachBaseContext`.

### Tier 2: Physical APK File Spoofing via Native Seccomp (`libSignatureKiller.so`)
1. Embeds the untouched original APK into assets: `assets/SignatureKiller/origin.apk`.
2. Bundles compiled native binaries for target ABIs (`arm64-v8a`, `armeabi-v7a`, `x86`, `x86_64`) as `lib/abi/libSignatureKiller.so`.
3. At runtime, extracts `origin.apk` to private storage and activates `seccomp` system call traps.
4. Traps raw `openat` Linux syscalls made by native libraries (e.g., `libmetasec_ov.so`) and redirects file descriptor reads of `/data/app/.../base.apk` to the extracted `origin.apk`.

```kotlin
// Enabling Signature Killer with APK file redirection in patch
val spoofApkFileAccess = patch("Signature Killer (APK file access)") {
    dependsOn(signatureKiller)
    execute {
        // Embeds original base & split APKs into assets
        // Embeds native libSignatureKiller.so across all supported ABIs
    }
}

// Trapping raw syscalls for specific native anti-tamper SDKs
metaSecLibraryLoad.after {
    call(SignatureKiller.redirectRawApkOpens, string("libmetasec_ov.so"))
}
```

---

## 7. Device Identity, Registration & Anti-Ban Engineering

For apps that implement device bans or device registration tracking (e.g., Bytedance / CapCut / TikTok SDKs):

### A. Isolated & Thread-Safe Profile Management
- Store registration profiles in `context.noBackupFilesDir` to prevent Android Auto-Backup from syncing device IDs across devices.
- Use atomic file locks (`RandomAccessFile.channel.lock()` and `AtomicFile`) to prevent race conditions during multi-process app launches.

```kotlin
private fun updateProfile(update: (JSONObject) -> JSONObject): JSONObject {
    RandomAccessFile(File(profileDirectory, "installation.lock"), "rw").channel.use { channel ->
        channel.lock().use {
            val file = AtomicFile(File(profileDirectory, "installation.json"))
            // Read or generate fresh UUIDs for openudid, clientudid, google_aid, cdid
            // Write atomically via file.startWrite() / file.finishWrite()
        }
    }
}
```

### B. Stripping Banned Device Headers
- On network registration endpoints (`/service/2/device_register/`), remove server-assigned `device_id` and `install_id` to force the backend to register a clean session.
- Set `BaseRequestContext.bypassCookie = true` to strip stale session tracking cookies.

---

## 8. GmsCore / MicroG Support & Device Spoofing (Pixel XL)

### A. MicroG / GmsCore Account Provider Integration
For apps requiring Google Sign-In on ungoogled devices or modified APKs:
- Intercept account queries to `content://<vendor>.android.gms.auth.accounts`.
- Handle `EXTENDED_ACCESS` permissions (`$vendor.org.microg.gms.EXTENDED_ACCESS`).
- Inspect battery optimization states via `PowerManager.isIgnoringBatteryOptimizations` and prompt users if background sync is throttled.

### B. Google Photos Unlimited Storage Spoofing (Pixel XL `marlin`)
1. Select original 2016 Pixel feature flags (`NEXUS_PRELOAD`, `PIXEL_PRELOAD`) in Photos initialization and disable newer Pixel midyear flags.
2. Override `Build` field reads at access sites:
   - `BRAND` -> `"google"`
   - `MANUFACTURER` -> `"Google"`
   - `MODEL` -> `"Pixel XL"`
   - `BOARD` / `DEVICE` / `PRODUCT` / `HARDWARE` -> `"marlin"`
   - `FINGERPRINT` -> `"google/marlin/marlin:10/QP1A.191005.007.A3/5972272:user/release-keys"`
3. Redirect `android.os.SystemProperties.get` calls to `PixelXlIdentity.get`.

---

## 9. Resource Scope Utilities & ART Baseline Profile Purging

### A. Global Multi-Locale String Rewriting
In split APKs or localized builds, `setString` only updates the primary resource table. To update string entries across all split resource tables and configurations:

```kotlin
fun ResourceScope.setStringEverywhere(name: String, value: String): Boolean {
    var found = false
    for (componentName in components()) {
        val resources = component(componentName)
        val id = resources.id("string", name) ?: continue
        val index = resources.poolAdd(value) ?: error("Cannot add $name to $componentName")
        resources.replaceEntry(id, index)
        found = true
    }
    return found
}
```

### B. ART Baseline Profile Purging
Modifying DEX bytecode invalidates pre-compiled Android Runtime (ART) baseline profiles. Stale ART profiles cause app crashes or verification errors on Android 12+. Purge them during patch execution:

```kotlin
for (component in files.components()) {
    val componentFiles = files.component(component)
    val profiles = componentFiles.list().filter {
        it.startsWith("assets/") && (it.endsWith("/baseline.prof") || it.endsWith("/baseline.profm"))
    }
    for (profile in profiles) {
        componentFiles.delete(profile)
        log.info("Integrity: removed stale ART profile $component/$profile.")
    }
}
```

---

## 10. Build, Packaging & Terminal Verification Protocols

### A. Synchronize Versions
Ensure engine version compatibility in `manifest.toml` and `settings.gradle.kts`:
```toml
# manifest.toml
[bundle]
name = "rj-reseam-patches"
version = "0.45.0"
engine = "0.34.0"
```

### B. Compile Patch DEX JAR
```powershell
./gradlew build
```
Output JAR location: `apps/<app_name>/patch/build/reseam/<app_name>-patches.jar`

### C. Bundle Packing & Signing
```powershell
Copy-Item 'manifest.toml' 'staging/manifest.toml' -Force
Copy-Item 'apps/<app_name>/patch/build/reseam/<app_name>-patches.jar' 'staging/<app_name>-patches.jar' -Force

& "reseam-windows-x64 (1).exe" bundle pack `
  --version 0.45.0 `
  --key "path/to/signing-key.pem" `
  --out "rj-reseam-patches-0.45.0.reseam" `
  "staging"
```

### D. Verification Testing via Terminal
Run Reseam CLI against the target APK before repository integration:
```powershell
& "reseam-windows-x64 (1).exe" patch `
  --trust d16834e29b664ab59f5cc8c0b2ce47dfe3620fe8debeb0ddf74d673a68136294 `
  --bundle "rj-reseam-patches-0.45.0.reseam" `
  --ignore-versions `
  --output "test_patched_output.apk" `
  "target_input.apk"
```

Validate terminal output to ensure all patches report **`patch applied`** with **`failed=0`**.

---

## 11. Morphe-to-Reseam Patch Porting & Conversion Protocol

### A. Conceptual Architecture Mapping

| Aspect | Morphe Framework | Reseam Framework |
| :--- | :--- | :--- |
| **Patch Declaration** | `bytecodePatch(name = "...", default = true) { ... }` | `val patchVal = patch("Name") { ... }` |
| **Resource Patch** | `resourcePatch { document("...").use { ... } }` | `manifest.document` / `ResourceScope` in `execute` |
| **Fingerprints** | `classDefBy(...)`, `findMutableMethodOf(...)` | `klass("name") { strings(...) }`, `method("name") { ... }` |
| **Instruction Hooking** | Manual smali code string assembly & label insertion | `CodeScope` DSL (`.before`, `.after`, `.replace`, `call(...)`) |
| **Runtime Extension** | Plain Java/Kotlin class compiled in `extensions/` | `@Export` annotated methods + auto-generated `bindings` |

### B. Case Study: Porting HushFacebook to Reseam

#### 1. Extension Context Initialization
- **Morphe**: Prepended `setContext(Context)` in `FacebookApplication.onCreate()`.
- **Reseam**: 
  ```kotlin
  val facebookExtensionPatch = patch("Facebook Extension Core") {
      execute {
          facebookAppOnCreate.before {
              call(FacebookExtension.setContext, param(0))
          }
      }
  }
  ```

#### 2. Feed Ad Filtering (`HideSponsoredPostsPatch`)
- **Morphe**: Inserted smali conditional branch at `FeedUnitCollectionManager.addNewEdgeToCollection`.
- **Reseam**:
  ```kotlin
  val hideSponsoredPosts = patch("Hide sponsored posts") {
      dependsOn(facebookExtensionPatch)
      execute {
          addNewEdgeToCollectionMethod.before {
              val category = param(0)
              val feedUnit = param(1)
              val shouldHide = call(FeedFilter.hideEdge, category, feedUnit)
              whenTrue(shouldHide) { returnFalse() }
          }
      }
  }
  ```
 
#### 3. Audience Network Disable (`DisableAudienceNetworkPatch`)
- **Morphe**: Used XML W3C document manipulation + smali hook.
- **Reseam**:
  ```kotlin
  val disableAudienceNetwork = patch("Disable Audience Network") {
      execute {
          // 1. Manifest Modification
          val doc = manifest.document()
          for (child in doc.root.children) {
              if (child["android:name"] in AUDIENCE_NETWORK_COMPONENTS) {
                  child["android:enabled"] = "false"
              }
          }
          
          // 2. Redirection of setComponentEnabledSetting
          bytecode.redirectCalls(
              "android.content.pm.PackageManager",
              "setComponentEnabledSetting",
              AudienceNetwork.componentState
          )
      }
  }
  ```

---

## 12. GitHub Actions CI & Cross-Platform Deployment Protocols

### A. Linux Runner Executable Permissions (`gradlew` Permission Denied / Exit Code 126)
When committing Reseam workspaces on Windows, Git may stage `gradlew` with file permission `100644` (non-executable). On GitHub Actions Linux runners (Ubuntu), executing `./gradlew bundle` or `./gradlew build` fails with `Permission denied` (exit code `126`).

**Fix Protocol:**
Grant executable file permissions to `gradlew` in Git index before committing:
```powershell
git update-index --chmod=+x gradlew
git commit -m "fix(ci): grant executable permission (+x) to gradlew script"
git push origin main
```

### B. Kotlin Top-Level Functions vs `@JvmStatic` in Extension Modules
In Reseam extension DEX modules (`apps/<app>/extensions`), top-level functions defined in files annotated with `@file:JvmName("ExtensionName")` MUST NOT be annotated with `@JvmStatic`.
- **Compiler Error:** `Only members in named objects and companion objects can be annotated with '@JvmStatic'`.
- **Correct Usage:**
  ```kotlin
  @file:JvmName("FacebookExtension")
  package app.rj.facebook.extensions

  import app.reseam.runtime.Export

  @Export // Do NOT add @JvmStatic on top-level functions
  fun setContext(context: Context?) {
      // Extension initialization logic
  }
  ```

### C. Workspace Manifest Requirement (`manifest.toml`)
Reseam Gradle workspace plugin (`app.reseam.workspace` v0.34.0) requires `manifest.toml` at the root of the workspace directory. Without `manifest.toml`, task `relocateKotlin` fails with `Failed to query the value of extension 'reseamBundle' property 'name'`.
```toml
[bundle]
name = "rj-reseam-patches"
author = "RJ"
description = "Community patches for ADM, Anixart, Facebook, JioHotstar, Pinterest, and HyperLock"
format_version = 1
```

---

## 13. Case Studies: Modern Target App Fingerprint Resolution

### A. JioHotstar (v26.10.12.2+)
1. **Screen Mirroring & HDMI Cast Protection:**
   - Override `PlayerConfig.getEnableHdmiBroadcastListener()` -> `alwaysReturn(false)`.
   - Override `CapabilitiesConfig.getEnableSendingHdcpNoDigitalOutputForNoHdmiConnected()` -> `alwaysReturn(false)`.
2. **Codec & Resolution Capability Check:**
   - Match `methods("isDeviceBlacklisted")` in `Oh.b` (`(String, Map): Boolean`) -> `alwaysReturn(false)`.
3. **Premium UI & Subscription Status:**
   - Match `com.hotstar.ui.model.pagedata.MyPageData.getIsSubscribed()` -> `alwaysReturn(true)`.

### B. Advanced Download Manager (ADM 14.x)
- **Appodeal Mediation SDK Bypasses:** ADM 14.x migrated from legacy AdMob to Appodeal Mediation (`com.appodeal.ads.Appodeal`).
- **Resolution:**
  - Target `com.appodeal.ads.Appodeal`: `show`, `canShow`, `isLoaded` -> `alwaysReturn(false)`.
  - Target `com.appodeal.ads.Appodeal`: `initialize` -> `before { returnVoid() }`.
  - Target `com.google.android.gms.ads.BaseAdView`: `loadAd` -> `before { returnVoid() }`.

