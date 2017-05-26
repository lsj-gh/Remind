package com.example.administrator.mapleone.activity;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.administrator.mapleone.R;
import com.example.administrator.mapleone.service.MyService;

public class MyServiceActivity extends AppCompatActivity implements View.OnClickListener {
//    private MyService myService = new MyService();
    private MyService myService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_service);
        Button startButton = (Button) findViewById(R.id.bt_start);
        Button stopButton = (Button) findViewById(R.id.bt_stop);
        startButton.setOnClickListener(this);
        stopButton.setOnClickListener(this);
    }
    ServiceConnection connection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            MyService.MyBinder binder = (MyService.MyBinder) service;
            myService = binder.getService();
            myService.showLog("onServiceConnected");
        }
        @Override
        public void onServiceDisconnected(ComponentName name) {
            myService.showLog("onServiceDisconnected");
        }
    };
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bt_start:
                Intent startIntent = new Intent(this, MyService.class);
                startIntent.putExtra("name", "wayslde");
//                startService(startIntent);
                bindService(startIntent,connection,BIND_AUTO_CREATE);
                break;
            case R.id.bt_stop:
//                Intent stopIntent = new Intent(this, MyService.class);
//                stopService(stopIntent);
//                myService.showLog();
                unbindService(connection);
                break;
        }
    }
}
