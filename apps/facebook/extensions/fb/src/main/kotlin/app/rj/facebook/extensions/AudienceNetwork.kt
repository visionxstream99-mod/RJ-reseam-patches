// SPDX-License-Identifier: AGPL-3.0-or-later

@file:JvmName("AudienceNetwork")

package app.rj.facebook.extensions

import android.content.ComponentName
import android.content.pm.PackageManager
import android.util.Log
import app.reseam.runtime.Export

private const val TAG = "ReseamAudienceNetwork"

private val AUDIENCE_NETWORK_COMPONENTS = setOf(
    "com.facebook.ads.internal.ipc.AudienceNetworkRemoteService",
    "com.facebook.ads.internal.ipc.AudienceNetworkRemoteActivity",
    "com.facebook.ads.internal.ipc.AudienceNetworkExportedActivity",
    "com.facebook.ads.AudienceNetworkActivity",
    "com.facebook.audiencenetwork.AudienceNetworkService",
)

@Export
fun componentState(manager: PackageManager, component: ComponentName, state: Int, flags: Int) {
    val className = component.className
    if (state == PackageManager.COMPONENT_ENABLED_STATE_ENABLED && className in AUDIENCE_NETWORK_COMPONENTS) {
        Log.i(TAG, "Prevented Facebook from enabling Audience Network component: $className")
        manager.setComponentEnabledSetting(component, PackageManager.COMPONENT_ENABLED_STATE_DEFAULT, flags)
    } else {
        manager.setComponentEnabledSetting(component, state, flags)
    }
}
