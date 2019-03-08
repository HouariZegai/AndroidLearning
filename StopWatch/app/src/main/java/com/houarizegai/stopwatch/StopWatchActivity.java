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
import android.widget.Toast;

public class StopWatchActivity extends AppCompatActivity {

    ImageView icanchor;
    Chronometer timer;
    Button btnStart, btnStop;
    Animation roundingalone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stop_watch);

        icanchor = findViewById(R.id.icanchor);
        timer = findViewById(R.id.timer);
        btnStart = findViewById(R.id.btnStart);
        btnStop = findViewById(R.id.btnStop);

        // Create optional animation
        btnStop.setAlpha(0f);
        btnStop.setTranslationY(-80);

        // Load animation
        roundingalone = AnimationUtils.loadAnimation(this, R.anim.roundingalone);

        // Import font
        Typeface fontMedium = Typeface.createFromAsset(getAssets(), "fonts/MMedium.ttf");

        // Customize font
        btnStart.setTypeface(fontMedium);
        btnStop.setTypeface(fontMedium);

        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Passing animation
                icanchor.setAnimation(roundingalone);
                btnStart.animate().alpha(0).setDuration(300).start();
                btnStop.animate().alpha(1).translationY(0).setDuration(300).start();

                // Start time
                timer.setBase(SystemClock.elapsedRealtime());
                timer.start();
            }
        });
        btnStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                timer.stop();
                // Reset animation
                icanchor.clearAnimation();
                btnStart.animate().alpha(1).setDuration(300).start();
                btnStop.animate().alpha(0).translationY(-80).setDuration(300).start();
            }
        });

    }
}
