package com.qf.nwt.application.fragment;


import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.qf.nwt.application.R;
import com.qf.nwt.application.adapter.AdapterOfTendency;
import com.qf.nwt.application.fragment.tendencyFragments.Discount;
import com.qf.nwt.application.fragment.tendencyFragments.DreamWorks;
import com.qf.nwt.application.fragment.tendencyFragments.Hot;
import com.qf.nwt.application.fragment.tendencyFragments.Inspiration;
import com.qf.nwt.application.fragment.tendencyFragments.Special;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class Tendency extends Fragment {


    private View view;
    private TabLayout tablayout;
    private ViewPager vp;
    private String[] titles;
    private List<Fragment> fragments_list;
    private AdapterOfTendency adapterOfTendency;

    public Tendency() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        //构造出Tendency的布局
        view = inflater.inflate(R.layout.fragment_tendency, container, false);

        init();
        return view;
    }

    private void init() {
        initView();
        initConnect();
        initData();
        initAdapter();
    }

    private void initConnect() {//已经设置相关联动
        tablayout.setupWithViewPager(vp);
    }

    /**
     * 初始化title和list
     */
    private void initData() {

        titles = new String[]{"热门","灵感","专题","梦工厂","折扣"};

        fragments_list = new ArrayList<>();
        fragments_list.add(new Hot());
        fragments_list.add(new Inspiration());
        fragments_list.add(new Special());
        fragments_list.add(new DreamWorks());
        fragments_list.add(new Discount());
    }

    private void initAdapter() {
        adapterOfTendency = new AdapterOfTendency(getChildFragmentManager(),fragments_list,titles);
        vp.setAdapter(adapterOfTendency);
    }

    private void initView() {
        tablayout = ((TabLayout) view.findViewById(R.id.tablayout_Tendency));
        vp = ((ViewPager) view.findViewById(R.id.vp_Tendency));
    }

}
