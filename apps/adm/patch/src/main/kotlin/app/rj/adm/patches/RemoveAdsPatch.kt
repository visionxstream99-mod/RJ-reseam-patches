// SPDX-License-Identifier: AGPL-3.0-or-later

package app.rj.adm.patches

import app.reseam.patch.Type
import app.reseam.patch.alwaysReturn
import app.reseam.patch.before
import app.reseam.patch.klass
import app.reseam.patch.methods
import app.reseam.patch.patch

// Appodeal Mediation Ad Framework (ADM 14.x)
internal val appodealShow = methods("appodealShow") {
    inClass(klass("com.appodeal.ads.Appodeal"))
    custom { name == "show" }
}

internal val appodealCanShow = methods("appodealCanShow") {
    inClass(klass("com.appodeal.ads.Appodeal"))
    custom { name == "canShow" }
}

internal val appodealIsLoaded = methods("appodealIsLoaded") {
    inClass(klass("com.appodeal.ads.Appodeal"))
    custom { name == "isLoaded" }
}

internal val appodealInitialize = methods("appodealInitialize") {
    inClass(klass("com.appodeal.ads.Appodeal"))
    custom { name == "initialize" }
}

// Google AdMob / BaseAdView
internal val baseAdViewLoadAd = methods("baseAdViewLoadAd") {
    inClass(klass("com.google.android.gms.ads.BaseAdView"))
    custom { name == "loadAd" }
}

/**
 * Disables Appodeal, AppLovin MAX, Pangle, and AdMob banner and interstitial ad paths for ADM 14.x.
 */
val removeAds = patch("Remove ads") {
    description("Disables Appodeal, AppLovin MAX, Pangle, and AdMob ad paths in ADM 14.x.")
    compatibleWith("com.dv.adm")

    execute {
        appodealShow.all.forEach { it.alwaysReturn(false) }
        appodealCanShow.all.forEach { it.alwaysReturn(false) }
        appodealIsLoaded.all.forEach { it.alwaysReturn(false) }
        appodealInitialize.all.forEach { it.before { returnVoid() } }
        baseAdViewLoadAd.all.forEach { it.before { returnVoid() } }
    }
}
