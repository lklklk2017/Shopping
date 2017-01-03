package com.qf.nwt.application.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.qf.nwt.application.R;

public class CollectionActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageView img_back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_collection);
        findViewId();
        initListner();
    }

    /**
     * 初始化监听
     */
    private void initListner() {
        img_back.setOnClickListener(this);
    }

    /**
     * 找id
     */
    private void findViewId() {
        img_back = (ImageView) findViewById(R.id.img_back);
    }

    /**
     * 点击监听事件
     * @param view
     */
    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.img_back:
                finish();
                break;
        }
    }
}
