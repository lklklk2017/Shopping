package com.qf.nwt.application.activity;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.qf.nwt.application.R;
import com.qf.nwt.application.adapter.AdapterOfExpandableListView;
import com.qf.nwt.application.adapter.AdapterOfGoodsDetailPager;
import com.qf.nwt.application.bean.Children;
import com.qf.nwt.application.bean.GoodsDetailEntity;
import com.qf.nwt.application.bean.Group;
import com.qf.nwt.application.service.HttpApiServiceOfGoodsDetail;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class GoodsDetailActivity extends AppCompatActivity {

    private ViewPager vp_img;
    private ImageView img_back;
    private ImageView img_share;
    private TextView tv_brc;
    private TextView tv_title;
    private TextView tv_price;
    private TextView tv_dec;
    private ImageView img_logo;
    private TextView tv_deliverTime;
    private TextView tv_deliverPolicy;
    private TextView tv_deliverWay;
    private TextView tv_sendFrom;
    private TextView tv_returnPolicy;

    private List<GoodsDetailEntity.ImagesBean> dataList = new ArrayList<>();
    private AdapterOfGoodsDetailPager adapter;
    private AdapterOfExpandableListView adapterOfExpandableListView;
    private LinearLayout layout_params;
    private ExpandableListView ex_listView;
    private String[] groups = new String[]{"商品详情"};
    private List<Group> groupList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_goods_detail);
        findViewId();
        initData();
        initAdapter();
        initListener();
    }

    /**
     * 初始化监听
     */
    private void initListener() {

        ex_listView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView expandableListView, View view, int i, int i1, long l) {
                return true;
            }
        });
        img_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        vp_img.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                //根据布局容器得到其中的所有child
                int count = layout_params.getChildCount();
                for (int i = 0; i < count; i++) {
                    ImageView imgPoint = (ImageView) layout_params.getChildAt(i);
                    if (i == position) {
                        imgPoint.setImageResource(R.drawable.pressed_point);
                    }else {
                        imgPoint.setImageResource(R.drawable.default_point);
                    }
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    /**
     * 初始化数据源
     */
    private void initData() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://api.palshock.cn/")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
        HttpApiServiceOfGoodsDetail goodsDetail = retrofit.create(HttpApiServiceOfGoodsDetail.class);
        Observable<GoodsDetailEntity> data = goodsDetail.getData();
        data.observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Subscriber<GoodsDetailEntity>() {
                    @Override
                    public void onCompleted() {
                        Log.e("====","===onCompleted===");
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e("====","===onError==="+e.getMessage());
                    }

                    @Override
                    public void onNext(GoodsDetailEntity goodsDetailEntity) {
                        List<GoodsDetailEntity.ImagesBean> images = goodsDetailEntity.getImages();
                        dataList.addAll(images);
                        adapter.notifyDataSetChanged();

                        for (int i = 0; i < dataList.size(); i++) {
                            //加载圆点（指示器）
                            ImageView imgPoint = new ImageView(GoodsDetailActivity.this);
                            if (i == 0) {
                                imgPoint.setImageResource(R.drawable.pressed_point);
                            }else {
                                imgPoint.setImageResource(R.drawable.default_point);
                            }
                            imgPoint.setPadding(5,0,5,0);
                            layout_params.addView(imgPoint);
                        }
                        //适配数据
                        String title = goodsDetailEntity.getTitle();
                        tv_title.setText(title);
                        String desc = goodsDetailEntity.getDesc();
                        tv_dec.setText(desc);
                        String brC = goodsDetailEntity.getBrand().getBrC();
                        tv_brc.setText(brC);
                        int prc = goodsDetailEntity.getPrices().get(0).getPrc();
                        tv_price.setText("￥"+prc+"");
                        String logo = goodsDetailEntity.getVendor().getLogo();
                        Glide.with(GoodsDetailActivity.this)
                                .load(logo)
                                .placeholder(R.mipmap.ic_launcher)
                                .into(img_logo);
                        String deliverPolicy = goodsDetailEntity.getVendor().getDeliverPolicy();
                        tv_deliverPolicy.setText(deliverPolicy);
                        String deliverTime = goodsDetailEntity.getVendor().getDeliverTime();
                        tv_deliverTime.setText(deliverTime);
                        String deliverWay = goodsDetailEntity.getVendor().getDeliverWay();
                        tv_deliverWay.setText(deliverWay);
                        String sendFrom = goodsDetailEntity.getVendor().getSendFrom();
                        tv_sendFrom.setText(sendFrom);
                        String returnPolicy = goodsDetailEntity.getVendor().getReturnPolicy();
                        tv_returnPolicy.setText(returnPolicy);
                    }


                });

    }

    /**
     * 初始化适配器
     */
    private void initAdapter() {
        for (int i = 0; i < groups.length; i++) {
            Group group = new Group();
            group.setTitle(groups[i]);
            List<Children> childrens = new ArrayList<>();
            for (int j = 0; j < dataList.size(); j++) {
                Children children = new Children();
                children.setImg_url(dataList.get(i).getUrl());
                childrens.add(children);
            }
            Log.e("====", "childrens.size()=" + childrens.size());
            group.setChildrens(childrens);
            groupList.add(group);
        }

        adapter = new AdapterOfGoodsDetailPager(this);
        //加载空数据
        vp_img.setAdapter(adapter);
        adapter.setImagesBeanList(dataList);
        //加载有数据
        vp_img.setAdapter(adapter);

        adapterOfExpandableListView = new AdapterOfExpandableListView(this);
        //加载空数据
        ex_listView.setAdapter(adapterOfExpandableListView);
        //加载有数据
        adapterOfExpandableListView.setGroups(groupList);
        ex_listView.setAdapter(adapterOfExpandableListView);

    }

    /**
     * 找id
     */
    private void findViewId() {
        img_back = (ImageView) findViewById(R.id.img_back);
        img_share = (ImageView) findViewById(R.id.img_share);
        img_logo = (ImageView) findViewById(R.id.img_logo);
        vp_img = (ViewPager) findViewById(R.id.vp_img);
        tv_brc = (TextView) findViewById(R.id.tv_brc);
        tv_title = (TextView) findViewById(R.id.tv_title);
        tv_price = (TextView) findViewById(R.id.tv_price);
        tv_dec = (TextView) findViewById(R.id.tv_dec);
        tv_deliverTime = (TextView) findViewById(R.id.tv_deliverTime);
        tv_deliverPolicy = (TextView) findViewById(R.id.tv_deliverPolicy);
        tv_deliverWay = (TextView) findViewById(R.id.tv_deliverWay);
        tv_sendFrom = (TextView) findViewById(R.id.tv_sendFrom);
        tv_returnPolicy = (TextView) findViewById(R.id.tv_returnPolicy);
        layout_params = (LinearLayout) findViewById(R.id.layout_params);
        ex_listView = (ExpandableListView) findViewById(R.id.ex_listView);
    }
}
