// SPDX-License-Identifier: AGPL-3.0-or-later

package top.madkarma.patches.facebook

import app.reseam.patch.*

val facebookExtensionPatch = patch("Facebook Extension Core") {
    description("Initializes the Facebook runtime patch logger on Application startup.")
    compatibleWith("com.facebook.katana")

    execute {
        facebookAppOnCreate.before {
            callStatic(
                "android/util/Log", "i", proto(Type.Int, Type.String, Type.String),
                string("ReseamFacebook"), string("Initialized Reseam Facebook Patch"),
            )
        }
        log.info("Facebook Extension Context hooked at ${facebookAppOnCreate.descriptor}")
    }
}
