// SPDX-License-Identifier: AGPL-3.0-or-later

package app.rj.hyperlock.patches

import app.reseam.patch.klass
import app.reseam.patch.method

internal val bannerClass = klass("com.applovin.mediation.BannerAdLayout")
internal val nativeClass = klass("com.applovin.mediation.NativeAdLayout")

internal val loadBannerAdMethod = bannerClass.method("loadAd")
internal val loadInterstitialAdMethod = klass("com.applovin.mediation.InterstitialAdManager").method("loadAd")
internal val loadNativeAdMethod = nativeClass.method("loadAd")

internal val bannerC = bannerClass.method("c")
