// SPDX-License-Identifier: AGPL-3.0-or-later
// Pinterest 14.42.0 first-pass manifest patches.
// Target observations are from the user-supplied APKMirror APKM's base.apk.

package app.rj.pinterest.patches

import app.reseam.patch.patch

private val PINTEREST_14_42 = "com.pinterest"("14.42.0")

/**
 * Removes only the Google Advertising ID permission. This does not block all
 * forms of tracking and does not change Pinterest's feed or authentication.
 */
val removeAdvertisingIdPermission = patch("Remove Advertising ID permission") {
    description("Removes the Google Advertising ID permission from Pinterest 14.42.0.")
    compatibleWith(PINTEREST_14_42)

    execute {
        manifest.edit {
            val rootElement = root
            val matches = findByTag("uses-permission").filter {
                it["android:name"] == "com.google.android.gms.permission.AD_ID"
            }

            check(matches.size == 1) {
                "Expected one Google Advertising ID permission, found ${matches.size}."
            }
            matches.forEach { rootElement.removeChild(it) }
        }
    }
}

/**
 * Changes Pinterest's four existing Google Analytics default-consent entries
 * to false. Missing entries fail the patch rather than silently claiming opt-out.
 */
val optOutGoogleAnalytics = patch("Opt out of Google Analytics") {
    description("Sets Pinterest's four Google Analytics default-consent flags to false.")
    compatibleWith(PINTEREST_14_42)

    execute {
        val flags = setOf(
            "google_analytics_default_allow_analytics_storage",
            "google_analytics_default_allow_ad_storage",
            "google_analytics_default_allow_ad_user_data",
            "google_analytics_default_allow_ad_personalization_signals",
        )

        manifest.edit {
            val application = findByTag("application").single()

            for (name in flags) {
                val matches = application.findByTag("meta-data").filter {
                    it["android:name"] == name
                }
                check(matches.size == 1) {
                    "Expected one Google Analytics metadata entry for '$name', found ${matches.size}."
                }
                matches.single()["android:value"] = "false"
            }
        }
    }
}

/**
 * Removes Pinterest's Android Privacy Sandbox / Ad Services config property.
 * This does not disable every advertising SDK or every form of measurement.
 */
val disablePrivacySandboxAdServices = patch("Disable Privacy Sandbox Ad Services") {
    description("Removes Pinterest's android.adservices.AD_SERVICES_CONFIG manifest property.")
    compatibleWith(PINTEREST_14_42)

    execute {
        manifest.edit {
            val application = findByTag("application").single()
            val matches = application.findByTag("property").filter {
                it["android:name"] == "android.adservices.AD_SERVICES_CONFIG"
            }

            check(matches.size == 1) {
                "Expected one Android Ad Services config property, found ${matches.size}."
            }
            matches.forEach { application.removeChild(it) }
        }
    }
}

/**
 * Disables the Google Engage broadcast receiver declared by Pinterest.
 * It leaves the class and other manifest components intact.
 */
val disableGoogleEngageReceiver = patch("Disable Google Engage receiver") {
    description("Disables Pinterest's Google Engage recommendation broadcast receiver.")
    compatibleWith(PINTEREST_14_42)

    execute {
        manifest.edit {
            val matches = findByTag("receiver").filter {
                it["android:name"] == "com.pinterest.engage.GoogleEngageBroadcastReceiver"
            }

            check(matches.size == 1) {
                "Expected one Pinterest Google Engage receiver, found ${matches.size}."
            }
            matches.single()["android:enabled"] = "false"
        }
    }
}
