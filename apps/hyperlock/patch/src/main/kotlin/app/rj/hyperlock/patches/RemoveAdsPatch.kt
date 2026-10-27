package app.rj.hyperlock.patches

import app.reseam.patch.CompatiblePackage
import app.reseam.patch.Type
import app.reseam.patch.before
import app.reseam.patch.klass
import app.reseam.patch.method
import app.reseam.patch.patch

private val HYPERLOCK = CompatiblePackage(
    "com.appiolab.hyperlockscreenos",
    listOf("0.1.2")
)

private val bannerAdLayout = klass("com.applovin.mediation.BannerAdLayout")
private val nativeAdLayout = klass("com.applovin.mediation.NativeAdLayout")
private val interstitialAdManager = klass("com.applovin.mediation.InterstitialAdManager")
private val adCallback = klass("com.applovin.mediation.InterstitialAdManager\$AdCallback")

private val continueWithoutAd = method("HyperLock ad-unavailable callback") {
    inClass(adCallback)
    name("c")
    params()
    returns(Type.Void)
}

/*
 * HyperLock 0.1.2 embeds a custom AppLovin BannerAdLayout that creates and loads
 * Google AdMob banners. The public loadAd(String) entry point is used by the
 * app's main, settings, gallery, splash, and lock-screen customization screens.
 */
private val loadBannerAd = method("HyperLock banner ad loader") {
    inClass(bannerAdLayout)
    name("loadAd")
    params(Type.String)
    returns(Type.Void)
}

/*
 * HyperLock's InterstitialAdManager wraps Google interstitial and rewarded-ad
 * loading/display. App screens call these methods to preload or show interstitials.
 * Match the stable owner and full parameter signatures, not obfuscated callers.
 */
private val loadNativeAd = method("HyperLock native ad loader") {
    inClass(nativeAdLayout)
    name("loadAd")
    params(Type.String)
    returns(Type.Void)
}

private val loadInterstitialAd = method("HyperLock interstitial ad loader") {
    inClass(interstitialAdManager)
    name("loadAd")
    params("android.app.Activity", Type.String)
    returns(Type.Void)
}

private val showInterstitialWithCount = method("HyperLock counted interstitial show") {
    inClass(interstitialAdManager)
    name("showAdWithCount")
    params(
        "android.app.Activity",
        Type.String,
        "com.applovin.mediation.InterstitialAdManager\$AdCallback"
    )
    returns(Type.Void)
}

private val showInterstitialWithRewardFallback = method("HyperLock interstitial/reward fallback") {
    inClass(interstitialAdManager)
    name("showAdWithRewardFallback")
    params(
        "android.app.Activity",
        Type.String,
        "com.applovin.mediation.InterstitialAdManager\$AdCallback"
    )
    returns(Type.Void)
}

private val showInterstitialWithoutCount = method("HyperLock uncounted interstitial show") {
    inClass(interstitialAdManager)
    name("showAdWithoutCount")
    params(
        "android.app.Activity",
        Type.String,
        "com.applovin.mediation.InterstitialAdManager\$AdCallback"
    )
    returns(Type.Void)
}

val removeAds = patch("Remove ads") {
    description(
        "Blocks HyperLock 0.1.2 banner, native, interstitial, and reward-fallback ad loading and display."
    )
    compatibleWith(HYPERLOCK)

    execute {
        loadBannerAd.before { returnVoid() }
        loadNativeAd.before { returnVoid() }
        loadInterstitialAd.before { returnVoid() }
        showInterstitialWithCount.before {
            val callback = param(2)
            whenNotNull(callback) {
                callback.call(continueWithoutAd)
            }
            returnVoid()
        }
        showInterstitialWithRewardFallback.before {
            val callback = param(2)
            whenNotNull(callback) {
                callback.call(continueWithoutAd)
            }
            returnVoid()
        }
        showInterstitialWithoutCount.before {
            val callback = param(2)
            whenNotNull(callback) {
                callback.call(continueWithoutAd)
            }
            returnVoid()
        }
    }
}
