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
private val appOpenManager = klass("com.applovin.mediation.AppOpenManager")
private val adCallback = klass("com.applovin.mediation.InterstitialAdManager\$AdCallback")

/*
 * Confirmed in HyperLock 0.1.2 base.dex. c() is the regular interstitial
 * no-ad callback; a() is the no-ad callback used by showAdWithRewardFallback.
 * Preserve this distinction so the patch doesn't send the wrong completion.
 */
private val continueWithoutAd = method("HyperLock interstitial no-ad callback") {
    inClass(adCallback)
    name("c")
    params()
    returns(Type.Void)
}

private val continueWithRewardFallbackNoAd = method("HyperLock fallback no-ad callback") {
    inClass(adCallback)
    name("a")
    params()
    returns(Type.Void)
}

/*
 * Verified in the supplied HyperLock 0.1.2 base.dex:
 * BannerAdLayout.loadAd(String), NativeAdLayout.loadAd(String),
 * InterstitialAdManager.loadAd(Activity,String), its three show entry points,
 * and AppOpenManager.b() (which loads the Google app-open ad).
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

private val loadAppOpenAd = method("HyperLock app-open ad loader") {
    inClass(appOpenManager)
    name("b")
    params()
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
        "Removes HyperLock 0.1.2 banner, native, interstitial, and app-open ads while preserving Play Store validation and purchase/entitlement checks."
    )
    compatibleWith(HYPERLOCK)

    execute {
        loadBannerAd.before {
            thisObject.callVirtual("android.view.View", "setVisibility", "(I)V", int(8))
            returnVoid()
        }

        loadNativeAd.before {
            thisObject.callVirtual("android.view.View", "setVisibility", "(I)V", int(8))
            returnVoid()
        }

        loadInterstitialAd.before { returnVoid() }
        loadAppOpenAd.before { returnVoid() }

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
                callback.call(continueWithRewardFallbackNoAd)
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
