package com.houarizegai.timerapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView txtCounter;

    private Counter counter;
    private int counterIndex = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtCounter = findViewById(R.id.txtCounter);
    }

    public void onStart(View view) {
        counter = new Counter(10000, 100);
        counter.start();
    }

    public void onStop(View view) {
        counter.cancel();
    }

    class Counter extends CountDownTimer {
        public Counter(long millisInFuture, long countDownInterval) {
            super(millisInFuture, countDownInterval);
        }

        @Override
        public void onTick(long millisUntilFinished) {
            txtCounter.setText(String.valueOf(counterIndex++));
        }

        @Override
        public void onFinish() {
            txtCounter.setText("Done");
        }
    }

}
