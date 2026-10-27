# Pinterest 14.42.0

Package: `com.pinterest`  
Version name: `14.42.0`  
Version code: `14428010`  
Minimum Android API: `29`  
Architecture in the supplied APKM: `arm64-v8a`

The initial patch set is intentionally limited to manifest-level privacy controls confirmed in the supplied `base.apk`:

- Remove the Google Advertising ID permission.
- Set Pinterest's four Google Analytics default-consent metadata values to `false`.
- Remove the Android Ad Services configuration property.
- Disable Pinterest's Google Engage recommendation receiver.

These edits do not claim to disable every tracker or every advertisement. No authentication, feed, promoted-pin model, or native method body is modified in this first pass.

## Verification status

The target manifest was inspected and the APKM passed ZIP integrity checking. The patch sources still require a successful Reseam build and an exact-version patch run. A successful patch run does not prove runtime behavior; install and navigation checks are still required before calling the patches verified.

Do not broaden compatibility beyond 14.42.0 until a separate build has been inspected and tested.