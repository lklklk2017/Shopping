package com.qf.nwt.application.fragment;


import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.qf.nwt.application.R;
import com.qf.nwt.application.activity.CollectionActivity;
import com.qf.nwt.application.activity.EditProfileActivity;
import com.qf.nwt.application.activity.LoginActivity;
import com.qf.nwt.application.activity.MessageCenterActivity;
import com.qf.nwt.application.activity.OrderActivity;
import com.qf.nwt.application.activity.SettingActivity;
import com.qf.nwt.application.bean.LoginEntity;
import com.qf.nwt.application.service.LoginHttpService;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * A simple {@link Fragment} subclass.
 */
public class Me extends Fragment implements View.OnClickListener {

    private Context context;
    private View view;
    private ImageView img_setting;
    private ImageView img_msg;
    private RelativeLayout all_order;
    private RelativeLayout wait_pay;
    private RelativeLayout underway;
    private RelativeLayout completed;
    private ImageView img_head;
    private RelativeLayout layout_collection;
    private SwipeRefreshLayout refreshLayout;
    private TextView tv_name;
    private TextView tv_experience;

    public Me() {
        // Required empty public constructor
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.context = context;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_me, container, false);
        findViewID();
        refreshLayout.setColorSchemeColors(Color.RED, Color.BLUE, Color.YELLOW);
        refreshLayout.setRefreshing(true);
        initData();
        initListener();
        return view;
    }

    /**
     * 设置监听
     */
    private void initListener() {
        refreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                initData();
            }
        });
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
        refreshLayout = (SwipeRefreshLayout) view.findViewById(R.id.refreshLayout);
        img_setting = (ImageView) view.findViewById(R.id.img_setting);
        img_msg = (ImageView) view.findViewById(R.id.img_msg);
        img_head = (ImageView) view.findViewById(R.id.img_head);
        all_order = (RelativeLayout) view.findViewById(R.id.layout_all_order);
        wait_pay = (RelativeLayout) view.findViewById(R.id.layout_wait_pay);
        underway = (RelativeLayout) view.findViewById(R.id.layout_underway);
        completed = (RelativeLayout) view.findViewById(R.id.layout_completed);
        layout_collection = (RelativeLayout) view.findViewById(R.id.layout_collection);
        tv_name = (TextView) view.findViewById(R.id.tv_name);
        tv_experience = (TextView) view.findViewById(R.id.tv_experience);
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
    /**
     * 初始化数据
     */
    public void initData() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://api.palshock.cn/")
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        LoginHttpService loginHttpService = retrofit.create(LoginHttpService.class);
        Observable<LoginEntity> data = loginHttpService.getData("e10adc3949ba59abbe56e057f20f883e","18408249795");
        data.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<LoginEntity>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(LoginEntity loginEntity) {
                        String userImgUrl = loginEntity.getUserImgUrl();
                        Log.e("====","userImgUrl="+loginEntity.toString());
                        Glide.with(getContext()).load(userImgUrl).placeholder(R.mipmap.ic_launcher)
                                .into(img_head);
                        String userName = loginEntity.getUserName();
                        tv_name.setText(userName);
                        refreshLayout.setRefreshing(false);
                    }
                });
    }
}