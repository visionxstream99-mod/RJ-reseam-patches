// SPDX-License-Identifier: AGPL-3.0-or-later

@file:Suppress("unused")

package app.rj.hyperlock.patches

import app.reseam.patch.before
import app.reseam.patch.patch

val removeAds = patch("Remove Ads") {
    description("Removes all banner, interstitial, and native ads and hides ad loading containers.")
    compatibleWith("com.appiolab.hyperlockscreenos")

    execute {
        loadBannerAdMethod.before {
            callStatic("com/applovin/mediation/BannerAdLayout", "c", "(Lcom/applovin/mediation/BannerAdLayout;Ljava/lang/String;)V", thisObject, param(0))
            returnVoid()
        }

        loadNativeAdMethod.before {
            returnVoid()
        }

        loadInterstitialAdMethod.before {
            returnVoid()
        }

        log.info("Ads: Neutralized ad loaders and hid ad containers.")
    }
}
