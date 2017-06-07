package com.example.administrator.mapleone.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;

import com.example.administrator.mapleone.R;
import com.example.administrator.mapleone.modle.MyLongClickModle;
import com.example.administrator.mapleone.modle.MyLongClickModleImp;
import com.example.administrator.mapleone.utils.Myshow;

public class MyLongClickImpActivity extends AppCompatActivity implements View.OnTouchListener, View.OnLongClickListener,
        View.OnClickListener {
    private Button buttonUp, buttonDown, buttonJump, buttonIslive;
    public static int DAXIAO = 100;
    private static final String TAG = "MyLongClickActivity";
    private boolean isFirstLongClick = true;
    private boolean isOnTouch = false;
    MyLongClickModle myLongClickModle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_long_click);
        buttonUp = (Button) findViewById(R.id.bt_long_click_up);
        buttonDown = (Button) findViewById(R.id.bt_long_click_down);
        buttonJump = (Button) findViewById(R.id.bt_click_jump);
        buttonIslive = (Button) findViewById(R.id.bt_isalive);
        buttonUp.setOnTouchListener(this);
        buttonUp.setOnLongClickListener(this);
        buttonUp.setOnClickListener(this);
        buttonDown.setOnTouchListener(this);
        buttonDown.setOnLongClickListener(this);
        buttonDown.setOnClickListener(this);
        buttonJump.setOnClickListener(this);
        buttonIslive.setOnClickListener(this);
        myLongClickModle = MyLongClickModleImp.getInstance(this);
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        if (isOnTouch) {
            int i = event.getAction();
            switch (v.getId()) {
                case R.id.bt_long_click_up:

                    if (i == MotionEvent.ACTION_DOWN) {
                        myLongClickModle.isRunClick(true);
                        myLongClickModle.myClickUp();
                    } else if (i == MotionEvent.ACTION_UP) {
                        myLongClickModle.isRunClick(false);
                    }
                    break;
                case R.id.bt_long_click_down:
                    if (i == MotionEvent.ACTION_DOWN) {
                        myLongClickModle.isRunClick(true);
                        myLongClickModle.myClickDown();
                    } else if (i == MotionEvent.ACTION_UP) {
                        myLongClickModle.isRunClick(false);
                    }
                    break;
            }
        }
        return false;
    }

    @Override
    public boolean onLongClick(View v) {
        if (isFirstLongClick) {
            Myshow.d(TAG, "---这是长按");
            isFirstLongClick = false;
            isOnTouch = true;
        }
        return false;
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.bt_long_click_up:
                if (!isOnTouch) {
                    Myshow.d(TAG, "---这是点击--------up");
                }
                break;
            case R.id.bt_long_click_down:
                if (!isOnTouch) {
                    Myshow.d(TAG, "---这是点击--------down");
                }
                break;
            case R.id.bt_click_jump:
                startActivity(new Intent(MyLongClickImpActivity.this, MainActivity.class));
                break;
            case R.id.bt_isalive:
//                startActivity(new Intent(MyLongClickImpActivity.this, MainActivity.class));
                myLongClickModle.checkIsAlive();
                break;
        }

    }

    @Override
    protected void onStop() {
        super.onStop();

    }

    @Override
    protected void onPause() {
        super.onPause();
        Myshow.d(TAG, "--------------onPause()");
    }
}
