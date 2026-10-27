# HyperLock — Remove ads

- **Patch ID:** `app.rj.hyperlock.patches.removeAds`
- **Package:** `com.appiolab.hyperlockscreenos`
- **Target:** HyperLock Screen & AOD 0.1.2
- **Source:** `patch/src/main/kotlin/app/rj/hyperlock/patches/RemoveAdsPatch.kt`

## Behavior

The patch blocks the embedded `BannerAdLayout.loadAd(String)` entry point used by the app's banner placements, and blocks the embedded interstitial manager's load/show entry points. When a show request is suppressed, it invokes the manager callback's `c()` unavailable/failure continuation when present, then returns without displaying an ad.

The target signatures were identified from the supplied APKCube/apktool Smali archive, including the custom banner widget and interstitial manager. This is a Reseam-native patch; it does not include or distribute HyperLock application code.

## Build and runtime verification status

The selectors are based on the supplied HyperLock 0.1.2 archive. The patch still needs a successful workspace build, an exact-target Reseam dry-run, and a runtime test in HyperLock. A successful compile alone does not prove banner and interstitial ads are gone or that every screen transition behaves correctly. Do not treat this source entry as a verified release.
