// SPDX-License-Identifier: AGPL-3.0-or-later

package app.rj.hotstar.patches.mirroring

import app.reseam.patch.Type
import app.reseam.patch.method

internal val screenMirroringInit = method("screenMirroringInit") {
    returns(Type.Void)
    strings("Screen mirror/HDMI is not allowed")
}
