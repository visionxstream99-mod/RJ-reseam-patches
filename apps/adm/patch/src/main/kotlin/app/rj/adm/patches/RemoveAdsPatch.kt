package app.rj.adm.patches

import app.reseam.patch.CompatiblePackage
import app.reseam.patch.Type
import app.reseam.patch.alwaysReturn
import app.reseam.patch.method
import app.reseam.patch.patch

private val ADM = CompatiblePackage("com.dv.adm", listOf("7.6"))

/*
 * Reconstructed from the previously recovered RJ bundle's compiled class.
 * The anchors and call signatures below are historical observations from ADM 7.6.
 * A successful compile does not establish that each target is unique; run a Reseam
 * dry-run against the exact 7.6 APK before publishing this patch.
 */
private val admobBannerRequest = method("ADM AdMob banner request") {
    strings("10 Admob - request")
    returns(Type.Boolean)
    calls {
        owner("com.google.android.gms.ads.AdView")
        name("setAdUnitId")
        params(Type.String)
    }
}

private val admaxBannerRequest = method("ADM Admax banner request") {
    strings("10 Admax - request")
    returns(Type.Boolean)
    calls {
        owner("com.google.android.gms.ads.AdView")
        name("setAdUnitId")
        params(Type.String)
    }
}

private val appBrainBannerRequest = method("ADM AppBrain banner request") {
    strings("90 Appbrain - request")
    returns(Type.Void)
    calls {
        owner("com.appbrain.AppBrainBanner")
        name("setBannerListener")
    }
}

private val admobInterstitialRequest = method("ADM AdMob interstitial request") {
    strings("10 Admob - request")
    returns(Type.Boolean)
    calls {
        owner("com.google.android.gms.ads.f")
        name("a")
        params(Type.String)
    }
}

private val admaxInterstitialRequest = method("ADM Admax interstitial request") {
    strings("110 Admax - request")
    returns(Type.Boolean)
    calls {
        owner("com.google.android.gms.ads.f")
        name("a")
        params(Type.String)
    }
}

private val appBrainInterstitialRequest = method("ADM AppBrain interstitial request") {
    strings("90 Appbrain - request")
    returns(Type.Boolean)
    calls {
        owner("com.appbrain.g")
        name("a")
        params("android.content.Context")
    }
}

private val admobInterstitialShow = method("ADM AdMob interstitial show") {
    strings("15 Admob - show")
    returns(Type.Boolean)
    calls {
        owner("com.google.android.gms.ads.f")
        name("b")
        params()
    }
}

private val admaxInterstitialShow = method("ADM Admax interstitial show") {
    strings("115 Admax - show")
    returns(Type.Boolean)
    calls {
        owner("com.google.android.gms.ads.f")
        name("b")
        params()
    }
}

private val appBrainInterstitialShow = method("ADM AppBrain interstitial show") {
    strings("95 Appbrain - show")
    returns(Type.Boolean)
    calls {
        owner("com.appbrain.g")
        name("b")
        params("android.content.Context")
    }
}

private val editorAdCycle = method("ADM editor ad cycle") {
    strings("15 Admob - edit show")
    returns(Type.Void)
}

/**
 * Removes known ADM 7.6 AdMob, Admax and AppBrain banner/interstitial paths.
 *
 * This port preserves the behavior observed in the recovered RJ bundle. The
 * target selectors still require a dry-run against the exact app build.
 */
val removeAds = patch("Remove ads") {
    description("Disables ADM 7.6 AdMob, Admax, and AppBrain banner and interstitial ad paths.")
    compatibleWith(ADM)

    execute {
        admobBannerRequest.alwaysReturn(false)
        admaxBannerRequest.alwaysReturn(false)
        appBrainBannerRequest.before { returnVoid() }
        admobInterstitialRequest.alwaysReturn(false)
        admaxInterstitialRequest.alwaysReturn(false)
        appBrainInterstitialRequest.alwaysReturn(false)
        admobInterstitialShow.alwaysReturn(false)
        admaxInterstitialShow.alwaysReturn(false)
        appBrainInterstitialShow.alwaysReturn(false)
        editorAdCycle.before { returnVoid() }
    }
}
