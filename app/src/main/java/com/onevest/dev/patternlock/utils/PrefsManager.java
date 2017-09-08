package com.onevest.dev.patternlock.utils;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by Shoddiq Jati Premono on 13/08/2017.
 */

public class PrefsManager {
    private static final String PREF_NAME = "com.onevest.dev.patternlock";
    private static final String LOCK_PATTERN = "LOCK_PIN";
    private static final String PATTERN_STATUS = "PATTERN_STATUS";
    private static final String LOCK_PIN = "LOCK_PIN";
    private static final String PIN_STATUS = "PIN_STATUS";
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;

    public PrefsManager(Context context) {
        this.sharedPreferences = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
        this.editor = this.sharedPreferences.edit();
    }

    public void setLockPattern(String pattern) {
        editor.putString(LOCK_PIN, pattern);
        editor.commit();
    }

    public String getLockPattern() {
        String pattern = sharedPreferences.getString(LOCK_PIN, null);
        return pattern;
    }

    public void removeLockPattern() {
        editor.remove(LOCK_PIN);
        editor.commit();
    }

    public void setPatterStatus(boolean status) {
        editor.putBoolean(PATTERN_STATUS, status);
        editor.commit();
    }

    public boolean getPatternStatus() {
        boolean status = sharedPreferences.getBoolean(PATTERN_STATUS, false);
        return status;
    }

    public void setLockPin(String pin) {
        editor.putString(LOCK_PIN, pin);
        editor.commit();
    }

    public String getLockPin() {
        String pin = sharedPreferences.getString(LOCK_PIN, null);
        return pin;
    }

    public void removeLockPin() {
        editor.remove(LOCK_PIN);
        editor.commit();
    }

    public void setPinStatus(boolean status) {
        editor.putBoolean(PIN_STATUS, status);
        editor.commit();
    }

    public boolean getPinStatus() {
        boolean pinStatus = sharedPreferences.getBoolean(PIN_STATUS, false);
        return pinStatus;
    }
}
