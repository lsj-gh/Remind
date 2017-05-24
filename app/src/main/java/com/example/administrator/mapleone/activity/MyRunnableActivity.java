package com.example.administrator.mapleone.activity;

import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.administrator.mapleone.R;
import com.example.administrator.mapleone.utils.Myshow;

public class MyRunnableActivity extends AppCompatActivity implements View.OnClickListener {
    private TextView textView;
    private static final String TAG = "MyRunnableActivity";
    public static final int UPDATA_TEXT_RUN = 1;
    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            Myshow.d(TAG, "go into handleMessage");
            switch (msg.what) {
                case UPDATA_TEXT_RUN:
                    Myshow.d(TAG, "go into UPDATA_TEXT_RUN");
                    textView.setText("obtainMessage");
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_runnable);
        Button button = (Button) findViewById(R.id.bt_run);
        textView = (TextView) findViewById(R.id.tv_run);
        button.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                handler.obtainMessage(UPDATA_TEXT_RUN).sendToTarget();
                Myshow.d(TAG, "obtainMessage");
                Myshow.showToastOnUiThread(MyRunnableActivity.this, "showToastOnUiThread");
//                Message message = new Message();
//                message.what = UPDATA_TEXT_RUN;
//                handler.sendMessage(message);
//                Myshow.d(TAG,"obtainMessage");
            }
        }).start();
    }
}
