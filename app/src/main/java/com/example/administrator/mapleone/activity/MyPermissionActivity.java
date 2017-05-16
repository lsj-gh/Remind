package com.example.administrator.mapleone.activity;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.administrator.mapleone.R;

public class MyPermissionActivity extends AppCompatActivity {
    private static final String TAG = "MyPermissionActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_permission);
        findViewById(R.id.bt_permission_call).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                判断是否已经授权
                if (ContextCompat.checkSelfPermission(MyPermissionActivity.this, Manifest.permission.CALL_PHONE) !=
                        PackageManager.PERMISSION_GRANTED) {
//                    如果没有授权就申请权限
                    ActivityCompat.requestPermissions(MyPermissionActivity.this, new String[]{Manifest.permission
                            .CALL_PHONE}, 1);
                } else {
//                    如果已经授权就直接拨打
                    myCall();
                }
            }
        });
    }

    private void myCall() {
        Intent intent = new Intent(Intent.ACTION_CALL);
        intent.setData(Uri.parse("tel:10086"));
        try {
            startActivity(intent);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 请求权限的返回
     *
     * @param requestCode  请求码
     * @param permissions  请求的权限
     * @param grantResults 授权结果
     */
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[]
            grantResults) {
        switch (requestCode) {
            case 1:
                Log.d(TAG, permissions[0]);//log结果 MyPermissionActivity: android.permission.CALL_PHONE
//                判断请求是否成功
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    myCall();
                    Log.d(TAG, "onRequestPermissionsResult: success");
                } else {
                    Log.d(TAG, "onRequestPermissionsResult: failed");
                }
                break;
        }
    }
}
