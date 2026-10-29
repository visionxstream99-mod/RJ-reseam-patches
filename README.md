<div align="center">

<a href="https://github.com/visionxstream99-mod" title="RJ's GitHub profile">
  <img src="https://github.com/visionxstream99-mod.png?size=256" width="112" height="112" alt="RJ's GitHub profile picture">
</a>

# RJ Reseam Patches

**Small changes. Your apps. Your choice.**

Independent Android patches by RJ, built for [Reseam](https://reseam.app).

[Browse patches](#patches) · [Install](#install) · [Releases](https://github.com/visionxstream99-mod/RJ-reseam-patches/releases) · [Report an issue](https://github.com/visionxstream99-mod/RJ-reseam-patches/issues)

[![Latest release](https://img.shields.io/github/v/release/visionxstream99-mod/RJ-reseam-patches?display_name=tag&style=flat-square)](https://github.com/visionxstream99-mod/RJ-reseam-patches/releases/latest)
[![Build](https://img.shields.io/github/actions/workflow/status/visionxstream99-mod/RJ-reseam-patches/validate.yml?branch=main&label=build&style=flat-square)](https://github.com/visionxstream99-mod/RJ-reseam-patches/actions/workflows/validate.yml)
[![License](https://img.shields.io/badge/license-see%20manifest-lightgrey?style=flat-square)](manifest.toml)

</div>

---

## Patches

A focused collection of patches for Android apps. Each patch has a specific target; compatibility depends on the app version and the patch itself.

| App | Patch | Target | Notes |
|---|---|---|---|
| **Advanced Download Manager** | Remove ads | `com.dv.adm` · 7.6 (70620) | Built successfully; APK and runtime testing still needed |
| **Anixart** | Remove ads | `com.swiftsoft.anixartd` · 10.5 | Includes separate options for banner ads, interstitial ads, and Kodik prompts; APK and runtime testing still needed |
| **Pinterest** | First-pass privacy controls (4 patches) | `com.pinterest` · 14.42.0 (14428010) | Build passes; exact-target application and runtime tests pending |
| **HyperLock Screen & AOD** | Remove ads | `com.appiolab.hyperlockscreenos` · 0.1.2 | Exact-target patch application previously passed; device runtime testing pending |
| **HyperLock Screen & AOD** | Customize HyperLock (3 options) | `com.appiolab.hyperlockscreenos` · 0.1.2 | Optional clock/depth/parallax overrides; runtime testing pending |

Anixart Lite is **not** included in the Anixart target. Pinterest is pinned to 14.42.0 and HyperLock to 0.1.2; don't assume other versions are compatible.

Patch IDs, implementation notes, and current verification details are documented in [PATCHES.md](PATCHES.md). Pinterest's manifest findings and deferred work are recorded in [docs/PINTEREST-14.42.0.md](docs/PINTEREST-14.42.0.md); HyperLock target notes are in [apps/hyperlock/README.md](apps/hyperlock/README.md).

## Install

1. Install **[Reseam Manager](https://reseam.app)** from the official Reseam website.
2. **[Add RJ Reseam Patches](https://reseam.app/add/?url=https%3A%2F%2Fgithub.com%2Fvisionxstream99-mod%2FRJ-reseam-patches)**, or open the source-add flow in Reseam Manager and enter this repository URL:
   `https://github.com/visionxstream99-mod/RJ-reseam-patches`
3. Choose a patch that matches your app version, review its options, then apply it.
4. If Reseam shows a compatibility warning, stop and check the patch notes rather than forcing it.

You can also get the signed bundle and catalogue from the [latest release](https://github.com/visionxstream99-mod/RJ-reseam-patches/releases/latest). Pinterest and HyperLock remain experimental until the exact-target and runtime checks listed in their notes are complete.

## Compatibility & testing

A successful build means the patch bundle compiles. It does **not** prove that a patch works with a particular APK or behaves correctly at runtime.

A successful compile does not prove runtime behavior. Pinterest has not yet passed exact-target patch application or runtime tests. HyperLock passed exact-target dry-run/application checks against version 0.1.2, but has not had a device runtime test. Treat untested patches as **experimental**.

If something fails, open an [issue](https://github.com/visionxstream99-mod/RJ-reseam-patches/issues) and include:

- The patch release and patch name
- The target app version and package name
- Your Android version and Reseam version
- The relevant error or log, with personal information removed

Please don't post private signing keys, passwords, access tokens, or other secrets.

## Build from source

### Requirements

- JDK 17
- Android SDK and `ANDROID_HOME` configured
- The Gradle wrapper included in this repository
- A Reseam CLI version compatible with the workspace plugin
- A signing key for signed release builds

### Build and inspect

```sh
./gradlew bundle
reseam bundle list build/reseam/rj-reseam-patches.reseam
```

The generated bundle is written under `build/reseam/`. The [validation workflow](.github/workflows/validate.yml) builds the bundle and checks the expected patch IDs. It does not replace testing against real APKs.

### Releases

Releases are published through [GitHub Actions](.github/workflows/release.yml), either from a version tag (`v*`) or by manually running the release workflow.

The release workflow uses the repository secret `BUNDLE_SIGNING_KEY_B64`. Keep the corresponding private key secure: never commit it, upload it to an issue, or share it publicly. A signing key identifies the publisher; it is not a guarantee that every patch is safe or compatible.

## Repository map

```text
manifest.toml                             Bundle metadata
apps/adm/patch/                           ADM patch source
apps/anixart/patch/                       Anixart patch source
apps/anixart/extensions/anixart/          Anixart helper hooks
apps/pinterest/patch/                     Pinterest manifest patches
apps/pinterest/README.md                  Pinterest target and verification notes
apps/hyperlock/patch/                     HyperLock ad-removal and customization patches
apps/hyperlock/README.md                  HyperLock target and verification notes
apps/anixart/LICENSE                      Third-party license and attribution
docs/PINTEREST-14.42.0.md                 Pinterest APK analysis and release gate
docs/RELEASE_CHECKLIST.md                 Release and APK test checklist
.github/workflows/validate.yml            Build validation
.github/workflows/release.yml             Release publishing
PATCHES.md                                Patch catalogue and verification notes
NOTICE                                    Third-party notices and terms
```

For patch-author documentation, start with the [Reseam authoring guide](https://reseam.app/docs/authoring/start/) and [first patch guide](https://reseam.app/docs/authoring/first_patch/).

## Credits & licensing

RJ Reseam Patches is an independent community project. It is not affiliated with or endorsed by the Reseam developers. Reseam names and logos belong to their respective owners; see the upstream project for its own terms.

The Anixart patch is a Reseam-native implementation informed by the public target and behavior notes in [Error404rt/Anixart-patches](https://github.com/Error404rt/Anixart-patches). Its GPLv3 license and attribution are included in [apps/anixart/LICENSE](apps/anixart/LICENSE) and [apps/anixart/README.md](apps/anixart/README.md). Third-party app code is not included.

---

<sub>Maintained by RJ · Read the patch notes, check compatibility, and keep a copy of important app data before patching.</sub>