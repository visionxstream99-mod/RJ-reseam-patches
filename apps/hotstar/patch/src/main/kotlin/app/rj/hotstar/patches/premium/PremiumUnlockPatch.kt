// SPDX-License-Identifier: AGPL-3.0-or-later

@file:Suppress("unused")

package app.rj.hotstar.patches.premium

import app.reseam.patch.alwaysReturn
import app.reseam.patch.before
import app.reseam.patch.patch

val premiumUnlock = patch("Premium unlock") {
    description("Unlocks premium UI features, removes subscription nudges, and enables downloads.")
    compatibleWith("in.startv.hotstar")

    execute {
        isUserSubscribed.alwaysReturn(true)
    }
}
