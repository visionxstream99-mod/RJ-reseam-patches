// SPDX-License-Identifier: AGPL-3.0-or-later

@file:Suppress("unused")

package app.rj.hotstar.patches.screenshot

import app.reseam.patch.alwaysReturn
import app.reseam.patch.before
import app.reseam.patch.patch

val enableScreenshot = patch("Enable screenshots") {
    description("Removes screenshot and screen recording restrictions.")
    compatibleWith("in.startv.hotstar")

    execute {
        useSecureView.alwaysReturn(false)

        composeFlagSecure.before {
            returnVoid()
        }
    }
}
