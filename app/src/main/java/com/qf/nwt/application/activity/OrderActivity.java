package com.qf.nwt.application.activity;

import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.qf.nwt.application.R;
import com.qf.nwt.application.adapter.AdapterOfMsgCenter;
import com.qf.nwt.application.fragment.msgcenterfragments.MsgCenterFragment;

import java.util.ArrayList;
import java.util.List;

public class OrderActivity extends AppCompatActivity implements View.OnClickListener {

    private TabLayout tabLayout;
    private ViewPager viewPager;
    //tabLayout数据源
    private String[] tabTitles = {"所有订单","待支付","进行中","已完成"};
    //声明并初始化fragment集合
    private List<Fragment>fragments = new ArrayList<>();
    //暂且用信息中心的适配器
    private AdapterOfMsgCenter adapter;
    private ImageView img_back;
    //Me传过来的位置
    private int position;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);
        getPosition();
        findViewId();
        initView();
        initAdapter();
        initListener();
    }

    /**
     * 得到位置
     */
    private void getPosition() {
        Intent intent = getIntent();
        position = intent.getIntExtra("position", 0);
    }

    /**
     * 初始化监听
     */
    private void initListener() {
        img_back.setOnClickListener(this);
    }

    /**
     * 初始化adapter
     */
    private void initAdapter() {
        adapter = new AdapterOfMsgCenter(getSupportFragmentManager(),tabTitles,fragments);
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);
        viewPager.setCurrentItem(position);
    }

    /**
     * 初始化
     */
    private void initView() {
        for (int i = 0; i < tabTitles.length; i++) {
            fragments.add(new MsgCenterFragment());
        }
    }

    /**
     * 找id
     */
    private void findViewId() {
        tabLayout = (TabLayout) findViewById(R.id.tablayout_order);
        viewPager = (ViewPager) findViewById(R.id.viewPager_order);
        img_back = (ImageView) findViewById(R.id.img_back);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.img_back:
                finish();
                break;
        }
    }
}
