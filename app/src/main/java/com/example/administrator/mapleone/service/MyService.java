package com.example.administrator.mapleone.service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.IntDef;

import com.example.administrator.mapleone.utils.Myshow;

public class MyService extends Service {
    private static final String TAG = "MyService";
    static String logMessage;                   //这个地方需要静态

    public MyService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Myshow.d(TAG, "MyService-------------onCreate()");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Myshow.d(TAG, "MyService-------------onStartCommand()");
        logMessage = intent.getStringExtra("name");

        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Myshow.d(TAG, "MyService-------------onDestroy()");
    }

    public void showLog() {
//        Myshow.d(TAG, "showLog()");
        Myshow.d(TAG, logMessage);
    }
}
