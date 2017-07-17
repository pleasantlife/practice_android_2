package com.kimjinhwan.android.alarmtest2;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setAlarm();
    }


    public void setAlarm(){

        AlarmManager alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);
        //Intent alarmIntent = new Intent("com.kimjinhwan.android.alarmtest2.ALARM_START");
        Intent alarmIntent = new Intent(this, AlarmReceiver.class);

        PendingIntent mPendingIntent = PendingIntent.getBroadcast(this, 0, alarmIntent, PendingIntent.FLAG_CANCEL_CURRENT);

        Calendar alarmStartTime = Calendar.getInstance();
        alarmStartTime.set(Calendar.HOUR_OF_DAY, 12);
        alarmStartTime.set(Calendar.MINUTE, 29);
        alarmStartTime.set(Calendar.SECOND, 0);
        if(alarmStartTime.after(alarmStartTime)){
            alarmStartTime.add(Calendar.DATE, 1);
        }
        Log.i("ALARM","time="+alarmStartTime.getTime());
        alarmManager.setRepeating(AlarmManager.RTC_WAKEUP, alarmStartTime.getTimeInMillis(), getInterval(), mPendingIntent);
        //alarmManager.set(AlarmManager.RTC_WAKEUP, alarmStartTime.getTimeInMillis(), mPendingIntent);
    }
    private int getInterval(){
        int days = 1;
        int hours = 24;
        int minutes = 60;
        int seconds = 60;
        int milliseconds = 1000;
        int repeatMS = days * hours * minutes * seconds * milliseconds;
        return repeatMS;
    }
}
