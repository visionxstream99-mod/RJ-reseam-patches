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

The target manifest was inspected and the APKM passed ZIP integrity checking. CI successfully compiled the patch sources and generated a signed `.reseam` validation bundle; all four Pinterest patch IDs were confirmed in that bundle's manifest. The bundle has not yet been dry-run against the exact APKM or tested at runtime. A successful source build is not proof of compatibility or crash-free behavior.

Do not broaden compatibility beyond 14.42.0 until a separate build has been inspected and tested.