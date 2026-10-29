# RJ Reseam Patches (v0.1.3)

Custom [Reseam](https://reseam.app) patch bundle for **Advanced Download Manager (ADM)**, **AdGuard**, **Facebook**, **JioHotstar**, **HyperLock**, **Anixart**, **Pinterest**, and **GBoard**.

Built with the latest **Reseam Engine v0.45.0** (Engine `0.34.0`) supporting Kotlin DSL transformations, `@Export` DEX extensions, and native Seccomp integrity bypass.

---

## 🚀 Quick Usage

```bash
# Apply all default patches using Reseam CLI
reseam patch \
  --trust d16834e29b664ab59f5cc8c0b2ce47dfe3620fe8debeb0ddf74d673a68136294 \
  --bundle rj-reseam-patches \
  --output-dir ./output_splits \
  target_app.apk
```

---

## 📦 Supported Apps & Patch Index

### 🔹 1. Facebook (`com.facebook.katana`)
- **Facebook Extension Core** (`top.madkarma.patches.facebook.facebookExtensionPatch`): Initializes runtime context & logger.
- **Hide sponsored posts** (`top.madkarma.patches.facebook.hideSponsoredPosts`): Removes sponsored feed edges and multi-ads.
- **Hide affiliate product links** (`top.madkarma.patches.facebook.hideAffiliateLinks`): Strips shop CTAs and affiliate product overlays.
- **Disable Audience Network** (`top.madkarma.patches.facebook.disableAudienceNetwork`): Neutralizes Audience Network manifest activities & runtime state setters.

### 🔹 2. JioHotstar (`in.startv.hotstar`)
- **Premium unlock** (`app.rj.hotstar.patches.premium.premiumUnlock`): Unlocks premium UI, MyPage subscription status, and download capabilities.
- **Remove ads** (`app.rj.hotstar.patches.ads.removeAds`): Removes video pre-roll/mid-roll ads and banner promotions.
- **Enable all codecs** (`app.rj.hotstar.patches.playback.enableAllCodecs`): Unlocks H265/HEVC, VP9, AV1, and 4K playback.
- **Force HDR10** (`app.rj.hotstar.patches.playback.forceHdr10`): Forces HDR10 and HDR10+ rendering.
- **Enable screen mirroring** (`app.rj.hotstar.patches.mirroring.enableScreenMirroring`): Bypasses HDMI/Display cast blocking.
- **Enable screenshot** (`app.rj.hotstar.patches.screenshot.enableScreenshot`): Clears `FLAG_SECURE` to allow screenshots and screen recording.
- **Signature bypass** (`app.rj.hotstar.patches.integrity.signatureBypass`): Bypasses signature & integrity verification.

### 🔹 3. Advanced Download Manager (`com.dv.adm`)
- **Remove ads** (`app.rj.adm.patches.removeAds`): Neutralizes Appodeal Mediation, AppLovin MAX, Pangle, and AdMob banner/interstitial ads in ADM 14.x.

### 🔹 4. AdGuard (`com.adguard.android`)
- **Unlock Lifetime premium** (`top.madkarma.patches.adguard.lifetime.unlockLifetime`): Enables Family Lifetime Premium license.
- **Skip setup** (`top.madkarma.patches.adguard.setup.skipSetup`): Skips onboarding and pre-configures filter rules.

---

## 🛠️ Building From Source

```powershell
# Compile all patch DEX modules & extension JARs
./gradlew build
```

---

## 📄 Release & Index Verification
- **Release Index:** `patches.json`
- **Signer Fingerprint:** `d16834e29b664ab59f5cc8c0b2ce47dfe3620fe8debeb0ddf74d673a68136294`
- **License:** AGPL-3.0 / GPL-3.0
