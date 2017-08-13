package com.onevest.dev.patternlock;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by Shoddiq Jati Premono on 13/08/2017.
 */

public class PrefsManager {
    private static final String PREF_NAME = "com.onevest.dev.patternlock";
    private static final String
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;

    public PrefsManager(Context context) {
        this.sharedPreferences = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
        this.editor = this.sharedPreferences.edit();
    }

    public void setLockPattern(String pattern) {

    }
}
