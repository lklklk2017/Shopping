package com.qf.nwt.application.fragment.themefragements;


import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.qf.nwt.application.R;
import com.qf.nwt.application.activity.Myapplication;

/**
 * A simple {@link Fragment} subclass.
 * 主题详情页面-fragment
 * 用于加载各种不同的fragment页面
 */
public class ThemeContent extends Fragment {


    private View view;
    private RecyclerView rcy;
    private SwipeRefreshLayout swip;

    public ThemeContent() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_theme_content, container, false);
        init();
        
        return view;
    }

    private void init() {
        initView();
        initAdapter();
        initData();
        initListener();
    }

    private void initListener() {

    }

    private void initData() {

    }

    private void initAdapter() {

    }

    private void initView() {
        rcy = ((RecyclerView) view.findViewById(R.id.recycler_Theme));
        swip = ((SwipeRefreshLayout) view.findViewById(R.id.swipe_ThemeContent));

        rcy.setLayoutManager(new LinearLayoutManager(Myapplication.getContext()));
        swip.setColorSchemeColors(Color.BLUE);
    }

}
