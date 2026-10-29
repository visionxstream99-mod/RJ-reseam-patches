// SPDX-License-Identifier: AGPL-3.0-or-later

package app.rj.facebook.patches

import app.reseam.patch.*
import app.rj.facebook.extensions.bindings.FeedFilter

val hideSponsoredPosts = patch("Hide sponsored posts") {
    description("Removes sponsored posts, ads, and promoted content from the Facebook news feed.")
    compatibleWith("com.facebook.katana")
    dependsOn(facebookExtensionPatch)

    execute {
        addNewEdgeToCollectionMethod.before {
            val category = param(0)
            val feedUnit = param(1)
            val shouldHide = call(FeedFilter.hideEdge, category, feedUnit)

            whenTrue(shouldHide) {
                returnFalse()
            }
        }
        log.info("HideSponsoredPosts: Hooked ${addNewEdgeToCollectionMethod.descriptor} to filter feed edges.")
    }
}
