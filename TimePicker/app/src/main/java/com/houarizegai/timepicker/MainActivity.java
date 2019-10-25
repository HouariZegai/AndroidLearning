package com.houarizegai.timepicker;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.TimePicker;

import java.sql.Time;

public class MainActivity extends AppCompatActivity {

    private TextView txtTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtTime = findViewById(R.id.txtTime);
    }

    public void setTime(String time) {
        txtTime.setText(time);
    }

    public void onChangeDate(View view) {
        // Show time picker
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        TimePickerActivity popupView = new TimePickerActivity();
        popupView.show(fragmentTransaction, null);
    }
}
