package com.onevest.dev.patternlock;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.LinearLayout;

import com.onevest.dev.patternlock.pattern.PatternActivity;
import com.onevest.dev.patternlock.pin.PinActivity;
import com.onevest.dev.patternlock.utils.PrefsManager;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.pattern_BT)
    LinearLayout patternBT;

    @OnClick(R.id.pattern_BT)
    public void patternHandler() {
        startActivity(new Intent(this, PatternActivity.class));
    }

    @BindView(R.id.pin_BT)
    LinearLayout pinBT;

    @OnClick(R.id.pin_BT)
    public void pinHandler(){
        startActivity(new Intent(this, PinActivity.class));
    }

    private PrefsManager prefs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }
}
