package com.example.administrator.mapleone.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.administrator.mapleone.R;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button button, button2, button3, button4, button5;
    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initFind();
    }

    private void initFind() {
        button = (Button) findViewById(R.id.button);
        button2 = (Button) findViewById(R.id.button2);
        button3 = (Button) findViewById(R.id.button3);
        button4 = (Button) findViewById(R.id.bt4);
        button5 = (Button) findViewById(R.id.bt5);
        button.setOnClickListener(this);
        button2.setOnClickListener(this);
        button3.setOnClickListener(this);
        button4.setOnClickListener(this);
        button5.setOnClickListener(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button:
                startActivitys(MyRecyclerViewActivity.class);
                break;
            case R.id.button2:
                startActivitys(MyShareActivity.class);
                break;
            case R.id.button3:
                startActivitys(MyDataBaseActivity.class);
                break;
            case R.id.bt4:
                startActivitys(MyPermissionActivity.class);
                break;
            case R.id.bt5:
                startActivitys(MyRunnableActivity.class);
                break;

        }
    }

    private void startActivitys(Class<?> cls) {
        Intent intent = new Intent(MainActivity.this, cls);
        startActivity(intent);
    }

    private void toastShow(String s) {
        Toast.makeText(MainActivity.this, s, Toast.LENGTH_SHORT).show();
    }
}
