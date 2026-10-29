// SPDX-License-Identifier: AGPL-3.0-or-later

@file:Suppress("unused")

package app.rj.hotstar.patches.mirroring

import app.reseam.patch.alwaysReturn
import app.reseam.patch.patch

val enableScreenMirroring = patch("Enable screen mirroring") {
    description("Allows playback while screen mirroring or HDMI is connected.")
    compatibleWith("in.startv.hotstar")

    execute {
        enableHdmiBroadcastListener.alwaysReturn(false)
        enableSendingHdcpNoDigitalOutput.alwaysReturn(false)
    }
}
