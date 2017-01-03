package com.qf.nwt.application.fragment.tendencyFragments;


import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.qf.nwt.application.R;
import com.qf.nwt.application.adapter.AdapterOfHotRecycleView;
import com.qf.nwt.application.adapter.AdapterOfHotViewpage;
import com.qf.nwt.application.bean.Info;
import com.qf.nwt.application.utils.ScreenMatch;

import java.util.ArrayList;
import java.util.List;

import cn.trinea.android.view.autoscrollviewpager.AutoScrollViewPager;

/**
 * A simple {@link Fragment} subclass.
 * 趋势-热门
 * 该页面采用了recycle和SwipeRefreshLayout联用，实现数据的加载和更新
 */
public class Hot extends Fragment {


    private View view;
    private List<Integer> list_vp;
    private List<Info> list_info;
    private AdapterOfHotRecycleView adapterOfHotRecycleView;
    private RecyclerView rcy;
    private SwipeRefreshLayout swip;


    public Hot() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_hot, container, false);

        init();

        return view;
    }

    private void init() {
        initView();
        initAdapter();
        initListener();
        initData();
    }

    private void initListener() {
//        swip.setOnRefreshListener(new );
    }

    private void initAdapter() {
        adapterOfHotRecycleView = new AdapterOfHotRecycleView(getContext());
        rcy.setAdapter(adapterOfHotRecycleView);
    }

    /**
     * 初始化数据
     */
    private void initData() {
        list_vp = new ArrayList<>();
        list_vp.add(android.R.drawable.ic_dialog_alert);
        list_vp.add(android.R.drawable.ic_dialog_map);
        list_vp.add(android.R.drawable.ic_dialog_info);
        list_vp.add(android.R.drawable.ic_dialog_email);
        list_vp.add(android.R.drawable.ic_input_delete);

        list_info = new ArrayList<>();
        list_info.add(new Info("哈哈",R.mipmap.ic_launcher));//将行网络数据的加载的时候必须要空余出第一个位置，第一个要被忽略将代替
        list_info.add(new Info("呵呵",R.mipmap.ic_launcher));
        list_info.add(new Info("123",R.mipmap.ic_launcher));
        list_info.add(new Info("嗯呢",R.mipmap.ic_launcher));
        list_info.add(new Info("补补",R.mipmap.ic_launcher));
        list_info.add(new Info("补补",R.mipmap.ic_launcher));
        list_info.add(new Info("补补",R.mipmap.ic_launcher));
        list_info.add(new Info("补补",R.mipmap.ic_launcher));

        adapterOfHotRecycleView.setList(list_info,list_vp);
    }

    private void initView() {

        rcy = ((RecyclerView) view.findViewById(R.id.recycle_Hot));
        swip = ((SwipeRefreshLayout) view.findViewById(R.id.swipe_Hot));

        //初始化swip
        swip.setColorSchemeColors(Color.RED,Color.BLUE,Color.BLACK);//初始化颜色

        //初始化layoutManager
        rcy.setLayoutManager(new LinearLayoutManager(getContext()));
    }

}

//自定义一个设置recycelview中item中的间距的类
class SpaceItemDecoration extends RecyclerView.ItemDecoration{

    private int interval;

    public SpaceItemDecoration(int interval) {
        this.interval = interval;
    }

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        outRect.left = interval;
        outRect.right = interval;
        outRect.bottom = interval;

        if(parent.getChildAdapterPosition(view) == 0){
            outRect.top = interval;
        }
    }
}