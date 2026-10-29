// SPDX-License-Identifier: AGPL-3.0-or-later

package app.rj.facebook.patches

import app.reseam.patch.before
import app.reseam.patch.patch
import app.rj.facebook.extensions.bindings.FacebookExtension

val facebookExtensionPatch = patch("Facebook Extension Core") {
    description("Initializes the Facebook runtime patch logger on Application startup.")
    compatibleWith("com.facebook.katana")

    execute {
        facebookAppOnCreate.before {
            call(FacebookExtension.setContext, param(0))
        }
        log.info("Facebook Extension Context hooked at ${facebookAppOnCreate.descriptor}")
    }
}
