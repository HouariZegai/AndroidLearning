package com.houarizegai.sendreceivesms;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.telephony.SmsMessage;

public class ReceiveMessage extends BroadcastReceiver {

    final SmsManager smsManager = SmsManager.getDefault();
    static int id = 1;
    @Override
    public void onReceive(Context context, Intent intent) {
        Bundle bundle = intent.getExtras();
        try {
            if(bundle != null) {
                final Object[] msgContent = (Object[]) bundle.get("pdus");
                for(int i = 0; i < msgContent.length; i++) {
                    String format = bundle.getString("format");
                    SmsMessage myNewSms = SmsMessage.createFromPdu((byte[]) msgContent[i], format);
                    NewMessageNotification msgNotification = new NewMessageNotification();
                    msgNotification.notify(context, myNewSms.getDisplayOriginatingAddress(), myNewSms.getDisplayMessageBody(), id++);
                }
            }
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}
