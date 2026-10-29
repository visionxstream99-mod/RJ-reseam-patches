// SPDX-License-Identifier: AGPL-3.0-or-later

package app.rj.hotstar.patches.playback

import app.reseam.patch.Type
import app.reseam.patch.klass
import app.reseam.patch.methods

internal val isDeviceBlacklisted = methods("isDeviceBlacklisted") {
    returns(Type.Boolean)
    params(Type.String, Type.Map)
    strings("blacklistedDevices")
}
