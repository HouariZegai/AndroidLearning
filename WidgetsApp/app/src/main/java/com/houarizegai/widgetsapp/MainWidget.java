package com.houarizegai.widgetsapp;

import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.Context;
import android.content.Intent;
import android.icu.text.SimpleDateFormat;
import android.widget.RemoteViews;

import java.util.Date;

public class MainWidget extends AppWidgetProvider {
    @Override
    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds) {
        for(int i = 0; i < appWidgetIds.length; i++) {
            RemoteViews views = new RemoteViews(context.getPackageName(), R.layout.activity_main_widget);

            String currentDateAndTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
            views.setTextViewText(R.id.txtView, currentDateAndTime);

            Intent intent = new Intent(context, MainActivity.class);
            PendingIntent pendingIntent = PendingIntent.getActivity(context, 0, intent, 0);

            // If i click on the button > go to main activity
            views.setOnClickPendingIntent(R.id.btn, pendingIntent);

            appWidgetManager.updateAppWidget(appWidgetIds, views);
        }
    }
}
