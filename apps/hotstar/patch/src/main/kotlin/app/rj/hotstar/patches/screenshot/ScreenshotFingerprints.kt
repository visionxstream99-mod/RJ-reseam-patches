// SPDX-License-Identifier: AGPL-3.0-or-later

package app.rj.hotstar.patches.screenshot

import app.reseam.patch.Type
import app.reseam.patch.klass
import app.reseam.patch.method

internal val useSecureView = klass("com.hotstar.player.models.config.ABConfig").method("getUseSecureView")

internal val composeFlagSecure = method("composeFlagSecure") {
    returns(Type.Void)
    strings("null cannot be cast to non-null type android.app.Activity")
    calls {
        owner("android.view.Window")
        name("addFlags")
    }
}
