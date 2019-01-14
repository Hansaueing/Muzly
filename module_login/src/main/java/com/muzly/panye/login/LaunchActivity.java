package com.muzly.panye.login;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;

import com.muzly.panye.login.sign.SignUpActivity;
import com.muzly.panye.module_login.R;

/**
 * @author Create by Payne
 * @date 2019/1/14  22:31
 */
public class LaunchActivity extends Activity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.launch_layout);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(LaunchActivity.this, SignUpActivity.class);
                startActivity(intent);
                finish();
            }
        },1500);

    }
}
