<div align="center">

<a href="https://github.com/visionxstream99-mod"><img src="https://avatars.githubusercontent.com/u/256498752?v=4" width="112" height="112" alt="RJ profile logo" /></a>

# RJ Reseam Patches

**Small changes. Your apps. Your choice.**

A curated collection of Android patches for [Reseam](https://reseam.app), maintained by **RJ**.

<a href="https://reseam.app/add/?url=https%3A%2F%2Fgithub.com%2Fvisionxstream99-mod%2FRJ-reseam-patches"><img src="https://img.shields.io/badge/Add%20to-Reseam-20252d?style=for-the-badge&logo=android&logoColor=white" alt="Add to Reseam" /></a>
<a href="https://github.com/visionxstream99-mod/RJ-reseam-patches/releases/latest"><img src="https://img.shields.io/badge/Download-Latest%20Release-20252d?style=for-the-badge&logo=github&logoColor=white" alt="Latest release" /></a>

[![Latest release](https://img.shields.io/github/v/release/visionxstream99-mod/RJ-reseam-patches?style=flat-square&label=release)](https://github.com/visionxstream99-mod/RJ-reseam-patches/releases/latest)
[![Build validation](https://img.shields.io/github/actions/workflow/status/visionxstream99-mod/RJ-reseam-patches/validate.yml?branch=main&style=flat-square&label=build)](https://github.com/visionxstream99-mod/RJ-reseam-patches/actions/workflows/validate.yml)
[![License](https://img.shields.io/badge/license-AGPL--3.0--or--later-555?style=flat-square)](LICENSE)

</div>

---

## Apps & patches

Each app is shown once, with its patches grouped below it. App artwork links to the corresponding Google Play listing where one is available.

<table>
<tr>
<td width="100" align="center" valign="top">
<a href="https://play.google.com/store/apps/details?id=com.dv.adm"><img src="https://img.utdstc.com/icon/965/fa8/965fa8da7fc5018960cb7cd0ef78fd8ff88eff6ad41b661cb352f34650a95644:600" width="76" height="76" alt="Advanced Download Manager icon" /></a>
</td>
<td valign="top">

### [Advanced Download Manager](https://play.google.com/store/apps/details?id=com.dv.adm)
<sub><code>com.dv.adm</code></sub>

- **Remove ads** — Disables Appodeal, AppLovin MAX, Pangle, and AdMob ad paths in ADM 14.x.

</td>
</tr>
<tr>
<td width="100" align="center" valign="top">
<a href="https://play.google.com/store/apps/details?id=com.facebook.katana"><img src="https://images.tenorshare.com/topics/change-location/facebookmarketplace-3.jpg?h=500&w=635" width="76" height="76" alt="Facebook app icon" /></a>
</td>
<td valign="top">

### [Facebook](https://play.google.com/store/apps/details?id=com.facebook.katana)
<sub><code>com.facebook.katana</code></sub>

- **Facebook Extension Core** — Initializes the runtime extension.
- **Hide sponsored posts** — Filters sponsored and promoted feed content.
- **Hide affiliate product links** — Removes shopping cards and affiliate overlays.
- **Disable Audience Network** — Disables Audience Network components.

</td>
</tr>
<tr>
<td width="100" align="center" valign="top">
<a href="https://play.google.com/store/apps/details?id=in.startv.hotstar"><img src="https://bestmediainfo.com/mediainfo/mediainfo-digital/jiohotstar-crosses-1-billion-downloads-emerges-as-indias-closest-challenger-to-netflix-10646943" width="76" height="76" alt="JioHotstar on Google Play" /></a>
</td>
<td valign="top">

### [JioHotstar](https://play.google.com/store/apps/details?id=in.startv.hotstar)
<sub><code>in.startv.hotstar</code></sub>

- **Premium unlock** — Changes premium UI and subscription-state checks.
- **Remove ads** — Removes supported in-stream ad and banner-promotion paths.
- **Enable all codecs** — Enables additional playback codec and capability paths.
- **Force HDR10** — Forces HDR10 playback selection.
- **Enable screen mirroring** — Allows playback during supported mirroring / HDMI use.
- **Enable screenshot** — Removes the app's secure-window restriction.
- **Signature bypass** — Alters supported app integrity checks.

</td>
</tr>
</table>

<sub>Other app work in the repository: Anixart, Pinterest, and HyperLock. Their source and notes remain in their respective app folders; they are not listed as part of the current v0.1.3 release manifest. Gboard is intentionally not included.</sub>

## Install

1. Install [Reseam Manager](https://reseam.app).
2. Select **Add to Reseam** above, or add this source manually:
   `https://github.com/visionxstream99-mod/RJ-reseam-patches`
3. Find your app, review the patch description and options, then apply the patch.
4. Check the app version and compatibility notes before patching.

You can also download the signed `.reseam` bundle and `patches.json` from the [latest release](https://github.com/visionxstream99-mod/RJ-reseam-patches/releases/latest).

## Compatibility & testing

A successful build confirms that the bundle compiles. It does **not** prove that every patch applies to every app version or works correctly at runtime. Compatibility can change when an app updates.

For failures, open an [issue](https://github.com/visionxstream99-mod/RJ-reseam-patches/issues) and include the app version, package name, patch name, Android version, Reseam version, and relevant logs. Remove personal information before posting.

## Repository

| Path | Contents |
|---|---|
| `apps/` | App-specific patch source |
| `patches.json` | Release catalogue and patch metadata |
| `manifest.toml` | Bundle metadata |
| `PATCHES.md` | Patch index and implementation notes |
| `.github/workflows/` | Build validation and release automation |

## Credits & scope

RJ Reseam Patches is an independent community project and is not affiliated with Reseam or the developers of the target apps. App names and artwork belong to their respective owners.

Patches may stop working after app updates. Review each patch before applying it and keep backups of important data.

---

<div align="center">

*Maintained by RJ · Built for Reseam.*

</div>
