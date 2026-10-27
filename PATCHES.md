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
- Behavior: blocks banner/native ad loading and interstitial/reward-fallback load/show entry points. An unverified app-open lifecycle interception was removed to avoid interfering with app startup. It does not change purchase logic or Play Store validation.
- Source: `apps/hyperlock/patch/src/main/kotlin/app/rj/hyperlock/patches/RemoveAdsPatch.kt`
- Research: the target classes and full method signatures were checked against the supplied original APKS `base.apk`.
- Verification: the current CI run successfully built the bundle and confirmed both HyperLock patch IDs. Static DEX signature checks passed against the supplied base.apk. A true Reseam dry-run and an in-app runtime test are still required; no runtime success is claimed.

## HyperLock Screen & AOD — Customize HyperLock

- Patch ID: `app.rj.hyperlock.patches.customizeHyperLock`
- Package: `com.appiolab.hyperlockscreenos`
- Target version: HyperLock Screen & AOD 0.1.2
- Options: force 12-hour clock, force depth effects on, and force parallax animation on. All overrides default to off and leave HyperLock's saved settings untouched unless enabled.
- Source: `apps/hyperlock/patch/src/main/kotlin/app/rj/hyperlock/patches/HyperLockFeaturesPatch.kt`
- Research: the preference helper's methods `x24->m(I):Z`, `x24->n(I):Z`, and `x24->j(I):Z` were found in the supplied base DEX. They read the app's clock-format, depth-effect, and parallax-animation preferences respectively.
- Verification: source selectors were matched to the supplied APK's DEX method table, and the current CI bundle build and patch-ID assertion passed. The Reseam dry-run and runtime behavior remain unverified. These options do not modify Play Store checks, purchases, or premium entitlement.

## Release gate

Before any patch is listed as downloadable:

1. Build the source with the Reseam workspace plugin and CLI version configured for this repository.
2. Obtain an original APK matching the exact package and version listed above.
3. Run `reseam patch --dry-run` with each patch explicitly enabled and confirm every target resolves uniquely.
4. Test the patched app, including the optional settings on Anixart and ad-free navigation in HyperLock, and check for regressions.
5. Sign a fresh bundle, inspect its manifest and patch IDs, and publish only the tested `.reseam` artifact with accurate release notes.

Never commit private signing keys or claim a patch is verified from a successful compile alone.
