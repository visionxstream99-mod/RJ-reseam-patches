// SPDX-License-Identifier: AGPL-3.0-or-later

@file:Suppress("unused")

package app.rj.hyperlock.patches

import app.reseam.patch.after
import app.reseam.patch.before
import app.reseam.patch.patch

val licenseBypass = patch("Bypass License Check") {
    description("Bypasses Pairip anti-tamper, Play Store installer verification, and license checks.")
    compatibleWith("com.appiolab.hyperlockscreenos")

    execute {
        licenseClientCheck.before {
            returnVoid()
        }

        installerCheckPoint.after {
            capture("isInstallerValid").assign(bool(true))
        }

        log.info("Integrity: Bypassed Pairip license and Play Store installer verification.")
    }
}
