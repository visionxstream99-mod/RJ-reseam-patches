// SPDX-License-Identifier: GPL-3.0-or-later
// RJ Reseam-native Anixart helper, reconstructed from public target/behavior notes.
// Copyright (C) 2026 RJ

package app.rj.anixart.extension;

import android.content.SharedPreferences;

/**
 * Redirect target for the one-time Kodik information preference read.
 *
 * The patch redirects only the getBoolean call selected inside Anixart's
 * Kodik-launch callback. Returning true makes that particular check behave
 * as though the one-time information prompt has already been acknowledged.
 */
public final class AnixartAdHooks {
    private AnixartAdHooks() {
    }

    public static boolean alwaysTruePreference(
        SharedPreferences preferences,
        String key,
        boolean defaultValue
    ) {
        return true;
    }
}
