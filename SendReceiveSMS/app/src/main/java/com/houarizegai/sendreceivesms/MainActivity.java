package com.houarizegai.sendreceivesms;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText editSendTo, editMsg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editSendTo = findViewById(R.id.editSendTo);
        editMsg = findViewById(R.id.editMsg);
    }

    public void onSend(View view) {
        SmsManager smsSender = SmsManager.getDefault();
        smsSender.sendTextMessage(editSendTo.getText().toString(), null, editMsg.getText().toString(), null, null);
    }
}
