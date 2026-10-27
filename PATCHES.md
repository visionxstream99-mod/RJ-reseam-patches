# RJ Patch Catalogue

This catalogue separates recovered source from verified releases. A source entry is not an installable bundle.

## ADM — Remove ads

- Patch ID: `app.rj.adm.patches.removeAds`
- Package: `com.dv.adm`
- Target version: ADM 7.6 (version code 70620)
- Behavior: disables known AdMob, Admax, and AppBrain banner/interstitial entry points and the editor ad cycle.
- Source: `apps/adm/patch/src/main/kotlin/app/rj/adm/patches/RemoveAdsPatch.kt`
- Recovery: reconstructed from the previously recovered RJ `.reseam` bundle's compiled patch class.
- Verification: **the source builds with the current Reseam 0.32.0 workspace and the patch ID is present in the CI-built bundle**. It has not been dry-run against a clean ADM 7.6 APK or tested at runtime. The older signed bundle used engine 0.29.0 and should not be republished unchanged.

## Anixart — Remove ads

- Patch ID: `app.rj.anixart.patches.removeAds`
- Package: `com.swiftsoft.anixartd`
- Target version: Anixart 10.5
- Options: remove banner ads, remove Yandex interstitial ads, and skip Kodik pre-roll/information prompt.
- Source: `apps/anixart/patch/src/main/kotlin/app/rj/anixart/patches/AnixartAdsPatch.kt`
- Recovery: reconstructed as a Reseam-native implementation using the published target and behavior notes from [Error404rt/Anixart-patches](https://github.com/Error404rt/Anixart-patches). That project's Anixart patch is identified as GPLv3; see the attribution and license note in `apps/anixart/README.md`.
- Compatibility note: this targets `com.swiftsoft.anixartd` 10.5 only. It does not claim compatibility with Anixart Lite (`com.swiftsoft.anixartlt`) or other versions.
- Verification: **CI compiled the patch and included its metadata in a built bundle**. It has not been dry-run against an original Anixart 10.5 APK or tested at runtime.

## Pinterest — first-pass privacy controls

- Target package: `com.pinterest`
- Target version: Pinterest 14.42.0 (version code 14428010)
- Patch IDs:
  - `app.rj.pinterest.patches.removeAdvertisingIdPermission`
  - `app.rj.pinterest.patches.optOutGoogleAnalytics`
  - `app.rj.pinterest.patches.disablePrivacySandboxAdServices`
  - `app.rj.pinterest.patches.disableGoogleEngageReceiver`
- Source: `apps/pinterest/patch/src/main/kotlin/app/rj/pinterest/patches/PrivacyPatches.kt`
- Behavior: removes the Google Advertising ID permission, sets four existing Google Analytics default-consent values to false, removes the Android Ad Services config property, and disables the Google Engage recommendation receiver.
- Analysis: the exact package/version and each target entry were confirmed in the user-supplied APKM's base manifest. The archive passed ZIP integrity checks.
- Verification: **not yet built or applied to the target APK**. The four patches are experimental. A source build, exact-version patch run, output-manifest inspection, and runtime tests are required before publishing them.
- Deliberately excluded from the first pass: Google Ads SDK initialization metadata removal, Bugsnag changes, promoted-pin/advertising bytecode edits, URL sanitization, and Google sign-in changes. These need additional bytecode or runtime analysis to avoid breaking app behavior.

## Release gate

Before any patch is listed as verified/downloadable:

1. Build the source with the Reseam workspace plugin and CLI version configured for this repository.
2. Obtain an original APK/APKM matching the exact package and version listed above.
3. Run `reseam patch --dry-run` with each patch explicitly enabled and confirm every target resolves uniquely.
4. Apply the patches to a test copy and inspect the changed manifest/resources/bytecode.
5. Test the patched app, including sign-in, navigation, and any optional settings, and check for regressions.
6. Sign a fresh bundle, inspect its manifest and patch IDs, and publish only the tested `.reseam` artifact with accurate release notes.

Never commit private signing keys or claim a patch is verified from a successful compile alone.