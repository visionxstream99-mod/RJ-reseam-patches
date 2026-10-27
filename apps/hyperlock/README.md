# HyperLock — Remove ads

- **Patch ID:** `app.rj.hyperlock.patches.removeAds`
- **Package:** `com.appiolab.hyperlockscreenos`
- **Target:** HyperLock Screen & AOD 0.1.2
- **Source:** `patch/src/main/kotlin/app/rj/hyperlock/patches/RemoveAdsPatch.kt`

## Behavior

The patch blocks the embedded `BannerAdLayout.loadAd(String)` and `NativeAdLayout.loadAd(String)` entry points used for banner and native ad placements, and blocks the embedded interstitial manager's load/show entry points. When a show request is suppressed, it invokes the manager callback's `c()` unavailable/failure continuation when present, then returns without displaying an ad.

The ad target signatures were checked against the supplied HyperLock 0.1.2 APKS `base.apk`, including the custom banner widget, native ad widget, interstitial manager, and app-open lifecycle manager. The separate feature patch uses exact `x24` preference-read signatures `m(I):Z` (12-hour clock), `n(I):Z` (depth effect), and `j(I):Z` (parallax animation). These are Reseam-native patches; they do not include or distribute HyperLock application code.

## Build and runtime verification status

The selectors are based on the supplied HyperLock 0.1.2 archive. The patch still needs a successful workspace build, an exact-target Reseam dry-run, and a runtime test in HyperLock. A successful compile alone does not prove banner and interstitial ads are gone or that every screen transition behaves correctly. Do not treat this source entry as a verified release.
