// SPDX-License-Identifier: AGPL-3.0-or-later

package app.rj.hotstar.patches.ads

import app.reseam.patch.Type
import app.reseam.patch.field
import app.reseam.patch.klass
import app.reseam.patch.method

internal val adMetadataConstructor = method("adMetadataConstructor") {
    name("<init>")
    params(Type.Boolean, Type.Boolean, Type.Boolean, Type.Boolean, Type.Boolean, Type.String, "java.util.List")
    strings("ssaiTag", "perPodPositions")
}

internal val watchLiveAdsInit = klass("com.hotstar.ads.watch.WatchLiveAdsViewModel").method("b") {
    returns(Type.Void)
}

internal val displayAdComposable = method("displayAdComposable") {
    returns(Type.Void)
    strings("DisplayAd")
    hasParam("com.hotstar.bff.models.widget.DisplayAdData")
}

internal val sgaiPrefetcherGetAd = method("sgaiPrefetcherGetAd") {
    returns(Type.Object)
    strings("SGAI_Prefetcher", "getAd: ")
}

internal val liveAdsManagerProcess = method("liveAdsManagerProcess") {
    returns(Type.Object)
    strings("LiveAdsManager", "Removed stale ad at %d")
}

internal val kotlinUnitField = klass("kotlin.Unit").field("a")
