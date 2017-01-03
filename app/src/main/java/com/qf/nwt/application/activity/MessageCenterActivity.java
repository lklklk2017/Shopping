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

public class MessageCenterActivity extends AppCompatActivity implements View.OnClickListener {

    private TabLayout tabLayout;
    private ViewPager viewPager;
    //tabLayout的title的数据源
    private String[] tabTitles = {"赞/关注","评论","系统消息","订单消息"};
    //fragment数据源
    private List<Fragment>fragments = new ArrayList<>();
    //声明适配器
    private AdapterOfMsgCenter adapterOfMsgCenter;
    private ImageView img_back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message_center);
        findViewId();
        initView();
        initAdapter();
        initListener();
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

        adapterOfMsgCenter = new AdapterOfMsgCenter(getSupportFragmentManager(),tabTitles,fragments);
        viewPager.setAdapter(adapterOfMsgCenter);
        tabLayout.setupWithViewPager(viewPager);
    }

    /**
     * 初始化fragment
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
        tabLayout = (TabLayout) findViewById(R.id.tablayout_msgcenter);
        viewPager = (ViewPager) findViewById(R.id.viewPager_msg);
        img_back = (ImageView) findViewById(R.id.img_back);
    }

    /**
     * 点击事件
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
