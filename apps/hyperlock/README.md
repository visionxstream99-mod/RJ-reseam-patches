# HyperLock — Ad and customization patches

- **Patch ID:** `app.rj.hyperlock.patches.removeAds`
- **Package:** `com.appiolab.hyperlockscreenos`
- **Target:** HyperLock Screen & AOD 0.1.2
- **Ad patch source:** `patch/src/main/kotlin/app/rj/hyperlock/patches/RemoveAdsPatch.kt`
- **Feature patch source:** `patch/src/main/kotlin/app/rj/hyperlock/patches/HyperLockFeaturesPatch.kt`

## Customize HyperLock

- **Patch ID:** `app.rj.hyperlock.patches.customizeHyperLock`
- **Options:** force 12-hour clock, force depth effects on, and force parallax animation on.
- All three overrides default to off. When an option is off, the patch leaves HyperLock's saved preference unchanged.

## Behavior

The patch blocks the embedded `BannerAdLayout.loadAd(String)` and `NativeAdLayout.loadAd(String)` entry points used for banner and native ad placements, and blocks the embedded interstitial manager's load/show entry points. When a show request is suppressed, it invokes the manager callback's `c()` unavailable/failure continuation when present, then returns without displaying an ad.

The ad target signatures were checked against the supplied HyperLock 0.1.2 APKS `base.apk`, including the custom banner widget, native ad widget, interstitial manager, and app-open lifecycle manager. The separate feature patch uses exact `x24` preference-read signatures `m(I):Z` (12-hour clock), `n(I):Z` (depth effect), and `j(I):Z` (parallax animation). These are Reseam-native patches; they do not include or distribute HyperLock application code.

## Build and runtime verification status

The supplied HyperLock 0.1.2 base APK was inspected. Static DEX signature checks passed and GitHub Actions successfully built the signed test bundle and verified both HyperLock patch IDs. The exact-target Reseam dry-run and an in-app runtime test remain pending; a successful compile alone does not prove ads are gone or settings behave correctly. Do not treat these source entries as a verified release.
