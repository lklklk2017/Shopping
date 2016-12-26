package com.qf.nwt.application.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import com.qf.nwt.application.R;

import java.util.Timer;
import java.util.TimerTask;


/**
 * 欢迎页面
 */
public class WelcomeAcitivty extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome_acitivty);

        final Intent intent = new Intent(this,MainActivity.class);
        Timer timer = new Timer();
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                startActivity(intent);
            }
        };

        timer.schedule(task,3000);//3秒后执行跳转
    }

    @Override
    protected void onStop() {
        super.onStop();
        finish();
    }
}
