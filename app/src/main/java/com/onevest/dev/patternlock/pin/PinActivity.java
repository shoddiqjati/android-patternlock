package com.onevest.dev.patternlock.pin;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;

import com.github.orangegangsters.lollipin.lib.managers.AppLock;
import com.github.orangegangsters.lollipin.lib.managers.AppLockActivity;
import com.github.orangegangsters.lollipin.lib.managers.LockManager;
import com.onevest.dev.patternlock.R;
import com.onevest.dev.patternlock.utils.PrefsManager;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class PinActivity extends com.github.orangegangsters.lollipin.lib.PinActivity {

    private static final int REQUEST_CODE_ENABLE = 100;
    private PrefsManager prefsManager;

    @BindView(R.id.set_pin)
    Button setPin;

    @OnClick(R.id.set_pin)
    public void setHandler() {
        Intent intent = new Intent(this, SetPin.class);
        intent.putExtra(AppLock.EXTRA_TYPE, AppLock.ENABLE_PINLOCK);
        startActivityForResult(intent, REQUEST_CODE_ENABLE);
        prefsManager.setPinStatus(true);
    }

    @BindView(R.id.remove_pin)
    Button removePin;

    @OnClick(R.id.remove_pin)
    public void removeHandler() {
        LockManager<SetPin> lockManager = LockManager.getInstance();
        lockManager.disableAppLock();
        prefsManager.setPinStatus(false);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pin);
        prefsManager = new PrefsManager(this);
        ButterKnife.bind(this);

        if (prefsManager.getPinStatus()) {
            LockManager<SetPin> lockManager = LockManager.getInstance();
            lockManager.enableAppLock(this, SetPin.class);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_CODE_ENABLE && resultCode == RESULT_OK) {
            prefsManager.setPinStatus(true);
        }
    }
}
