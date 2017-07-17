package com.kimjinhwan.android.alarmtest2;

import android.app.NotificationManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

/**
 * Created by XPS on 2017-07-13.
 */

public class AlarmReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        Log.i("Receiver","========================================Received");
        Intent service1 = new Intent(context, AlarmService.class);
        context.startService(service1);
    }
}
