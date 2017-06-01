package com.example.administrator.mapleone.activity;

import android.content.ComponentName;
import android.content.pm.PackageManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.administrator.mapleone.R;

public class MyChangeActivity extends AppCompatActivity {
    private ComponentName mOne, mTwo, mDefault;
    private PackageManager packageManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_change);
        initData();
//        这里点击事件调用changeOne()，changeTwo()，changeDefault()
        findViewById(R.id.bt_change_one).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeOne();
            }
        });
        findViewById(R.id.bt_change_two).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeTwo();
            }
        });
        findViewById(R.id.bt_change_default).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeDefault();
            }
        });
    }

    private void initData() {
//        这里的名字要跟AndroidManifest中定义的名字相同
        mOne = new ComponentName(getBaseContext(), "com.example.administrator.mapleone.activity.Maple01");
        mTwo = new ComponentName(getBaseContext(), "com.example.administrator.mapleone.activity.Maple02");
        mDefault = new ComponentName(getBaseContext(), "com.example.administrator.mapleone.activity.MyChangeActivity");
//        mDefault = getComponentName();
        packageManager = getApplicationContext().getPackageManager();
    }

    /**
     * 切换第一个icon和名称
     */
    public void changeOne() {
        disableComponentName(mTwo);
        disableComponentName(mDefault);
        enableComponentName(mOne);
    }

    /**
     *切换第二个icon和名称
     */
    public void changeTwo() {
        disableComponentName(mOne);
        disableComponentName(mDefault);
        enableComponentName(mTwo);
    }

    /**
     *切换默认的icon和名称
     */
    public void changeDefault() {
        disableComponentName(mOne);
        disableComponentName(mTwo);
        enableComponentName(mDefault);
    }

    private void enableComponentName(ComponentName componentName) {
        packageManager.setComponentEnabledSetting(componentName, PackageManager.COMPONENT_ENABLED_STATE_ENABLED,
                PackageManager.DONT_KILL_APP);
    }

    private void disableComponentName(ComponentName componentName) {
        packageManager.setComponentEnabledSetting(componentName, PackageManager.COMPONENT_ENABLED_STATE_DISABLED,
                PackageManager.DONT_KILL_APP);
    }
}
//以下是AndroidManifest中的配置，也就是把MainActivity改成了MyChangeActivity
/*
<activity android:name=".activity.MyChangeActivity">
<intent-filter>
<action android:name="android.intent.action.MAIN"/>

<category android:name="android.intent.category.LAUNCHER"/>
</intent-filter>
</activity>

<activity-alias
        android:name="com.example.administrator.mapleone.activity.Maple01"
        android:enabled="false"
        android:icon="@mipmap/btn_close_normal"
        android:label="第一个"
        android:targetActivity=".activity.MyChangeActivity">
<intent-filter>
<action android:name="android.intent.action.MAIN"/>

<category android:name="android.intent.category.LAUNCHER"/>
</intent-filter>
</activity-alias>
<activity-alias
        android:name="com.example.administrator.mapleone.activity.Maple02"
        android:enabled="false"
        android:icon="@mipmap/btn_check_on_pressed_holo_light"
        android:label="第而个"
        android:targetActivity=".activity.MyChangeActivity">
<intent-filter>
<action android:name="android.intent.action.MAIN"/>

<category android:name="android.intent.category.LAUNCHER"/>
</intent-filter>
</activity-alias>
*/
