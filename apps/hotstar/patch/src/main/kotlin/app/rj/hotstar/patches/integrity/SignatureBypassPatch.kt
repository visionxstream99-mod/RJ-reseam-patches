// SPDX-License-Identifier: AGPL-3.0-or-later

@file:Suppress("unused")

package app.rj.hotstar.patches.integrity

import app.reseam.patch.after
import app.reseam.patch.patch

val signatureBypass = patch("Bypass signature check") {
    description("Bypasses app signature verification to allow API access.")
    compatibleWith("in.startv.hotstar")

    execute {
        encodedCert.after {
            capture("encodedCert").assign(string("GnwgdTsKCP54v02ZSST5iA"))
        }
    }
}
