package com.qf.nwt.application.fragment.tendencyFragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.qf.nwt.application.R;
import com.qf.nwt.application.adapter.AdapterOfDiscount;

import java.util.ArrayList;

/**
 * 趋势--->折扣
 * A simple {@link Fragment} subclass.
 */
public class Discount extends Fragment {


    private View view;
    private RecyclerView rcy;
    private AdapterOfDiscount adapter;
    private ArrayList<String> list;

    public Discount() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_discount, container, false);
        init();

        return view;
    }

    private void init() {
        initView();
        initAdatper();
        initData();
    }

    private void initData() {
        list = new ArrayList<String>();
        for (int i = 0; i < 20; i++) {
            list.add("===="+i);
        }
        adapter.setList(list);
    }

    private void initAdatper() {
        adapter = new AdapterOfDiscount(getContext());
        rcy.setAdapter(adapter);
    }

    private void initView() {
        rcy = ((RecyclerView) view.findViewById(R.id.recycle_Discount));
        rcy.setLayoutManager(new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL));
    }

}
