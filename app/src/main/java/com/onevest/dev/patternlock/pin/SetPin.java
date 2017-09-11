package com.onevest.dev.patternlock.pin;

import android.os.Bundle;
import android.widget.Toast;

import com.github.orangegangsters.lollipin.lib.managers.AppLockActivity;
import com.onevest.dev.patternlock.utils.PrefsManager;

/**
 * Created by Shoddiq Jati Premono on 08/09/2017.
 */

public class SetPin extends AppLockActivity {

    private PrefsManager prefsManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        prefsManager = new PrefsManager(this);
    }

    @Override
    public void showForgotDialog() {
        prefsManager.setPinStatus(false);
    }

    @Override
    public void onPinFailure(int attempts) {
        Toast.makeText(this, "Wrong PIN", Toast.LENGTH_LONG).show();
    }

    @Override
    public void onPinSuccess(int attempts) {

    }
}
