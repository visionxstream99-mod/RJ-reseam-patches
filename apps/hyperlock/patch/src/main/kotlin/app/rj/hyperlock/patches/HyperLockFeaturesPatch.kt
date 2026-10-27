package app.rj.hyperlock.patches

import app.reseam.patch.CompatiblePackage
import app.reseam.patch.Type
import app.reseam.patch.alwaysReturn
import app.reseam.patch.klass
import app.reseam.patch.method
import app.reseam.patch.patch

private val HYPERLOCK_FEATURE_TARGET = CompatiblePackage(
    "com.appiolab.hyperlockscreenos",
    listOf("0.1.2")
)

/*
 * Verified against the supplied HyperLock 0.1.2 base.apk.
 *
 * Lx24 is the app's SharedPreferences helper. Its m(I):Z method reads the
 * per-clock 12-hour preference, n(I):Z reads the per-clock depth-effect
 * preference, and j(I):Z reads the per-clock parallax-animation preference.
 * The int parameter is a clock/style index, so the selectors keep it intact.
 */
private val prefsHelper = klass("x24")

private val clockUses12HourFormat = method("HyperLock 12-hour format preference") {
    inClass(prefsHelper)
    name("m")
    params(Type.Int)
    returns(Type.Boolean)
}

private val depthEffectIsEnabled = method("HyperLock depth effect preference") {
    inClass(prefsHelper)
    name("n")
    params(Type.Int)
    returns(Type.Boolean)
}

private val parallaxAnimationIsEnabled = method("HyperLock parallax animation preference") {
    inClass(prefsHelper)
    name("j")
    params(Type.Int)
    returns(Type.Boolean)
}

/*
 * PairIP 2.x (Google Play app-protection) injects a wrapper Application
 * class and calls LicenseClient.checkLicense(Context) from
 * Application.attachBaseContext(). Every downstream piece of the license
 * flow — binding LicenseService, the network round-trip, and launching
 * LicenseActivity on failure — is gated behind that single call.
 *
 * No-oping checkLicense stops the flow without touching:
 *   - com/pairip/application/Application  (still the manifest's app class,
 *                                          still calls super so Helper.App
 *                                          init is preserved)
 *   - com/pairip/VMRunner                 (still needed by virtualized
 *                                          method bodies elsewhere in the app)
 *   - com/pairip/licensecheck/LicenseActivity (never reached)
 *   - the CHECK_LICENSE manifest permission   (harmless leftover)
 */
private val pairIpLicenseClient = klass("com/pairip/licensecheck/LicenseClient")

private val pairIpCheckLicense = method("PairIP LicenseClient.checkLicense") {
    inClass(pairIpLicenseClient)
    name("checkLicense")
    params(Type.Context)
    returns(Type.Void)
}

val customizeHyperLock = patch("Customize HyperLock") {
    description(
        "Optional HyperLock 0.1.2 clock and visual settings. Does not modify Play Store checks, purchases, or premium entitlement."
    )
    compatibleWith(HYPERLOCK_FEATURE_TARGET)

    val use12HourClock = boolOption(
        key = "use12HourClock",
        title = "Force 12-hour clock",
        description = "Force 12-hour time across clock styles. Off leaves HyperLock's saved setting unchanged.",
        default = false
    )
    val enableDepthEffect = boolOption(
        key = "enableDepthEffect",
        title = "Force depth effects on",
        description = "Force the existing depth-effect preference on. Off leaves HyperLock's saved setting unchanged.",
        default = false
    )
    val enableParallaxAnimation = boolOption(
        key = "enableParallaxAnimation",
        title = "Force parallax animation on",
        description = "Force the existing parallax preference on. Off leaves HyperLock's saved setting unchanged.",
        default = false
    )

    execute {
        if (options[use12HourClock]) {
            clockUses12HourFormat.alwaysReturn(true)
        }
        if (options[enableDepthEffect]) {
            depthEffectIsEnabled.alwaysReturn(true)
        }
        if (options[enableParallaxAnimation]) {
            parallaxAnimationIsEnabled.alwaysReturn(true)
        }
    }
}

val removePairIp = patch("Remove PairIP license check") {
    description(
        "Neutralizes PairIP's LicenseClient.checkLicense so the app runs without license verification. " +
        "Keeps the PairIP Application wrapper and VMRunner intact, so virtualized methods continue to work."
    )
    compatibleWith(HYPERLOCK_FEATURE_TARGET)

    execute {
        pairIpCheckLicense.returnEarly()
    }
}
