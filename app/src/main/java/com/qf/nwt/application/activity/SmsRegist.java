package com.qf.nwt.application.activity;

import android.app.Application;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.qf.nwt.application.R;

import cn.smssdk.SMSSDK;

public class SmsRegist extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        SMSSDK.initSDK(this, "1a572d75789c7", "f0989f3f69c2f302ac90b7a6ba567147");
    }
}
