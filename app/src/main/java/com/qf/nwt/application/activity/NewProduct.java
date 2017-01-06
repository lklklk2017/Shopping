package com.qf.nwt.application.activity;

import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;

import com.qf.nwt.application.R;
import com.qf.nwt.application.adapter.AdpaterOfNewProduct;
import com.qf.nwt.application.bean.NewProductInfo;

import java.util.ArrayList;

public class NewProduct extends AppCompatActivity {

    private RecyclerView rcy;
    private SwipeRefreshLayout swip;
    private ArrayList<NewProductInfo> list;
    private AdpaterOfNewProduct adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_product);

        init();
    }

    private void init() {

        initview();
//        initRetrofit();
        initAdapter();
        initData();
        initListener();
    }

    private void initListener() {

    }

    private void initData() {
        list = new ArrayList<NewProductInfo>();
    }

    private void initAdapter() {
        adapter = new AdpaterOfNewProduct(this);
        rcy.setAdapter(adapter);
    }

    private void initview() {
        rcy = ((RecyclerView) findViewById(R.id.recycle_NewProduct));
        swip = ((SwipeRefreshLayout) findViewById(R.id.swipe_NewProduct));

        //初始化rcy
        rcy.setLayoutManager(new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL));
    }
}
