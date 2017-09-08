package com.onevest.dev.patternlock;

import android.os.Bundle;

import com.onevest.dev.patternlock.utils.PrefsManager;

import java.util.List;

import me.zhanghai.android.patternlock.PatternUtils;
import me.zhanghai.android.patternlock.PatternView;
import me.zhanghai.android.patternlock.SetPatternActivity;

public class SetPattern extends SetPatternActivity {
    PrefsManager prefs;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        prefs = new PrefsManager(this);
    }

    @Override
    protected void onSetPattern(List<PatternView.Cell> pattern) {
        String patternSha1 = PatternUtils.patternToSha1String(pattern);
        prefs.setLockPattern(patternSha1);
        prefs.setPatterStatus(true);
    }
}
