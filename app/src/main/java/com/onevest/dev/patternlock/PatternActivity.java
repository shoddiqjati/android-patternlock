package com.onevest.dev.patternlock;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;

import com.onevest.dev.patternlock.utils.PrefsManager;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class PatternActivity extends AppCompatActivity {

    @BindView(R.id.set_pattern)
    Button setBt;

    @OnClick(R.id.set_pattern)
    public void setHandler() {
        startActivity(new Intent(this, SetPattern.class));
    }

    @BindView(R.id.remove_pattern)
    Button removeBt;

    @OnClick(R.id.remove_pattern)
    public void removeHandler() {
        prefsManager.removeLockPattern();
        prefsManager.setPatterStatus(false);
    }

    private PrefsManager prefsManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pattern);
        prefsManager = new PrefsManager(this);
        ButterKnife.bind(this);

        if (prefsManager.getPatternStatus()) {
            startActivity(new Intent(this, ConfirmPattern.class));
        }
    }
}
