package com.qf.nwt.application.activity;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.qf.nwt.application.R;
import com.qf.nwt.application.fragment.themefragements.ThemeContent;

public class ThemActivity extends AppCompatActivity {

    private FragmentManager supportFragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_them);

        init();
    }

    private void init() {
        initView();
        initFragment();
    }

    /**
     * 用于初始化各种fragments
     */
    private void initFragment() {
        supportFragmentManager = getSupportFragmentManager();
        FragmentTransaction t = supportFragmentManager.beginTransaction();
        t.replace(R.id.replace_Theme,new ThemeContent());
        t.commit();

    }

    private void initView() {

    }
}
