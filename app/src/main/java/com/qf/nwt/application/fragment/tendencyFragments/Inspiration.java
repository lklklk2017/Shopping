package com.qf.nwt.application.fragment.tendencyFragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import com.qf.nwt.application.R;
import com.qf.nwt.application.adapter.AdapterOfInspirRcy;
import com.qf.nwt.application.bean.Info;

import java.util.ArrayList;

/**
 * 趋势---灵感
 * A simple {@link Fragment} subclass.
 */
public class Inspiration extends Fragment {


    private View view;
    private RecyclerView rcy;
    private ArrayList<Integer> list;
    private AdapterOfInspirRcy adpter;

    public Inspiration() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_inspiration, container, false);
        
        init();
        
        return view;
    }

    private void init() {
        initView();
        initData();
        initAdapter();
    }

    private void initAdapter() {
        Log.i("info","=======initAdapter=======");
        adpter = new AdapterOfInspirRcy(list,getContext());
        rcy.setAdapter(adpter);
    }

    private void initData() {
        list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add(R.mipmap.ic_launcher);
        }
    }

    private void initView() {
        rcy = ((RecyclerView) view.findViewById(R.id.recycle_Inspiration));
        rcy.setLayoutManager(new LinearLayoutManager(getContext()));
    }

}
