// SPDX-License-Identifier: AGPL-3.0-or-later

package app.rj.hotstar.patches.mirroring

import app.reseam.patch.Type
import app.reseam.patch.klass
import app.reseam.patch.method

internal val enableHdmiBroadcastListener = klass("com.hotstar.player.models.config.PlayerConfig").method("getEnableHdmiBroadcastListener") {
    returns(Type.Boolean)
}

internal val enableSendingHdcpNoDigitalOutput = klass("com.hotstar.player.models.capabilities.CapabilitiesConfig").method("getEnableSendingHdcpNoDigitalOutputForNoHdmiConnected") {
    returns(Type.Boolean)
}
