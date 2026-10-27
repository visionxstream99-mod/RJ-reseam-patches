# RJ Patch Catalogue

This file records the RJ patch work that can be substantiated from project history. It is not itself an installable patch bundle.

## ADM — Remove Ads

- Patch ID: `app.rj.adm.patches.removeAds`
- Target package: `com.dv.adm`
- Target version: ADM 7.6, build 70620
- Intended behavior: remove supported banner/interstitial ad entry points associated with AdMob, Admax, and AppBrain.
- Historical test status: a prior build was applied successfully to a test APK; the maintainer reported that ads were gone.
- Current artifact status: the prior signed `.reseam` file and its matching signing key have not been recovered in this repository session. Do not treat this entry as a current downloadable release.

## Rebuild and release gate

Before a patch is listed as downloadable:

1. Recover or recreate its patch source against the exact target app build.
2. Confirm unique patch IDs and the actual Reseam manifest.
3. Build using the Reseam workspace plugin and matching CLI version.
4. Inspect the generated bundle and validate patch metadata.
5. Apply it to a test APK and record the actual result.
6. Sign with the intended release key; never commit the private key.
7. Publish the tested `.reseam` artifact and matching source metadata, with accurate version notes.

Do not label a patch as working or released based on remembered descriptions alone.
