<div align="center">

<img src="https://reseam.app/logo.svg" alt="Reseam logo" width="88">

# RJ Reseam Patches

**Android app customizations built for Reseam.**

A community patch bundle maintained by **RJ** — with version-aware patches, clear metadata, and releases you can inspect before installing.

[**Add source to Reseam**](https://reseam.app/add/?url=https%3A%2F%2Fgithub.com%2Fvisionxstream99-mod%2FRJ-reseam-patches) · [Releases](https://github.com/visionxstream99-mod/RJ-reseam-patches/releases) · [Report a bug](https://github.com/visionxstream99-mod/RJ-reseam-patches/issues)

</div>

---

## Patch catalogue

| App | Patch | Target | Current status |
|---|---|---|---|
| Advanced Download Manager (ADM) | Remove ads | `com.dv.adm` · 7.6 / 70620 | Source reconstructed from the old RJ bundle; current build and dry-run pending |
| Anixart | Remove ads | `com.swiftsoft.anixartd` · 10.5 | Reseam-native source added; current build, dry-run, and runtime test pending |

The implementations are in [PATCHES.md](PATCHES.md). The Anixart patch has separate options for banner ads, interstitial ads, and Kodik pre-roll behavior. It targets the `com.swiftsoft.anixartd` package only; Anixart Lite and other versions are not claimed as compatible.

**No current signed release is being advertised yet.** The previous ADM artifact was built for Reseam engine 0.29.0, while this repository uses the 0.32.0 workspace. It must be rebuilt and tested rather than reused as-is.

## Add the source

1. Install [Reseam Manager](https://reseam.app) from its official source.
2. Open the **Add source to Reseam** link at the top of this README, or paste this repository URL into Reseam Manager's source-add flow:
   `https://github.com/visionxstream99-mod/RJ-reseam-patches`
3. Review the listed apps, patches, and signing key before trusting the source.
4. Select only patches whose target app version and notes match your installation.

If the add link does not open the app, update Reseam Manager and follow its in-app source import instructions.

## Building from source

### Requirements

- JDK 17
- Android SDK, with `ANDROID_HOME` configured
- Reseam CLI matching the plugin version in `settings.gradle.kts`
- Gradle wrapper included in the repository
- A bundle signing key for release builds

Keep the signing key private. Never commit `.key`, keystore files, access tokens, or other secrets.

### Build and inspect

```shell
./gradlew bundle
reseam bundle list build/reseam/rj-reseam-patches.reseam
```

The generated artifact name can depend on the project configuration. Inspect the file produced under `build/reseam/`.

### Publish a release

The GitHub Actions workflow in `.github/workflows/release.yml` is configured to build and publish on version tags matching `v*`.

1. Add the base64-encoded signing key as the repository Actions secret `BUNDLE_SIGNING_KEY_B64`.
2. Confirm the build, target matching, patch metadata, and bundle contents before releasing.
3. Create and push a version tag, for example `v0.1.0`, only when the bundle is ready for users.

Never publish an untested artifact as stable. Release notes should state target app versions, patch IDs, behavior changes, known issues, and any migration steps.

## Project structure

```text
manifest.toml                 Bundle name, author, and description
settings.gradle.kts           Reseam workspace plugin and project name
apps/adm/patch/               ADM Remove ads source
apps/anixart/patch/           Anixart Remove ads source
apps/anixart/README.md        Target, attribution, and verification notes
.github/workflows/release.yml Tagged release automation
NOTICE                        Reseam license attribution and additional terms
```

Modules are configured by the Reseam workspace Gradle plugin. See the [Reseam authoring documentation](https://reseam.app/docs/authoring/start/) and [first patch guide](https://reseam.app/docs/authoring/first_patch/).

## Verification policy

A successful compile is not proof that a patch works at runtime. Before release, run each patch's Reseam dry-run against the exact target APK, verify every selector resolves uniquely, and test the patched app. This is especially important for bytecode targets based on obfuscated app methods.

## Security and trust

- Review patch descriptions and source details before enabling anything.
- Back up important app data before applying patches.
- Report crashes or unexpected behavior with the Reseam version, patch release, target app version, Android version, and relevant logs (with personal information removed).
- Never post signing keys, tokens, passwords, or private account data in issues.
- A signing key lets users identify a bundle publisher; it does not by itself guarantee that a patch is safe.

## Credits and licensing

This project uses the Reseam bundle template and preserves the upstream `NOTICE` and licensing terms. Reseam and its logos are trademarks or property of their respective owners; this project is independent and is not endorsed by the Reseam developers.

The Anixart patch is a Reseam-native implementation informed by the public target/behavior notes from [Error404rt/Anixart-patches](https://github.com/Error404rt/Anixart-patches), which identifies its Anixart patch as GPLv3. See [apps/anixart/README.md](apps/anixart/README.md) for the patch's attribution and license. Third-party app code is not included.
