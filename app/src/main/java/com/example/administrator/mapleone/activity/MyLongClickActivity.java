package com.example.administrator.mapleone.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.EventLogTags;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;

import com.example.administrator.mapleone.R;
import com.example.administrator.mapleone.utils.Myshow;

public class MyLongClickActivity extends AppCompatActivity implements View.OnTouchListener, View.OnLongClickListener,
        View.OnClickListener {
    private Button buttonUp, buttonDown;
    private static int DAXIAO = 100;
    private static final String TAG = "MyLongClickActivity";
    private Thread myUpThread;
    private Thread myDownThread;
    private boolean isRun = false;
    private boolean isFirstLongClick = true;
    private boolean isOnTouch = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_long_click);
        buttonUp = (Button) findViewById(R.id.bt_long_click_up);
        buttonUp.setOnTouchListener(this);
        buttonUp.setOnLongClickListener(this);
        buttonUp.setOnClickListener(this);
        buttonDown = (Button) findViewById(R.id.bt_long_click_down);
        buttonDown.setOnTouchListener(this);
        buttonDown.setOnLongClickListener(this);
        buttonDown.setOnClickListener(this);
        myUpThread = new Thread(new MyUpThread());
        myDownThread = new Thread(new MyDownThread());
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        if (isOnTouch) {
            int i = event.getAction();
            switch (v.getId()) {
                case R.id.bt_long_click_up:

                    if (i == MotionEvent.ACTION_DOWN) {
                        isRun = true;
                        myUpThread.start();
                    } else if (i == MotionEvent.ACTION_UP) {
                        isRun = false;
                    }
                    break;
                case R.id.bt_long_click_down:
                    if (i == MotionEvent.ACTION_DOWN) {
                        isRun = true;
                        myDownThread.start();

                    } else if (i == MotionEvent.ACTION_UP) {
                        isRun = false;
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
        if (!isOnTouch) {
            switch (v.getId()) {
                case R.id.bt_long_click_up:
                    Myshow.d(TAG, "---这是点击--------up");
                    break;
                case R.id.bt_long_click_down:
                    Myshow.d(TAG, "---这是点击--------down");
                    break;
            }
        }
    }

    class MyUpThread implements Runnable {

        @Override
        public void run() {
            while (isRun) {
                try {
                    DAXIAO += 10;
                    Myshow.d(TAG, "-------------------------DAXIAO" + DAXIAO);
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        }
    }

    class MyDownThread implements Runnable {

        @Override
        public void run() {
            while (isRun) {
                try {
                    DAXIAO -= 10;
                    Myshow.d(TAG, "-------------------------DAXIAO" + DAXIAO);
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        }
    }
}
