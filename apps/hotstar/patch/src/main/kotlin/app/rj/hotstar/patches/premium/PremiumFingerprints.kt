// SPDX-License-Identifier: AGPL-3.0-or-later

package app.rj.hotstar.patches.premium

import app.reseam.patch.Type
import app.reseam.patch.klass
import app.reseam.patch.method

internal val myPageDataIsSubscribed = method("getIsSubscribed") {
    inClass(klass("com.hotstar.ui.model.pagedata.MyPageData"))
    returns(Type.Boolean)
    custom { name == "getIsSubscribed" }
}
