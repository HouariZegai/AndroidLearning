package com.houarizegai.notificationapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private NotificationManager notificationManager;
    private static int notificationIndex = 1;

    NewMessageNotification notification;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        notification = new NewMessageNotification();
    }

    public void onSendNotification(View view) {
//        NotificationCompat.Builder nbuild = new NotificationCompat.Builder(this, "channel_" + notificationIndex)
//                .setSmallIcon(R.drawable.tweet)
//                .setContentTitle("Danger")
//                .setContentText("The raining is coming soon");
//
//        notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
//        notificationManager.notify(0, nbuild.build());

        notification.notify(this, "Good morning", 1232);
    }

    public void onRemoveNotification(View view) {
//        notificationManager.cancelAll();
        notification.cancel(this);
    }
}
