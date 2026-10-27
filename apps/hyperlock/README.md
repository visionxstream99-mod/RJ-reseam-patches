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

The supplied HyperLock 0.1.2 base APK was inspected, and the patch selectors correspond to methods present in its DEX. The latest GitHub Actions build succeeded and verified both HyperLock patch IDs. The exact-target Reseam dry-run and in-app runtime tests remain pending; compilation alone does not prove that every ad path is suppressed or the optional settings work correctly. Do not treat these source entries as a verified release.
