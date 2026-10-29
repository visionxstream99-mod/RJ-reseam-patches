// SPDX-License-Identifier: AGPL-3.0-or-later

package top.madkarma.patches.facebook

import app.reseam.patch.*

val hideAffiliateLinks = patch("Hide affiliate product links") {
    description("Removes shopping cards, affiliate links, and Shop Now overlays on reels, feed posts, and comments.")
    compatibleWith("com.facebook.katana")
    dependsOn(facebookExtensionPatch)

    execute {
        floatingCtaInitMethod.after {
            returnVoid()
        }
        log.info("HideAffiliateLinks: Filtered comment card product links.")
    }
}
