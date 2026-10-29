// SPDX-License-Identifier: AGPL-3.0-or-later

package top.madkarma.patches.facebook

import app.reseam.patch.*

val hideSponsoredPosts = patch("Hide sponsored posts") {
    description("Removes sponsored posts, ads, and promoted content from the Facebook news feed.")
    compatibleWith("com.facebook.katana")
    dependsOn(facebookExtensionPatch)

    execute {
        addNewEdgeToCollectionMethod.before {
            returnFalse()
        }
        log.info("HideSponsoredPosts: Hooked ${addNewEdgeToCollectionMethod.descriptor} to filter feed edges.")
    }
}
