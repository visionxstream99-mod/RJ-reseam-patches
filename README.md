<div align="center">
  <img src="https://avatars.githubusercontent.com/u/256498752?v=4" width="112" height="112" alt="RJ profile logo" />
  <h1>RJ Reseam Patches</h1>
  <p><strong>Community Android patches, maintained by RJ.</strong></p>
  <p>
    <a href="https://reseam.app">Reseam</a> ·
    <a href="https://github.com/visionxstream99-mod/RJ-reseam-patches/releases">Releases</a> ·
    <a href="https://github.com/visionxstream99-mod/RJ-reseam-patches/blob/main/patches.json">Patch index</a> ·
    <a href="https://awesome-reseam.vercel.app/">Awesome Reseam</a>
  </p>
</div>

---

## About

RJ Reseam Patches is a community patch bundle for supported Android apps. The repository publishes the signed **.reseam** bundle and its **patches.json** index; source and development work may be maintained separately.

## Supported apps

| App | Android package | Patch coverage |
|---|---|---|
| **Advanced Download Manager (ADM)** | **com.dv.adm** | Ad-removal patch |
| **AdGuard** | **com.adguard.android** | Lifetime-license and setup patches |
| **Facebook** | **com.facebook.katana** | Extension core, sponsored-post filtering, affiliate-link filtering, Audience Network controls |
| **JioHotstar** | **in.startv.hotstar** | Premium UI, ads, playback codecs/HDR, mirroring, screenshots and integrity-related patches |
| **Anixart** | Check the bundle index | Included in the project catalog |
| **Pinterest** | Check the bundle index | Included in the project catalog |
| **HyperLock** | Check the bundle index | Included in the project catalog |

The available patches and compatibility can change between releases. Check the release notes and inspect the patch manager's compatibility information before applying a patch.

## Install

1. Open [Releases](https://github.com/visionxstream99-mod/RJ-reseam-patches/releases).
2. Download the latest **.reseam** bundle asset.
3. Import it into a compatible Reseam manager, following that manager's trust and installation prompts.
4. Select only patches compatible with your installed app version.

**Important:** Patch availability does not guarantee compatibility with every app version or Android device. Keep a backup of important data and review what each patch changes before applying it.

## Patch index

The machine-readable index is [patches.json](./patches.json). It contains bundle metadata, release information, patch IDs, default states, dependencies, and compatibility declarations.

## Build from source

If you have the project source and its required build tools installed:

```bash
./gradlew build
```

Build tasks and requirements may vary by source revision.

## Releases

See the [release history](https://github.com/visionxstream99-mod/RJ-reseam-patches/releases) for downloadable bundles and version-specific notes. Use the matching release's assets rather than an unrelated or older bundle.

## Credits and licensing

- Built for the [Reseam](https://reseam.app) patch ecosystem.
- Individual patch implementations may have their own upstream origins and licenses. Check the source and license files for the terms that apply to each component.
- RJ Reseam Patches is a community project and is not an official Reseam product.

---

<div align="center">
  <sub>Maintained by <a href="https://github.com/visionxstream99-mod">RJ</a> · Community patches for Android</sub>
</div>
