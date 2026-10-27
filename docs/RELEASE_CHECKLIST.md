# Release checklist

Keep ADM and Anixart source in `main`; do not publish a release until both build and target validation are complete.

## 1. Toolchain

- [ ] Use JDK 17 and an installed Android SDK.
- [ ] Use the exact Reseam CLI version configured in `settings.gradle.kts` (currently the workspace plugin is 0.32.0).
- [ ] Run `./gradlew bundle --no-daemon` and resolve all compilation or bundle-load errors.
- [ ] Inspect the signed output with `reseam bundle list` and confirm the patch IDs are exactly `app.rj.adm.patches.removeAds` and `app.rj.anixart.patches.removeAds`.

## 2. ADM

- [ ] Use an original ADM APK with package `com.dv.adm` and version 7.6 (version code 70620).
- [ ] Run `reseam patch` with `--dry-run` and explicitly enable `app.rj.adm.patches.removeAds`.
- [ ] Confirm every target resolves uniquely; investigate missing or ambiguous selectors rather than weakening them blindly.
- [ ] Test banners, interstitials, and the editor flow on the patched app.

## 3. Anixart

- [ ] Use an original Anixart APK with package `com.swiftsoft.anixartd` and version 10.5.
- [ ] Run `reseam patch` with `--dry-run` and explicitly enable `app.rj.anixart.patches.removeAds`.
- [ ] Confirm every target resolves uniquely and the extension helper links correctly.
- [ ] Test each option separately: banner ads, interstitial ads, and Kodik pre-roll.
- [ ] Verify playback and navigation still work after each option is enabled.
- [ ] Do not claim support for Anixart Lite (`com.swiftsoft.anixartlt`) or other app versions without their own target analysis and tests.

## 4. Signing and publishing

- [ ] Sign with the intended release key stored in a private GitHub Actions secret. Never commit signing keys or reuse the temporary CI key.
- [ ] Inspect the bundle manifest, IDs, versions, option names, and signer.
- [ ] Publish a version tag only after the dry-run and runtime checks pass.
- [ ] Attach accurate release notes, including supported versions, known limitations, and verification status.

The automated workflow validates compilation and bundle contents. It does not replace a dry-run against real APKs or runtime testing.
