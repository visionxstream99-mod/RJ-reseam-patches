# RJ Patch Catalogue

This catalogue separates recovered source from verified releases. A source entry is not an installable bundle.

## ADM — Remove ads

- Patch ID: `app.rj.adm.patches.removeAds`
- Package: `com.dv.adm`
- Target version: ADM 7.6 (version code 70620)
- Behavior: disables known AdMob, Admax, and AppBrain banner/interstitial entry points and the editor ad cycle.
- Source: `apps/adm/patch/src/main/kotlin/app/rj/adm/patches/RemoveAdsPatch.kt`
- Recovery: reconstructed from the previously recovered RJ `.reseam` bundle's compiled patch class.
- Verification: **not yet built with the current Reseam 0.32.0 workspace or dry-run against a clean ADM 7.6 APK**. The older signed bundle used engine 0.29.0 and should not be republished unchanged.

## Anixart — Remove ads

- Patch ID: `app.rj.anixart.patches.removeAds`
- Package: `com.swiftsoft.anixartd`
- Target version: Anixart 10.5
- Options: remove banner ads, remove Yandex interstitial ads, and skip Kodik pre-roll/information prompt.
- Source: `apps/anixart/patch/src/main/kotlin/app/rj/anixart/patches/AnixartAdsPatch.kt`
- Recovery: reconstructed as a Reseam-native implementation using the published target and behavior notes from [Error404rt/Anixart-patches](https://github.com/Error404rt/Anixart-patches). That project's Anixart patch is identified as GPLv3; see the attribution and license note in `apps/anixart/README.md`.
- Compatibility note: this targets `com.swiftsoft.anixartd` 10.5 only. It does not claim compatibility with Anixart Lite (`com.swiftsoft.anixartlt`) or other versions.
- Verification: **not yet built, dry-run against an Anixart 10.5 APK, or runtime-tested**.

## HyperLock — Remove ads

- Patch ID: `app.rj.hyperlock.patches.removeAds`
- Package: `com.appiolab.hyperlockscreenos`
- Target version: HyperLock Screen & AOD 0.1.2
- Behavior: blocks the embedded AppLovin banner and native ad widgets' ad-load entry points and Google interstitial/reward-fallback load/show entry points. Suppressed show requests invoke the callback's unavailable continuation when present.
- Source: `apps/hyperlock/patch/src/main/kotlin/app/rj/hyperlock/patches/RemoveAdsPatch.kt`
- Research: based on the user-provided APKCube/apktool Smali archive; app-specific signatures were identified in the custom `BannerAdLayout` and `InterstitialAdManager` classes.
- Verification: **source added; current-workspace build, exact-target dry-run, and runtime test still pending**. Do not treat this entry as a verified release.

## Release gate

Before any patch is listed as downloadable:

1. Build the source with the Reseam workspace plugin and CLI version configured for this repository.
2. Obtain an original APK matching the exact package and version listed above.
3. Run `reseam patch --dry-run` with each patch explicitly enabled and confirm every target resolves uniquely.
4. Test the patched app, including the optional settings on Anixart, and check playback/navigation for regressions.
5. Sign a fresh bundle, inspect its manifest and patch IDs, and publish only the tested `.reseam` artifact with accurate release notes.

Never commit private signing keys or claim a patch is verified from a successful compile alone.
