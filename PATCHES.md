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

## HyperLock Screen & AOD — Remove ads

- Patch ID: `app.rj.hyperlock.patches.removeAds`
- Package: `com.appiolab.hyperlockscreenos`
- Target version: HyperLock Screen & AOD 0.1.2
- Behavior: blocks the embedded AppLovin banner/native loaders and Google interstitial/reward-fallback load/show entry points; invokes the unavailable continuation when suppressing a show request.
- Source: `apps/hyperlock/patch/src/main/kotlin/app/rj/hyperlock/patches/RemoveAdsPatch.kt`
- Research: selector signatures identified in the supplied APKCube/apktool-decoded archive.
- Verification: **CI build and bundle-ID inclusion passed**. A true selector dry-run and runtime test remain pending because the supplied decoded archive cannot currently be rebuilt by apktool (`res/values/ids.xml` has an `id` resource compilation error). An original HyperLock 0.1.2 APK is needed to complete validation.

## Release gate

Before any patch is listed as downloadable:

1. Build the source with the Reseam workspace plugin and CLI version configured for this repository.
2. Obtain an original APK matching the exact package and version listed above.
3. Run `reseam patch --dry-run` with each patch explicitly enabled and confirm every target resolves uniquely.
4. Test the patched app, including the optional settings on Anixart and ad-free navigation in HyperLock, and check for regressions.
5. Sign a fresh bundle, inspect its manifest and patch IDs, and publish only the tested `.reseam` artifact with accurate release notes.

Never commit private signing keys or claim a patch is verified from a successful compile alone.
