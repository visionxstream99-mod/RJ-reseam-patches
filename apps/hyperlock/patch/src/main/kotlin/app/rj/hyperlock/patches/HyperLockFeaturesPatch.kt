package app.rj.hyperlock.patches

import app.reseam.patch.CompatiblePackage
import app.reseam.patch.Type
import app.reseam.patch.alwaysReturn
import app.reseam.patch.boolOption
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

val customizeHyperLock = patch("Customize HyperLock") {
    description(
        "Optional HyperLock 0.1.2 clock and visual settings. Does not modify Play Store checks, purchases, or premium entitlement."
    )
    compatibleWith(HYPERLOCK_FEATURE_TARGET)

    val use12HourClock = boolOption(
        key = "use12HourClock",
        title = "12-hour clock",
        description = "Use a 12-hour clock format across HyperLock clock styles.",
        default = false
    )
    val enableDepthEffect = boolOption(
        key = "enableDepthEffect",
        title = "Depth effects",
        description = "Keep depth effects enabled across HyperLock clock styles.",
        default = true
    )
    val enableParallaxAnimation = boolOption(
        key = "enableParallaxAnimation",
        title = "Parallax animations",
        description = "Keep the app's per-clock parallax animation setting enabled.",
        default = true
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
