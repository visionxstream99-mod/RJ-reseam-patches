// SPDX-License-Identifier: AGPL-3.0-or-later

@file:JvmName("FacebookExtension")

package top.madkarma.facebook.extensions

import android.content.Context
import android.util.Log
import app.reseam.runtime.Export

private const val TAG = "ReseamFacebook"

@Volatile
private var appContext: Context? = null

@Export
fun setContext(context: Context?) {
    if (context == null || appContext != null) return
    appContext = context.applicationContext
    Log.i(TAG, "Initialized Facebook Extension Context for process ${context.packageName}")
}

fun getContext(): Context? = appContext
