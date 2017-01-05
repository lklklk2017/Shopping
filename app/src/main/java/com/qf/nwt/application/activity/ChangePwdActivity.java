package com.qf.nwt.application.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.qf.nwt.application.R;

public class ChangePwdActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageView img_back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_pwd);
        findViewId();
        initListener();
    }

    private void initListener() {
        img_back.setOnClickListener(this);
    }

    private void findViewId() {
        img_back = (ImageView) findViewById(R.id.img_back);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.img_back:
                Intent intent = new Intent(this,SettingActivity.class);
                startActivity(intent);
                finish();
                break;
        }
    }
}
