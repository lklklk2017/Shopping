package com.qf.nwt.application.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.qf.nwt.application.R;
import com.qf.nwt.application.fragment.Me;

public class SettingActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageView img_back;
    private RelativeLayout common_layout1;
    private RelativeLayout common_layout2;
    private RelativeLayout layout_exit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);
        findViewId();
        initListener();
    }

    private void initListener() {
        img_back.setOnClickListener(this);
        common_layout1.setOnClickListener(this);
        common_layout2.setOnClickListener(this);
        layout_exit.setOnClickListener(this);
    }

    private void findViewId() {
        img_back = (ImageView) findViewById(R.id.img_back);
        common_layout1 = (RelativeLayout) findViewById(R.id.common_layout1);
        common_layout2 = (RelativeLayout) findViewById(R.id.common_layout2);
        layout_exit = (RelativeLayout) findViewById(R.id.layout_exit);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.img_back:
                finish();
                break;
            case R.id.common_layout1:
                Intent intent1 = new Intent(this,ChangePwdActivity.class);
                startActivity(intent1);
                break;
            case R.id.common_layout2:
                Intent intent2 = new Intent(this,ChangePhoneNumber.class);
                startActivity(intent2);
                break;
            case R.id.layout_exit:
                Intent intent3 = new Intent(this,LoginActivity.class);
                startActivity(intent3);
                break;
        }
    }
}
