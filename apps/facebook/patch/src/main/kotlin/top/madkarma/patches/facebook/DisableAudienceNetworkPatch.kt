// SPDX-License-Identifier: AGPL-3.0-or-later

package top.madkarma.patches.facebook

import app.reseam.patch.*

private val AUDIENCE_NETWORK_COMPONENTS = setOf(
    "com.facebook.ads.internal.ipc.AudienceNetworkRemoteService",
    "com.facebook.ads.internal.ipc.AudienceNetworkRemoteActivity",
    "com.facebook.ads.internal.ipc.AudienceNetworkExportedActivity",
    "com.facebook.ads.AudienceNetworkActivity",
    "com.facebook.audiencenetwork.AudienceNetworkService",
)

val disableAudienceNetwork = patch("Disable Audience Network") {
    description("Disables Audience Network components in AndroidManifest.xml and prevents runtime reactivation.")
    compatibleWith("com.facebook.katana")
    dependsOn(facebookExtensionPatch)

    execute {
        val doc = manifest.document()
        for (child in doc.root.children) {
            val name = child["android:name"]
            if (name in AUDIENCE_NETWORK_COMPONENTS) {
                child["android:enabled"] = "false"
                log.info("Audience Network: Disabled manifest component $name")
            }
        }
    }
}
