package com.kimjinhwan.android.alarmtest;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.util.Log;

/**
 * Created by XPS on 2017-07-13.
 */

public class AlarmReceiver1 extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Intent service1 = new Intent(context, NotificationService1.class);
        service1.setData((Uri.parse("custom://"+System.currentTimeMillis())));
        context.startService(service1);
        Log.d("Broadcast:", "여기까진 왔음");
    }
}
