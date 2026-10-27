<div align="center">

<img src="https://reseam.app/logo.svg" alt="Reseam logo" width="88">

# RJ Reseam Patches

**Android app customizations built for Reseam.**

A community patch bundle maintained by **RJ** — with version-aware patches, clear metadata, and releases you can inspect before installing.

[**Add source to Reseam**](https://reseam.app/add/?url=https%3A%2F%2Fgithub.com%2Fvisionxstream99-mod%2FRJ-reseam-patches) · [Releases](https://github.com/visionxstream99-mod/RJ-reseam-patches/releases) · [Report a bug](https://github.com/visionxstream99-mod/RJ-reseam-patches/issues)

</div>

---

## About

RJ Reseam Patches is a patch bundle for Android apps that use the [Reseam](https://reseam.app) patching ecosystem. The goal is to provide useful customizations with accurate target-app details, transparent behavior, and compatibility notes that distinguish tested builds from experimental work.

This repository started from the official Reseam bundle template. The template's example patches and build configuration are scaffolding, not finished RJ app-specific patches. They will be replaced or clearly identified as the project develops.

## Quick start

1. Install [Reseam Manager](https://reseam.app) from its official source.
2. Open the **Add source to Reseam** link at the top of this README, or paste this repository URL into Reseam Manager's source-add flow:
   `https://github.com/visionxstream99-mod/RJ-reseam-patches`
3. Review the listed apps, patches, and signing key before trusting the source.
4. Select only patches whose target app version and notes match your installation.

If the add link does not open the app, update Reseam Manager and follow its in-app source import instructions.

## Patch catalogue

Patch availability is defined by the source and published releases. Check [Releases](https://github.com/visionxstream99-mod/RJ-reseam-patches/releases) for downloadable bundles and release notes.

Every RJ patch should document:

| Field | What you'll find |
|---|---|
| Target app | App name and Android package ID |
| Patch identity | Exact patch name and unique ID |
| Compatibility | Intended and actually tested app versions |
| Behavior | What changes when the patch is enabled |
| Limitations | Known issues, dependencies, and side effects |
| Release | Bundle version and release notes |

**Important:** starter-template examples are not proof that an app-specific patch exists. Do not assume a patch is available unless it appears in the source or a published release.

## Building from source

### Requirements

- JDK 17
- Android SDK, with `ANDROID_HOME` configured
- Reseam CLI matching the plugin version in `settings.gradle.kts`
- Gradle wrapper included in the repository
- A bundle signing key

Keep the signing key private. Never commit `.key`, keystore files, access tokens, or other secrets.

### Build and inspect

```shell
./gradlew bundle
reseam bundle list build/reseam/rj-reseam-patches.reseam
```

The exact generated artifact name can depend on the project and release configuration. Use the file produced under `build/reseam/`.

### Publish a release

The GitHub Actions workflow in `.github/workflows/release.yml` is configured to build and publish on version tags matching `v*`.

1. Add the base64-encoded signing key as the repository Actions secret `BUNDLE_SIGNING_KEY_B64`.
2. Confirm the workflow, build, patch metadata, and bundle contents before releasing.
3. Create and push a version tag, for example `v0.1.0`, only when the bundle is ready for users.

Never publish an untested artifact as stable. Release notes should state target app versions, patch IDs, behavior changes, known issues, and any migration steps.

## Project structure

```text
manifest.toml                 Bundle name, author, and description
settings.gradle.kts           Reseam workspace plugin and project name
apps/<app>/patch/              Patch modules for a target app
apps/<app>/extensions/         Optional injected extension code
apps/<app>/settings/           Optional in-app settings and strings
shared/<name>/                 Shared extension modules
.github/workflows/release.yml  Tagged release automation
NOTICE                        Reseam license attribution and additional terms
```

Modules are configured by the Reseam workspace Gradle plugin. See the [Reseam authoring documentation](https://reseam.app/docs/authoring/start/) and [first patch guide](https://reseam.app/docs/authoring/first_patch/).

## Contribution guidelines

Before submitting a patch, provide the target app name, package ID, exact version, patch ID, intended behavior, and test results. See [CONTRIBUTING.md](CONTRIBUTING.md) for the checklist and release expectations.

## Security and trust

- Review patch descriptions and source details before enabling anything.
- Back up important app data before applying patches.
- Report crashes or unexpected behavior with the Reseam version, patch release, target app version, Android version, and relevant logs (with personal information removed).
- Never post signing keys, tokens, passwords, or private account data in issues.
- A signing key lets users identify a bundle publisher; it does not by itself guarantee that a patch is safe.

## Credits and licensing

This project uses the Reseam bundle template and preserves the upstream `NOTICE` and licensing terms. Reseam and its logos are trademarks or property of their respective owners; this project is independent and is not endorsed by the Reseam developers.

Individual patches may have their own upstream notices or license requirements. Those must be preserved, and third-party app code is not relicensed merely by being included here.
