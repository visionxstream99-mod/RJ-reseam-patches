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

The patch hides the custom banner and native-ad views while stopping their load entry points, blocks interstitial loading and showing, and prevents `AppOpenManager.b()` from requesting a Google app-open ad. For suppressed show calls, it invokes the matching no-ad continuation: `c()` for normal interstitial paths and `a()` for the reward-fallback path. PairIP and Play Store ownership checks are left unchanged.

The ad target signatures were checked against the supplied HyperLock 0.1.2 APKS `base.apk`, including the custom banner widget, native ad widget, and interstitial manager. The separate feature patch uses exact `x24` preference-read signatures `m(I):Z` (12-hour clock), `n(I):Z` (depth effect), and `j(I):Z` (parallax animation). These are Reseam-native patches; they do not include or distribute HyperLock application code.

## Build and runtime verification status

The latest GitHub Actions build succeeded and verified both HyperLock patch IDs. Reseam CLI 0.32.0 dry-runs against the supplied HyperLock 0.1.2 base APK passed for the ad patch alone (1 applied, 0 failed) and for both patches with all three customization overrides enabled (2 applied, 0 failed). Actual patch application to the supplied base APK plus its 32 split APKs also completed with 2 patches applied and 0 failed, writing all 33 APK components. No Android-device launch or visual/runtime test has been performed, so ad-free behavior and settings still require in-app verification. PairIP and Play Store ownership checks remain unchanged.
