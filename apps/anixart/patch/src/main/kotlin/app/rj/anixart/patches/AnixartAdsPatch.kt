// SPDX-License-Identifier: GPL-3.0-or-later
// RJ's Reseam-native port for Anixart 10.5.
// The target behavior and fingerprint research were informed by
// Error404rt/Anixart-patches (GPLv3): https://github.com/Error404rt/Anixart-patches
// This file is a new Reseam implementation; it is not copied Morphe source.

package app.rj.anixart.patches

import app.reseam.patch.*

private val ANIXART = "com.swiftsoft.anixartd"("10.5")
private val displayCompat = klass("com.swiftsoft.anixartd.utils.ui.DisplayCompat")
private val episodesFragment = klass("com.swiftsoft.anixartd.ui.fragment.main.episodes.EpisodesFragment")
private val kodikActivity = klass("com.swiftsoft.anixartd.ui.activity.kodik.KodikAdActivity")

/*
 * Anixart's own suppression predicate hides the programmatic banner strip.
 * Class, return type, and parameter signature are constrained to avoid relying
 * on the obfuscated method name. Still requires a dry-run against Anixart 10.5.
 */
private val adsSuppressed = method("Anixart ad-suppression predicate") {
    inClass(displayCompat)
    params("android.content.ContextWrapper")
    returns(Type.Boolean)
}

/*
 * These callers are identified by the Yandex loader/player calls they contain.
 * Requiring the package's EpisodesFragment class keeps the match app-specific.
 */
private val interstitialLoad = method("Anixart Yandex interstitial load") {
    inClass(episodesFragment)
    returns(Type.Void)
    calls {
        owner("com.yandex.mobile.ads.interstitial.InterstitialAdLoader")
        name("loadAd")
    }
}

private val interstitialShow = method("Anixart Yandex interstitial show") {
    inClass(episodesFragment)
    returns(Type.Void)
    calls {
        owner("com.yandex.mobile.ads.interstitial.InterstitialAd")
        name("show")
    }
}

/*
 * KodikAdActivity must run super.onCreate first, then call advertEnded before
 * the layout/player WebView is initialized. The original callback is retained
 * so the player can continue rather than leaving an empty ad screen.
 */
private val kodikOnCreate = method("Anixart Kodik ad activity onCreate") {
    inClass(kodikActivity)
    name("onCreate")
    params("android.os.Bundle")
    returns(Type.Void)
    strings("KodikInterface")
}

private val kodikAdvertEnded = method("Anixart Kodik ad completion callback") {
    inClass(kodikActivity)
    name("advertEnded")
    params()
    returns(Type.Void)
}

private val kodikLayoutInflater = kodikOnCreate.point("Kodik ad activity layout setup") {
    invokeVirtual {
        owner("android.app.Activity")
        name("getLayoutInflater")
        params()
        returns("android.view.LayoutInflater")
    }
}

/*
 * The one-time Kodik information prompt reads a SharedPreferences boolean.
 * Reseam redirects only that call site to this small helper, which returns true.
 * The helper's first parameter is the receiver, as required when redirecting an
 * instance invoke to a static extension method.
 */
private val anixartHooks = ExtClass("app.rj.anixart.extension.AnixartAdHooks")
private val alwaysTruePreference by anixartHooks.static(
    "android.content.SharedPreferences",
    Type.String,
    Type.Boolean,
    returns = Type.Boolean,
    name = "alwaysTruePreference"
)

private val kodikShow = method("Anixart Kodik playback launch") {
    inClass(episodesFragment)
    name("onShowKodikAd")
    paramCount(3)
    returns(Type.Void)
}

private val kodikDisclaimerRead = kodikShow.points("Kodik information preference") {
    invokeInterface {
        owner("android.content.SharedPreferences")
        name("getBoolean")
        params(Type.String, Type.Boolean)
        returns(Type.Boolean)
    }
}

val removeAds = patch("Remove ads") {
    description("Removes banner, interstitial, and Kodik pre-roll ads from Anixart 10.5.")
    compatibleWith(ANIXART)

    val removeBannerAds = boolOption(
        key = "removeBannerAds",
        title = "Banner ads",
        description = "Hides the bottom banner and its ad label.",
        default = true
    )
    val removeInterstitialAds = boolOption(
        key = "removeInterstitialAds",
        title = "Interstitial ads",
        description = "Stops Yandex interstitial ads from loading or showing.",
        default = true
    )
    val removeKodikPreRoll = boolOption(
        key = "removeKodikPreRoll",
        title = "Kodik pre-roll ads",
        description = "Ends the Kodik ad activity before the ad player initializes and skips its one-time information prompt.",
        default = true
    )

    execute {
        if (options[removeBannerAds]) {
            adsSuppressed.alwaysReturn(true)
        }

        if (options[removeInterstitialAds]) {
            interstitialLoad.before { returnVoid() }
            interstitialShow.before { returnVoid() }
        }

        if (options[removeKodikPreRoll]) {
            alwaysTruePreference.implement { returnTrue() }

            kodikLayoutInflater.before {
                thisObject.call(kodikAdvertEnded)
                returnVoid()
            }

            kodikDisclaimerRead.single().redirectTo(alwaysTruePreference)
        }
    }
}
