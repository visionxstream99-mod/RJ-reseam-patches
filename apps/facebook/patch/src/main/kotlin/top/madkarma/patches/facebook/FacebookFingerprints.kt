// SPDX-License-Identifier: AGPL-3.0-or-later

package top.madkarma.patches.facebook

import app.reseam.patch.Type
import app.reseam.patch.klass
import app.reseam.patch.method

// Facebook Main Application
internal val facebookAppClass = klass("com.facebook.katana.app.FacebookApplication")
internal val facebookAppOnCreate = facebookAppClass.method("onCreate")

// Feed Edge Collection Funnel
internal val feedCollectionManagerClass = klass("feedCollectionManager") {
    strings("Edge not added to FUC")
}

internal val addNewEdgeToCollectionMethod = method("addNewEdgeToCollection") {
    inClass(feedCollectionManagerClass)
    returns(Type.Boolean)
    hasParam("com.facebook.graphql.model.GraphQLFeedUnitEdge")
    custom { name == "addNewEdgeToCollection" }
}

// Organic Affiliate Floating CTA Plugin (Optional)
internal val floatingCtaPluginClass = klass("com.facebook.feedback.comments.plugins.indicatorpill.organicaffiliatefloatingcta.OrganicAffiliateFloatingCtaPlugin")
internal val floatingCtaInitMethod = floatingCtaPluginClass.method("<init>")
