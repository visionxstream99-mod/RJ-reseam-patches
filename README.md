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
| Advanced Download Manager (ADM) | Remove ads | `com.dv.adm` · 7.6 / 70620 | Source compiles in CI and its patch ID is in the built bundle; APK dry-run and runtime checks pending |
| Anixart | Remove ads | `com.swiftsoft.anixartd` · 10.5 | Source compiles in CI and patch metadata passes; APK dry-run and runtime checks pending |

The implementations are in [PATCHES.md](PATCHES.md). The Anixart patch has separate options for banner ads, interstitial ads, and Kodik pre-roll behavior. It targets the `com.swiftsoft.anixartd` package only; Anixart Lite and other versions are not claimed as compatible.

**No current signed release is published yet.** The permanent release signer's public key is `d16834e29b664ab59f5cc8c0b2ce47dfe3620fe8debeb0ddf74d673a68136294`. The recovered ADM artifact was built for Reseam engine 0.29.0, while this repository uses workspace plugin 0.32.0. It must be rebuilt and tested rather than reused unchanged.

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
- A private bundle signing key for release builds

Keep the signing key private. Never commit `.key`, keystore files, access tokens, or other secrets.

### Build and inspect

```shell
./gradlew bundle
reseam bundle list build/reseam/rj-reseam-patches.reseam
```

The generated artifact is written under `build/reseam/`. The [validation workflow](.github/workflows/validate.yml) builds the bundle with a temporary test key and checks the expected patch IDs; this is not a substitute for testing against real APKs.

### Publish a release

The GitHub Actions workflow in `.github/workflows/release.yml` supports version tags matching `v*` and a manual run from the Actions tab.

1. Open [repository Actions secrets](https://github.com/visionxstream99-mod/RJ-reseam-patches/settings/secrets/actions/new) and create a repository secret named `BUNDLE_SIGNING_KEY_B64`. Its value must be the single base64 line in the private key package's `BUNDLE_SIGNING_KEY_B64.txt` file.
2. Open **Actions → release → Run workflow**, enter `v0.1.0`, and run it. The workflow builds and signs the bundle with the permanent key, then publishes the release and `patches.json`.
3. Confirm the build, target matching, patch metadata, and bundle contents before sharing the source with users.

Never publish an untested artifact as stable. Release notes should state target app versions, patch IDs, behavior changes, known issues, and verification status.

## Project structure

```text
manifest.toml                              Bundle identity and license
settings.gradle.kts                        Reseam workspace plugin version
apps/adm/patch/                            ADM Remove ads source
apps/anixart/patch/                        Anixart Remove ads source
apps/anixart/extensions/anixart/            Kodik preference hook
apps/anixart/LICENSE                       GPLv3 license for the Anixart patch
apps/anixart/README.md                     Target, attribution, and verification notes
docs/RELEASE_CHECKLIST.md                  Manual APK test and release gates
.github/workflows/validate.yml             Build and metadata validation
.github/workflows/release.yml              Tagged release automation
NOTICE                                     Reseam license attribution and additional terms
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

The Anixart patch is a Reseam-native implementation informed by the public target/behavior notes from [Error404rt/Anixart-patches](https://github.com/Error404rt/Anixart-patches), which identifies its Anixart patch as GPLv3. The full text is included in [apps/anixart/LICENSE](apps/anixart/LICENSE); see [apps/anixart/README.md](apps/anixart/README.md) for attribution and verification details. Third-party app code is not included.
