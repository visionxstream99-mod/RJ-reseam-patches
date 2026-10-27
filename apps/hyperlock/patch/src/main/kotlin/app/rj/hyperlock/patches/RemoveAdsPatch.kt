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
private val appOpenManager = klass("com.applovin.mediation.AppOpenManager")

private val continueWithoutAd = method("HyperLock ad-unavailable callback") {
    inClass(adCallback)
    name("c")
    params()
    returns(Type.Void)
}

/*
 * Confirmed in HyperLock 0.1.2's base.dex:
 * BannerAdLayout.loadAd(String), NativeAdLayout.loadAd(String), and the
 * InterstitialAdManager load/show methods are present with these signatures.
 */
private val loadBannerAd = method("HyperLock banner ad loader") {
    inClass(bannerAdLayout)
    name("loadAd")
    params(Type.String)
    returns(Type.Void)
}

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

/*
 * AppOpenManager is present in the supplied 0.1.2 base APK and implements
 * ActivityLifecycleCallbacks. Prevent its resume hook from triggering
 * app-open ads without touching Play Store validation or premium purchase logic.
 */
private val appOpenActivityResumed = method("HyperLock app-open ad lifecycle hook") {
    inClass(appOpenManager)
    name("onActivityResumed")
    params("android.app.Activity")
    returns(Type.Void)
}

val removeAds = patch("Remove ads") {
    description(
        "Blocks HyperLock 0.1.2 banner, native, interstitial, and app-open ad entry points. Does not modify purchase or Play Store validation."
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
        appOpenActivityResumed.before { returnVoid() }
    }
}
