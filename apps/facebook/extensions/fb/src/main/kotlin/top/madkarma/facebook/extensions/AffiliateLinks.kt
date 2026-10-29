// SPDX-License-Identifier: AGPL-3.0-or-later

@file:JvmName("AffiliateLinks")

package top.madkarma.facebook.extensions

import android.util.Log
import app.reseam.runtime.Export

private const val TAG = "ReseamAffiliate"

private val SHOP_CTAS = setOf(
    "AFFILIATE_BANNER",
    "AFFILIATE_EYEBROW",
    "PRODUCT_TAGGING",
    "PRODUCT_TAGGING_V2",
    "STOREFRONT",
    "SHOP_SIMILAR",
)

@Export
fun keepReelCard(showsCard: Boolean): Boolean {
    if (showsCard) {
        Log.i(TAG, "Suppressed reel affiliate product card")
        return false
    }
    return showsCard
}

@Export
fun keepFooter(footerId: String?): String? {
    if (footerId != null) {
        Log.i(TAG, "Suppressed feed affiliate footer card (id: $footerId)")
        return null
    }
    return footerId
}

@Export
fun keepCommentCard(card: Any?): Any? {
    if (card != null) {
        Log.i(TAG, "Suppressed comment sheet affiliate floating card")
        return null
    }
    return card
}

@Export
fun keepReelCtas(filtered: List<*>?, all: List<*>?): List<*>? {
    val shown = filtered ?: all ?: return filtered
    if (shown.isEmpty()) return filtered

    val kept = mutableListOf<Any?>()
    var droppedAny = false

    for (cta in shown) {
        if (cta is Enum<*> && cta.name in SHOP_CTAS) {
            droppedAny = true
            Log.i(TAG, "Dropped reel shop CTA: ${cta.name}")
        } else {
            kept.add(cta)
        }
    }

    return if (droppedAny) kept else filtered
}
