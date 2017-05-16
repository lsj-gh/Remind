package com.example.administrator.mapleone.activity;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.administrator.mapleone.R;

public class MyShareActivity extends AppCompatActivity {
    private Button shareButton, getButton;
    private TextView tv_show;


    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_share);
        shareButton = (Button) findViewById(R.id.bt_share);
        getButton = (Button) findViewById(R.id.bt_share_get);
        tv_show = (TextView) findViewById(R.id.tv_share_show);
//        final SharedPreferences sharedPreferences = getSharedPreferences("maple_data", MODE_PRIVATE);
        shareButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                SharedPreferences.Editor editor = sharedPreferences.edit();
                SharedPreferences.Editor editor = getSharedPreferences("maple_data", MODE_PRIVATE).edit();
                editor.putString("name", "maple");
                editor.putString("motto", "wayside");
                editor.commit();
            }
        });
        getButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences sharedPreferences = getSharedPreferences("maple_data", MODE_PRIVATE);
                String name = sharedPreferences.getString("name", " ");
                String motto =sharedPreferences.getString("motto", " ");
                tv_show.setText(name + "----------" + motto);
            }
        });
    }
}
