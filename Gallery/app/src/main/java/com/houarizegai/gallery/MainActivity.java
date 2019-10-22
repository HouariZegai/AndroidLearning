package com.houarizegai.gallery;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    private ImageView imgViewer;
    private static int index;
    private int[] sliderImages;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        index = 1;
        sliderImages = new int[]{R.drawable.a, R.drawable.b, R.drawable.c, R.drawable.d};

        imgViewer = findViewById(R.id.imgViewer);
        imgViewer.setImageResource(R.drawable.a);
    }

    public void onBack(View view) {
        if(--index < 0)
            index = 0;
        imgViewer.setImageResource(sliderImages[index]);
    }

    public void onNext(View view) {
        if(++index > 3)
            index = 3;
        imgViewer.setImageResource(sliderImages[index]);
    }
}
