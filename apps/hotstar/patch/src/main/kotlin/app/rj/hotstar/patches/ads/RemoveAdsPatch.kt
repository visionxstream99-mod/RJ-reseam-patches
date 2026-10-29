// SPDX-License-Identifier: AGPL-3.0-or-later

@file:Suppress("unused")

package app.rj.hotstar.patches.ads

import app.reseam.patch.before
import app.reseam.patch.patch

val removeAds = patch("Remove ads") {
    description("Removes pre-roll, mid-roll, and live match video ads.")
    compatibleWith("in.startv.hotstar")

    execute {
        adMetadataConstructor.before {
            param(0).assign(bool(true))
            param(1).assign(bool(true))
            param(2).assign(bool(false))
            param(3).assign(bool(false))
            param(4).assign(bool(false))
            param(5).assign(string(""))
        }

        watchLiveAdsInit.before {
            returnVoid()
        }

        displayAdComposable.before {
            returnVoid()
        }

        sgaiPrefetcherGetAd.before {
            val emptyList = callStatic("java/util/Collections", "emptyList", "()Ljava/util/List;")
            returnValue(emptyList)
        }

        liveAdsManagerProcess.before {
            returnValue(staticField(kotlinUnitField))
        }
    }
}
