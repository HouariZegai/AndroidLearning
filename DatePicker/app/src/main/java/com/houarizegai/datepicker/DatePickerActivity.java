package com.houarizegai.datepicker;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;

import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

public class DatePickerActivity extends DialogFragment implements View.OnClickListener {

    private View view;
    private DatePicker datePicker;
    private Button btnDone;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.date_picker_activity, container);
        datePicker = view.findViewById(R.id.datePicker);
        btnDone = view.findViewById(R.id.btnDone);
        btnDone.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View v) {
        this.dismiss(); // close pop view

        String date = new StringBuilder()
                .append(datePicker.getYear())
                .append("/")
                .append(datePicker.getMonth() + 1)
                .append("/")
                .append(datePicker.getDayOfMonth()).toString();

        MainActivity mainActivity = (MainActivity) getActivity();
        mainActivity.setDate(date);
    }
}
