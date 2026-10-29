// SPDX-License-Identifier: AGPL-3.0-or-later

@file:Suppress("unused")

package app.rj.hotstar.patches.playback

import app.reseam.patch.alwaysReturn
import app.reseam.patch.patch

val enableAllCodecs = patch("Enable all codecs") {
    description("Enables all video codecs (H265, VP9, AV1) and 4K resolution by bypassing blacklist and capability checks.")
    compatibleWith("in.startv.hotstar")

    execute {
        isBlacklistedCodec.all.forEach { it.alwaysReturn(false) }
        isDeviceCodecCapable.alwaysReturn(true)
    }
}
