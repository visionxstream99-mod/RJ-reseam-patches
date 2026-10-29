// SPDX-License-Identifier: AGPL-3.0-or-later

package app.rj.hotstar.patches.playback

import app.reseam.patch.Type
import app.reseam.patch.method
import app.reseam.patch.methods

internal val isBlacklistedCodec = methods("isBlacklistedCodec") {
    returns(Type.Boolean)
    strings("HEVC", "is_blacklisted")
}

internal val isBlacklistedHdr = methods("isBlacklistedHdr") {
    returns(Type.Boolean)
    strings("HDR10", "is_blacklisted")
}

internal val isDeviceCodecCapable = method("isDeviceCodecCapable") {
    returns(Type.Boolean)
    strings("is_device_capable")
}
