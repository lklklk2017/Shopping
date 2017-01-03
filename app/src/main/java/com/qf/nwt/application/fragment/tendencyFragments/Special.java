package com.qf.nwt.application.fragment.tendencyFragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.qf.nwt.application.R;
import com.qf.nwt.application.adapter.AdapterOfSpecial;

import java.util.ArrayList;

/**
 * 趋势--->专题 该布局采用瀑布流
 * A simple {@link Fragment} subclass.
 */
public class Special extends Fragment {


    private View view;
    private RecyclerView rcy;
    private ArrayList<String> list;
    private AdapterOfSpecial adater;

    public Special() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_special, container, false);

        init();

        return view;
    }

    private void init() {
        initView();
        initData();
        initAdatpter();
    }

    private void initAdatpter() {
        adater = new AdapterOfSpecial(getContext(),list);
        rcy.setAdapter(adater);
    }

    private void initData() {
        list = new ArrayList<>();
    }

    private void initView() {
        rcy = ((RecyclerView) view.findViewById(R.id.recycle_Special));

        //设置layoutManager
        rcy.setLayoutManager(new LinearLayoutManager(getContext()));
    }

}
