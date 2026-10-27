# Anixart — Remove ads

- Patch ID: `app.rj.anixart.patches.removeAds`
- App package: `com.swiftsoft.anixartd`
- Target version: Anixart 10.5
- Options: banner ads, interstitial ads, Kodik pre-roll/information prompt
- Source: `patch/src/main/kotlin/app/rj/anixart/patches/AnixartAdsPatch.kt`

## Behavior

The patch uses Anixart's ad-suppression predicate to hide its programmatic banner strip, stops the app's Yandex interstitial load/show call paths, and ends the Kodik ad activity before the ad player initializes. It also changes only the boolean preference lookup in the Kodik information flow so the one-time disclaimer is treated as already seen.

This target is for package `com.swiftsoft.anixartd` version `10.5`. It does not claim support for Anixart Lite (`com.swiftsoft.anixartlt`) or other versions.

## Provenance and license

This Reseam-native implementation was reconstructed using public feature and target evidence from [Error404rt/Anixart-patches](https://github.com/Error404rt/Anixart-patches), which identifies its Anixart patch as GPLv3. The upstream Morphe implementation has not been copied into this Reseam module. This source file is licensed under GPL-3.0-or-later; see [GPL-3.0](https://www.gnu.org/licenses/gpl-3.0.txt).

## Verification status

Source has been added, but it has **not yet been compiled, dry-run against an Anixart 10.5 APK, or tested at runtime**. Do not publish it as a verified release until all three checks pass. Reseam requires each code target to resolve uniquely; the exact app build must be used to validate the anchors.
