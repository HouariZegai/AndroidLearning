package com.houarizegai.stopwatch;

import android.graphics.Typeface;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.ImageView;

public class StopWatchActivity extends AppCompatActivity {

    ImageView icanchor;
    Chronometer timer;
    Button btnStart, btnStop;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stop_watch);

        icanchor = findViewById(R.id.icanchor);
        timer = findViewById(R.id.timer);
        btnStart = findViewById(R.id.btnStart);
        btnStop = findViewById(R.id.btnStop);

        // Import font
        Typeface fontMedium = Typeface.createFromAsset(getAssets(), "fonts/MMedium.ttf");

        // Customize font
        btnStart.setTypeface(fontMedium);
        btnStop.setTypeface(fontMedium);

    }
}
