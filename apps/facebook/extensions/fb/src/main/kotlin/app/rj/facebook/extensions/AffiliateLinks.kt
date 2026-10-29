// SPDX-License-Identifier: AGPL-3.0-or-later

@file:JvmName("AffiliateLinks")

package app.rj.facebook.extensions

import android.util.Log
import app.reseam.runtime.Export

private const val TAG = "ReseamAffiliate"

@Export
fun keepCommentCard(card: Any?): Any? {
    if (card != null) {
        Log.i(TAG, "Suppressed comment sheet affiliate floating card")
        return null
    }
    return card
}
