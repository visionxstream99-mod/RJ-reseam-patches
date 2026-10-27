# Anixart — Remove ads

- Patch ID: `app.rj.anixart.patches.removeAds`
- App package: `com.swiftsoft.anixartd`
- Target version: Anixart 10.5
- Options: banner ads, interstitial ads, Kodik pre-roll/information prompt
- Source: `patch/src/main/kotlin/app/rj/anixart/patches/AnixartAdsPatch.kt`
- Hook: `extensions/anixart/src/main/java/app/rj/anixart/extension/AnixartAdHooks.java`

## Behavior

The patch uses Anixart's ad-suppression predicate to hide its programmatic banner strip, stops the app's Yandex interstitial load/show call paths, and ends the Kodik ad activity before the ad player initializes. It also changes only the boolean preference lookup in the Kodik information flow so the one-time disclaimer is treated as already seen.

This target is for package `com.swiftsoft.anixartd` version `10.5`. It does not claim support for Anixart Lite (`com.swiftsoft.anixartlt`) or other versions.

## Provenance and license

This Reseam-native implementation was reconstructed using public feature and target evidence from [Error404rt/Anixart-patches](https://github.com/Error404rt/Anixart-patches), which identifies its Anixart patch as GPLv3. The upstream Morphe implementation has not been copied into this Reseam module. This source and helper are licensed under GPL-3.0-or-later; the full license text is included in this directory's [LICENSE](LICENSE) file.

## Verification status

Source has been added, but this patch is **not yet confirmed as a working release**. It must compile, dry-run against an original Anixart 10.5 APK with every target resolving uniquely, and pass runtime checks for playback and navigation before publication.
