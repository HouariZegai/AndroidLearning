package com.houarizegai.datepicker;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView txtDate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtDate = findViewById(R.id.txtDate);
    }

    public void setDate(String date) {
        txtDate.setText(date);
    }

    public void onChangeDate(View view) {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();

        DatePickerActivity pickerPopView = new DatePickerActivity();
        pickerPopView.show(fragmentTransaction, null);
    }
}
