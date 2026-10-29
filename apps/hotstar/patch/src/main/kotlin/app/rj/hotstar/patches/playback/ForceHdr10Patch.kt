// SPDX-License-Identifier: AGPL-3.0-or-later

@file:Suppress("unused")

package app.rj.hotstar.patches.playback

import app.reseam.patch.alwaysReturn
import app.reseam.patch.patch

val forceHdr10 = patch("Force HDR10") {
    description("Forces HDR10 and HDR10+ playback on compatible devices by bypassing blacklist and capability checks.")
    compatibleWith("in.startv.hotstar")

    execute {
        isBlacklistedHdr.all.forEach { it.alwaysReturn(false) }
    }
}
