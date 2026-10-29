// SPDX-License-Identifier: AGPL-3.0-or-later

package app.rj.hyperlock.patches

import app.reseam.patch.Type
import app.reseam.patch.klass
import app.reseam.patch.method
import app.reseam.patch.point

internal val licenseClientCheck = klass("com.pairip.licensecheck.LicenseClient").method("checkLicense")

internal val splashOnCreate = klass("com.appiolab.hyperlock_screen_and_aod.Activitys.SplashActivity").method("onCreate")

internal val installerCheckPoint = splashOnCreate.point {
    invokeStatic {
        owner("k22")
        name("a")
    }
}.next { resultOf(Type.Boolean) }.captureAs("isInstallerValid")
