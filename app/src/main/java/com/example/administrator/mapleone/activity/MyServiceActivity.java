package com.example.administrator.mapleone.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.administrator.mapleone.R;
import com.example.administrator.mapleone.service.MyService;

public class MyServiceActivity extends AppCompatActivity implements View.OnClickListener {
    private MyService myService = new MyService();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_service);
        Button startButton = (Button) findViewById(R.id.bt_start);
        Button stopButton = (Button) findViewById(R.id.bt_stop);
        startButton.setOnClickListener(this);
        stopButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bt_start:
                Intent startIntent = new Intent(this, MyService.class);
                startIntent.putExtra("name", "wayslde");
                startService(startIntent);
                break;
            case R.id.bt_stop:
//                Intent stopIntent = new Intent(this, MyService.class);
//                stopService(stopIntent);
                myService.showLog();
                break;
        }
    }
}
