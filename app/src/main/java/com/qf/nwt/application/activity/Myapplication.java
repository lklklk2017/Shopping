package com.qf.nwt.application.activity;

import android.app.Application;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.qf.nwt.application.R;

import cn.smssdk.SMSSDK;

public class Myapplication extends Application {

    private static Context context;

    @Override
    public void onCreate() {
        context = getApplicationContext();

        super.onCreate();
        SMSSDK.initSDK(this, "1a572d75789c7", "f0989f3f69c2f302ac90b7a6ba567147");
    }

    public static Context getContext(){
        return context;
    }



}
