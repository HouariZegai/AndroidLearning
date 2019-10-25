package com.houarizegai.timepicker;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TimePicker;

import androidx.fragment.app.DialogFragment;

public class TimePickerActivity extends DialogFragment implements View.OnClickListener {

    private View view;
    private TimePicker timePicker;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.time_picker_activity, container, false);

        timePicker = view.findViewById(R.id.timePicker);
        Button btnDone = view.findViewById(R.id.btnDone);
        btnDone.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View v) {
        this.dismiss(); // Remove this activity (fragment)
        String myTime = timePicker.getHour() + ":" + timePicker.getMinute();

        MainActivity mainActivity = (MainActivity) getActivity();
        mainActivity.setTime(myTime);
    }
}
