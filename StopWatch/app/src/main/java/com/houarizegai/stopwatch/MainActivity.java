package com.houarizegai.stopwatch;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.net.StandardSocketOptions;

public class MainActivity extends AppCompatActivity {

    ImageView ivSplash;
    TextView tvSplash, tvSubSplash;
    Button btnGetStart;
    Animation atg, btgone, btgtwo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ivSplash = (ImageView) findViewById(R.id.ivSplash);
        tvSplash = (TextView) findViewById(R.id.tvSplash);
        tvSubSplash = (TextView) findViewById(R.id.tvSubSplash);
        btnGetStart = (Button) findViewById(R.id.btnGetStart);

        // Load animation
        atg = AnimationUtils.loadAnimation(this, R.anim.atg);
        btgone = AnimationUtils.loadAnimation(this, R.anim.btgone);
        btgtwo = AnimationUtils.loadAnimation(this, R.anim.btgtwo);

        // Passing animation
        ivSplash.setAnimation(atg);
        tvSplash.setAnimation(btgone);
        tvSubSplash.setAnimation(btgone);
        btnGetStart.setAnimation(btgtwo);

        // Passing event
        btnGetStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, StopWatchActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                startActivity(intent);
            }
        });

        // Import fonts
        Typeface fontMRegular = Typeface.createFromAsset(getAssets(), "fonts/MRegular.ttf");
        Typeface fontMLight = Typeface.createFromAsset(getAssets(), "fonts/MLight.ttf");
        Typeface fontMMedium = Typeface.createFromAsset(getAssets(), "fonts/MMedium.ttf");

        // Customize font
        tvSplash.setTypeface(fontMRegular);
        tvSubSplash.setTypeface(fontMLight);
        btnGetStart.setTypeface(fontMMedium);

    }
}
