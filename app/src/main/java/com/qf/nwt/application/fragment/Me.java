package com.qf.nwt.application.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.qf.nwt.application.R;
import com.qf.nwt.application.activity.CollectionActivity;
import com.qf.nwt.application.activity.EditProfileActivity;
import com.qf.nwt.application.activity.LoginActivity;
import com.qf.nwt.application.activity.MessageCenterActivity;
import com.qf.nwt.application.activity.OrderActivity;
import com.qf.nwt.application.activity.SettingActivity;

/**
 * A simple {@link Fragment} subclass.
 */
public class Me extends Fragment implements View.OnClickListener {


    private View view;
    private ImageView img_setting;
    private ImageView img_msg;
    private RelativeLayout all_order;
    private RelativeLayout wait_pay;
    private RelativeLayout underway;
    private RelativeLayout completed;
    private ImageView img_head;
    private RelativeLayout layout_collection;

    public Me() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_me, container, false);
        findViewID();
        initListener();
        return view;
    }

    /**
     * 设置监听
     */
    private void initListener() {
        img_setting.setOnClickListener(this);
        img_msg.setOnClickListener(this);
        all_order.setOnClickListener(this);
        wait_pay.setOnClickListener(this);
        underway.setOnClickListener(this);
        completed.setOnClickListener(this);
        img_head.setOnClickListener(this);
        layout_collection.setOnClickListener(this);
    }

    /**
     * 找id
     */
    private void findViewID() {
        img_setting = (ImageView) view.findViewById(R.id.img_setting);
        img_msg = (ImageView) view.findViewById(R.id.img_msg);
        img_head = (ImageView) view.findViewById(R.id.img_head);
        all_order = (RelativeLayout) view.findViewById(R.id.layout_all_order);
        wait_pay = (RelativeLayout) view.findViewById(R.id.layout_wait_pay);
        underway = (RelativeLayout) view.findViewById(R.id.layout_underway);
        completed = (RelativeLayout) view.findViewById(R.id.layout_completed);
        layout_collection = (RelativeLayout) view.findViewById(R.id.layout_collection);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            //点击设置
            case R.id.img_setting:
                Intent intent = new Intent(getActivity(), SettingActivity.class);
                startActivity(intent);
                break;
            //点击消息
            case R.id.img_msg:
                Intent intent1 = new Intent(getActivity(), MessageCenterActivity.class);
                startActivity(intent1);
                break;
            //点击所有订单
            case R.id.layout_all_order:
                Intent intent2 = new Intent(getActivity(), OrderActivity.class);
                intent2.putExtra("position",0);
                startActivity(intent2);
                break;
            //待支付
            case R.id.layout_wait_pay:
                Intent intent3 = new Intent(getActivity(), OrderActivity.class);
                intent3.putExtra("position",1);
                startActivity(intent3);
                break;
            //进行中
            case R.id.layout_underway:
                Intent intent4 = new Intent(getActivity(), OrderActivity.class);
                intent4.putExtra("position",2);
                startActivity(intent4);
                break;
            //已完成
            case R.id.layout_completed:
                Intent intent5 = new Intent(getActivity(), OrderActivity.class);
                intent5.putExtra("position",3);
                startActivity(intent5);
                break;
            //点击头像
            case R.id.img_head:
                //点击头像登录
                Intent intent6 = new Intent(getActivity(), LoginActivity.class);
                startActivity(intent6);
                //如果已经登录成功，点击头像就进入编辑档案界面
//                Intent intent7 = new Intent(getActivity(), EditProfileActivity.class);
//                startActivity(intent7);
                break;
            case R.id.layout_collection:
                Intent intent8 = new Intent(getContext(), CollectionActivity.class);
                startActivity(intent8);
                break;
        }
    }
}
