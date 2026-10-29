// SPDX-License-Identifier: AGPL-3.0-or-later

@file:Suppress("unused")

package app.rj.hyperlock.patches

import app.reseam.patch.before
import app.reseam.patch.patch

val unlockPremium = patch("Unlock Premium") {
    description("Unlocks all PRO/VIP lock screen styles, custom fonts, wallpapers, and AOD features.")
    compatibleWith("com.appiolab.hyperlockscreenos")

    execute {
        isPremiumCachedMethod.before {
            returnValue(bool(true))
        }

        log.info("Premium: Unlocked all PRO features and disabled paywalls.")
    }
}
