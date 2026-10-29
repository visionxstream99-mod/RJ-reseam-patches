// SPDX-License-Identifier: AGPL-3.0-or-later

package app.rj.facebook.patches

import app.reseam.patch.Type
import app.reseam.patch.klass
import app.reseam.patch.method

internal val facebookAppClass = klass("com.facebook.katana.app.FacebookApplication")
internal val facebookAppOnCreate = facebookAppClass.method("onCreate")

internal val feedCollectionManagerClass = klass("feedCollectionManager") {
    strings("Edge not added to FUC")
}

internal val addNewEdgeToCollectionMethod = method("addNewEdgeToCollection") {
    inClass(feedCollectionManagerClass)
    returns(Type.Boolean)
    hasParam("com.facebook.graphql.model.GraphQLFeedUnitEdge")
    custom { name == "addNewEdgeToCollection" }
}

internal val floatingCtaPluginClass = klass("com.facebook.feedback.comments.plugins.indicatorpill.organicaffiliatefloatingcta.OrganicAffiliateFloatingCtaPlugin")
internal val floatingCtaInitMethod = floatingCtaPluginClass.method("<init>")
