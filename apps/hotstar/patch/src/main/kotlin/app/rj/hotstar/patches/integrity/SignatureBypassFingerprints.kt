// SPDX-License-Identifier: AGPL-3.0-or-later

package app.rj.hotstar.patches.integrity

import app.reseam.patch.Type
import app.reseam.patch.method
import app.reseam.patch.point

internal val signatureCheck = method("signatureCheck") {
    returns(Type.String)
    strings("MD5")
    calls {
        owner("com.hotstar.secrets.Secrets")
        name("getSignFromJNI")
    }
}

internal val encodedCert = signatureCheck.point {
    invokeStatic {
        owner("android.util.Base64")
        name("encodeToString")
    }
}.next { resultOf(Type.String) }.captureAs("encodedCert")
