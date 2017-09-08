package com.onevest.dev.patternlock;

import android.os.Bundle;
import android.text.TextUtils;

import com.onevest.dev.patternlock.utils.PrefsManager;

import java.util.List;

import me.zhanghai.android.patternlock.ConfirmPatternActivity;
import me.zhanghai.android.patternlock.PatternUtils;
import me.zhanghai.android.patternlock.PatternView;

/**
 * Created by Shoddiq Jati Premono on 13/08/2017.
 */

public class ConfirmPattern extends ConfirmPatternActivity {
    PrefsManager prefs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        prefs = new PrefsManager(this);
    }

    @Override
    protected boolean isStealthModeEnabled() {
        // TODO: Return the value from SharedPreferences.
        return false;
    }

    @Override
    protected boolean isPatternCorrect(List<PatternView.Cell> pattern) {
        String patternSha1 = prefs.getLockPattern();
        return TextUtils.equals(PatternUtils.patternToSha1String(pattern), patternSha1);
    }

    @Override
    protected void onForgotPassword() {
        super.onForgotPassword();
    }
}
