# Pinterest 14.42.0 — source analysis

## Input identity

- User-supplied file: `com.pinterest_14.42.0-14428010_1arch_2dpi_23lang_ea20959c6cbd20864956767ff91a0a32_apkmirror.com.apkm`
- APKM SHA-256: `a67f9078c5924fcd334616863d46ced4c686d029a0f8341a7ae64645c4196e2e`
- Base APK package: `com.pinterest`
- Version name: `14.42.0`
- Version code: `14428010`
- `minSdkVersion`: 29
- `targetSdkVersion`: 36
- Base APK contains eight DEX files (`classes.dex` through `classes8.dex`).

The APKM and base APK ZIP structures passed integrity checks. The Android manifest was parsed from the supplied base APK. This note does not claim a signing-certificate verification or a runtime test.

## Confirmed manifest entries

The supplied manifest contains:

- `com.google.android.gms.permission.AD_ID`
- `android.permission.ACCESS_ADSERVICES_AD_ID`
- `android.adservices.AD_SERVICES_CONFIG`
- Four `google_analytics_default_allow_*` metadata flags, presently enabled
- `com.google.android.gms.ads.APPLICATION_ID` and two Google Ads debug/configuration metadata entries
- `com.bugsnag.android.API_KEY`
- `com.pinterest.engage.GoogleEngageBroadcastReceiver`, declared enabled

## First-pass implementation

The first-pass patch sources touch only four manifest entries/groups:

1. Remove the Google Advertising ID permission.
2. Set the four existing Google Analytics default-consent values to `false`.
3. Remove the Android Ad Services configuration property.
4. Set the Google Engage receiver's `android:enabled` attribute to `false`.

Each patch is pinned to Pinterest 14.42.0 and checks its expected manifest target count, so it fails loudly if the expected entry is absent or duplicated.

## Deliberately deferred

- **Google Ads SDK metadata removal:** not in the first pass. The app has a Google Ads application ID and may invoke the SDK. Removing its manifest ID without proving the startup path could introduce a runtime exception.
- **Hide promoted pins / hide ad views:** requires exact-version bytecode fingerprint validation and navigation/runtime tests.
- **Copy/share URL sanitization:** requires exact-version call-site validation and behavioral testing.
- **Bugsnag removal:** deferred until its runtime configuration is confirmed.
- **Google sign-in or signature spoofing:** not attempted.

## Release gate

A green source build is not enough. Before publishing:

1. Build the `.reseam` bundle with the matching Reseam 0.32.0 toolchain.
2. Run the patch engine against this exact Pinterest APKM and confirm every selected patch applies.
3. Inspect the resulting manifest to verify only intended changes were made.
4. Install the resulting split set on a test device and test launch, sign-in, feed, pin details, boards, search, save/copy/share, and navigation.
5. Keep the four patches marked experimental until those checks pass.