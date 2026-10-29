# 🛠️ Reseam Patch Development & RJ Repository Integration Guide

This guide documents the complete end-to-end workflow for analyzing Android applications, creating Reseam patches, testing compiled `.reseam` bundles, and integrating new patches into the **`RJ-reseam-patches`** repository.

---

## ⚠️ Crucial Operational Rules

1. **Deep Code Analysis & Research First:**
   * When provided with an app and clue requirements (e.g. "remove ads", "unlock premium"), do NOT rush or make superficial assumptions.
   * Perform deep static code analysis on the smali, decompiled classes, and resource XMLs.
   * Understand how the app's monetization, billing, ad containers, layout visibility, and anti-tamper logic operate under the hood.
   * Search online or consult SDK documentation if needed to understand specific frameworks (AdMob, AppLovin, Pairip, Google Play Billing, etc.).

2. **Isolated Patch Staging Before Repository Integration:**
   * **Do NOT modify or add code directly to the user's main `RJ-reseam-patches` source repository initially.**
   * Create, build, and test patches in an isolated standalone workspace first.
   * Verify the patch execution against the target APK using `reseam patch` in terminal until all patches report `applied` with `failed=0`.
   * Only after the patch is fully tested and verified, present it to the user and await confirmation before integrating it into `RJ-reseam-patches`.

---

## 📌 Phase 1: Target App Analysis & Decompilation

When provided with decompiled smali source code or an APK directory:

### 1. Identify App Package & Application Class
* Open `AndroidManifest.xml` and locate:
  * `package="..."` (e.g. `com.appiolab.hyperlockscreenos`).
  * `android:name="..."` under `<application>` (e.g. `com.pairip.application.Application` or `com.appiolab.hyperlock_screen_and_aod.Helper.App`).

### 2. Locate Premium & In-App Purchase Checks
* **Search keywords:** `is_premium_user`, `is_lifetime_premium`, `isPremiumCached`, `isPro`, `isVIP`, `billing`.
* **Identify the Global Master Switch:** Look for static boolean fields in the Application helper class (e.g., `Lcom/appiolab/hyperlock_screen_and_aod/Helper/App;->e:Z`).
* **Identify Billing Managers:** Look for billing preference checkers (e.g. `je3#isPremiumCached(Context)Z`).

### 3. Locate Ad Mediation Managers & Ad Containers
* **Search keywords:** `com.applovin.mediation`, `com.google.android.gms.ads`, `BannerAdLayout`, `InterstitialAdManager`, `NativeAdLayout`, `AppOpenManager`, `ad_loading`, `adShimmerView`.
* **Identify ad layout cleanup methods:**
  * In `BannerAdLayout`, find method `c(BannerAdLayout, String)` or similar method that sets `adContainer` visibility to `View.GONE` (`8`) when `App.e` is `true`.

### 4. Locate Integrity & Anti-Tamper Checks
* **Pairip License Check:** Search for `com.pairip.licensecheck.LicenseClient#checkLicense`.
* **Play Store Installer Check:** Search for `"Please install this app from official Play Store."` or `getInstallerPackageName` / `getInstallSourceInfo`.
  * Note how installer equality is checked in `SplashActivity#onCreate` (e.g. `Lk22;->a(Object, Object)Z`).

---

## 🛠️ Phase 2: Writing Reseam Patch Code (Kotlin DSL)

Create patch source files in a standalone workspace (`apps/<app_name>/patch/src/main/kotlin/<app_name>/patches/`).

### 1. Fingerprints Definition (`<App>Fingerprints.kt`)
```kotlin
// SPDX-License-Identifier: AGPL-3.0-or-later

package <app_name>.patches

import app.reseam.patch.Type
import app.reseam.patch.field
import app.reseam.patch.klass
import app.reseam.patch.method
import app.reseam.patch.point

// Global App & Billing
internal val appClass = klass("com.appiolab.hyperlock_screen_and_aod.Helper.App")
internal val appOnCreate = appClass.method("onCreate")
internal val appPremiumField = appClass.field("e")
internal val isPremiumCachedMethod = klass("je3").method("isPremiumCached") {
    returns(Type.Boolean)
    params("android.content.Context")
}

// Ads
internal val bannerClass = klass("com.applovin.mediation.BannerAdLayout")
internal val nativeClass = klass("com.applovin.mediation.NativeAdLayout")
internal val loadBannerAdMethod = bannerClass.method("loadAd")
internal val loadInterstitialAdMethod = klass("com.applovin.mediation.InterstitialAdManager").method("loadAd")
internal val loadNativeAdMethod = nativeClass.method("loadAd")
internal val bannerC = bannerClass.method("c")

// Anti-Tamper & Play Store Check
internal val licenseClientCheck = klass("com.pairip.licensecheck.LicenseClient").method("checkLicense")
internal val splashOnCreate = klass("com.appiolab.hyperlock_screen_and_aod.Activitys.SplashActivity").method("onCreate")
internal val installerCheckPoint = splashOnCreate.point {
    invokeStatic {
        owner("k22")
        name("a")
    }
}.next { resultOf(Type.Boolean) }.captureAs("isInstallerValid")
```

### 2. Patch Declarations

#### A. Unlock Premium Patch (`UnlockPremiumPatch.kt`)
```kotlin
package <app_name>.patches

import app.reseam.patch.before
import app.reseam.patch.patch

val unlockPremium = patch("Unlock Premium") {
    description("Unlocks all PRO/VIP features, fonts, wallpapers, and AOD styles.")
    compatibleWith("<target_package_name>")

    execute {
        isPremiumCachedMethod.before {
            returnValue(bool(true))
        }
        log.info("Premium: Unlocked all PRO features and disabled paywalls.")
    }
}
```

#### B. Remove Ads Patch (`RemoveAdsPatch.kt`)
```kotlin
package <app_name>.patches

import app.reseam.patch.before
import app.reseam.patch.callStatic
import app.reseam.patch.patch

val removeAds = patch("Remove Ads") {
    description("Removes all banner, interstitial, and native ads and hides ad loading containers.")
    compatibleWith("<target_package_name>")

    execute {
        // Execute BannerAdLayout.c to set adContainer visibility to View.GONE (8) before returning
        loadBannerAdMethod.before {
            callStatic("com/applovin/mediation/BannerAdLayout", "c", "(Lcom/applovin/mediation/BannerAdLayout;Ljava/lang/String;)V", thisObject, param(0))
            returnVoid()
        }

        loadNativeAdMethod.before {
            returnVoid()
        }

        loadInterstitialAdMethod.before {
            returnVoid()
        }

        log.info("Ads: Neutralized ad loaders and hid ad containers.")
    }
}
```

#### C. Bypass License & Play Store Check (`LicenseBypassPatch.kt`)
```kotlin
package <app_name>.patches

import app.reseam.patch.after
import app.reseam.patch.before
import app.reseam.patch.patch

val licenseBypass = patch("Bypass License Check") {
    description("Bypasses Pairip anti-tamper, Play Store installer verification, and license checks.")
    compatibleWith("<target_package_name>")

    execute {
        licenseClientCheck.before {
            returnVoid()
        }

        installerCheckPoint.after {
            capture("isInstallerValid").assign(bool(true))
        }

        log.info("Integrity: Bypassed Pairip license and Play Store installer verification.")
    }
}
```

---

## ⚙️ Phase 3: Engine Version & Build Configurations

### 1. Synchronize Version Numbers
Ensure all files use matching Reseam SDK engine versions (`0.34.0`):
* **`settings.gradle.kts`**: `id("app.reseam.workspace") version "0.34.0"`
* **`manifest.toml`**: `engine = "0.34.0"`

### 2. Build Patch Jar Files
Run in PowerShell:
```powershell
./gradlew build
```
The compiled DEX patch JAR will be generated at:
`apps/<app_name>/patch/build/reseam/<app_name>-patches.jar`

### 3. Pack & Sign `.reseam` Bundle
Run using Reseam 0.34.0 CLI (`reseam-windows-x64 (1).exe`):
```powershell
Copy-Item 'manifest.toml' 'staging/manifest.toml' -Force
Copy-Item 'apps/<app_name>/patch/build/reseam/<app_name>-patches.jar' 'staging/<app_name>-patches.jar' -Force

& "reseam-windows-x64 (1).exe" bundle pack --version 0.1.2 --key "path/to/bundle-signing.key" --out "standalone-patch.reseam" "staging"
```

---

## 🧪 Phase 4: Verification Testing on Terminal

Test the newly created bundle against the target APK before presenting or integrating:

```powershell
& "reseam-windows-x64 (1).exe" patch `
  --trust d16834e29b664ab59f5cc8c0b2ce47dfe3620fe8debeb0ddf74d673a68136294 `
  --bundle "standalone-patch.reseam" `
  --ignore-versions `
  --output "test_patched_output.apk" `
  "target_input.apk"
```

Confirm all patches report `patch applied` with `failed=0`.

---

## 🚀 Phase 5: Integrating into RJ Repository (Upon User Approval)

Once the user approves the patch:
1. Copy patch files to `RJ-reseam-patches/apps/<app_name>/patch/src/main/kotlin/app/rj/<app_name>/patches/`.
2. Update metadata in `patches.json` and `manifest.toml`.
3. Rebuild `rj-reseam-patches.reseam`.
4. Commit, tag (`git tag -f v0.1.3`), push (`git push origin main --force`), and publish release artifacts.

---

## ⚙️ Phase 6: GitHub Actions CI & Deployment Best Practices

### 1. Linux Executable Permission Bit (`./gradlew Permission Denied / Exit Code 126`)
When committing or staging repository changes on Windows, Git may save `gradlew` with file mode `100644` (non-executable). GitHub Actions Ubuntu runners will fail during `./gradlew bundle` with `Permission denied` (exit code `126`).
* **Fix Command:** Run `git update-index --chmod=+x gradlew` before committing to ensure mode `100755`.

### 2. Extension Functions in Kotlin (`@JvmStatic` Rule)
In Reseam extension DEX files (`apps/<app>/extensions`), top-level functions in `@file:JvmName(...)` files must **never** use `@JvmStatic`.
* **Reason:** `@JvmStatic` is only valid inside an `object` or `companion object`.
* **Correct Syntax:** Use `@Export` on top-level functions directly.

### 3. Workspace Manifest (`manifest.toml`)
Reseam Gradle workspace plugin (`app.reseam.workspace` v0.34.0) requires `manifest.toml` at the repository root. Without it, task `relocateKotlin` fails with `Failed to query the value of extension 'reseamBundle' property 'name'`.

### 4. Target App Evolution Solutions
* **ADM 14.x:** ADM replaced legacy AdMob strings with **Appodeal Mediation SDK** (`com.appodeal.ads.Appodeal`). Target `show`, `canShow`, `isLoaded`, and `initialize` on `Appodeal`, plus `BaseAdView.loadAd()`.
* **JioHotstar 26.10+:** Target `PlayerConfig.getEnableHdmiBroadcastListener()` (`false`), `CapabilitiesConfig.getEnableSendingHdcpNoDigitalOutputForNoHdmiConnected()` (`false`), `Oh.b.isDeviceBlacklisted()` (`false`), and `MyPageData.getIsSubscribed()` (`true`).
