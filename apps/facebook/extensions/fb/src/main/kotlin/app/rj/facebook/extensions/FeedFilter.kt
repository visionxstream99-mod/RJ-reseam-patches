// SPDX-License-Identifier: AGPL-3.0-or-later

@file:JvmName("FeedFilter")

package app.rj.facebook.extensions

import android.util.Log
import app.reseam.runtime.Export

private const val TAG = "ReseamFeedFilter"
private const val SPONSORED = "SPONSORED"
private const val PROMOTION = "PROMOTION"
private const val MULTI_ADS = "FBMultiAdsFeedUnit"

@Export
fun hideEdge(category: Any?, feedUnit: Any?): Boolean {
    val categoryName = if (category is Enum<*>) category.name else category?.toString()
    val unitTypeName = feedUnit?.javaClass?.simpleName ?: ""

    Log.d(TAG, "Evaluating feed edge: category=$categoryName, unit=$unitTypeName")

    if (categoryName == SPONSORED || categoryName == PROMOTION || unitTypeName == MULTI_ADS) {
        Log.i(TAG, "Hiding sponsored feed edge ($categoryName / $unitTypeName)")
        return true
    }

    return false
}
