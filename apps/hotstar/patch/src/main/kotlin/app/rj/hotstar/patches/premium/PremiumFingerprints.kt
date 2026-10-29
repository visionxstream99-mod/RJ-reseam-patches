// SPDX-License-Identifier: AGPL-3.0-or-later

package app.rj.hotstar.patches.premium

import app.reseam.patch.Type
import app.reseam.patch.klass
import app.reseam.patch.method

internal val getSubscriptionStatus = method("getSubscriptionStatus") {
    returns(Type.Object)
    strings("SubscriptionStatus")
}

internal val isUserSubscribed = klass("com.hotstar.user.Subscription").method("isSubscribed") {
    returns(Type.Boolean)
}
