package com.houarizegai.readsms;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView txtMsg;
    private static final int REQUEST_CODE_ASK_PERMISSIONS = 1234; // You can use any number
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtMsg = findViewById(R.id.txtMsg);
    }

    public void onReadMsg(View view) {
        if( Build.VERSION.SDK_INT >= 23) { // get permission only for SDK version >= 23
            // not permitted?
            if(ActivityCompat.checkSelfPermission(this, Manifest.permission.READ_SMS) != PackageManager.PERMISSION_GRANTED) {
                if(!shouldShowRequestPermissionRationale(Manifest.permission.READ_SMS)) { // asked the same permission before?
                    requestPermissions(new String[]{Manifest.permission.READ_SMS}, REQUEST_CODE_ASK_PERMISSIONS);
                }

                return;
            }
        }

        String messages = loadInboxMessages();
        txtMsg.setText(messages);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        switch (requestCode) {
            case REQUEST_CODE_ASK_PERMISSIONS:
                if(grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    // Permission granted
                    String messages = loadInboxMessages();
                    txtMsg.setText(messages);
                } else {
                    // Permission denied
                }
                break;
        }
    }

    private String loadInboxMessages() {
        StringBuilder sms = new StringBuilder();
        try {

            Uri uriSmsUri = Uri.parse("content://sms/inbox");
            Cursor cur = getContentResolver().query(uriSmsUri, null, null, null, null);
            cur.moveToPosition(0);
            while(cur.moveToNext()) {
                // load sender and the message content
                sms.append("From: ")
                        .append(cur.getString(cur.getColumnIndex("address")))
                        .append(" : ")
                        .append(cur.getString(cur.getColumnIndex("body")))
                        .append("\n");
            }
        } catch(Exception e) {
            e.printStackTrace();
        }

        return sms.toString();
    }
}
