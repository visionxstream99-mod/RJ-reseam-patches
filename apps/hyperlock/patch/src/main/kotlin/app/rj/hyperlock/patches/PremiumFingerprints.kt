// SPDX-License-Identifier: AGPL-3.0-or-later

package app.rj.hyperlock.patches

import app.reseam.patch.Type
import app.reseam.patch.field
import app.reseam.patch.klass
import app.reseam.patch.method

internal val appClass = klass("com.appiolab.hyperlock_screen_and_aod.Helper.App")

internal val appOnCreate = appClass.method("onCreate")

internal val appPremiumField = appClass.field("e")

internal val isPremiumCachedMethod = klass("je3").method("isPremiumCached") {
    returns(Type.Boolean)
    params("android.content.Context")
}
