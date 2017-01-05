package com.qf.nwt.application.fragment.tendencyFragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.qf.nwt.application.R;
import com.qf.nwt.application.adapter.AdapterOfDreamWorks;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class DreamWorks extends Fragment {


    private View view;
    private RecyclerView rcy;
    private ArrayList<String> list;
    private AdapterOfDreamWorks adapter;

    public DreamWorks() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_dream_works, container, false);

        init();
        return view;
    }

    private void init() {
        initView();
        initAdapter();
        initData();
    }

    private void initAdapter() {
        adapter = new AdapterOfDreamWorks(getContext());
        rcy.setAdapter(adapter);
    }

    private void initData() {
        list = new ArrayList<String>();
        for (int i = 0; i < 20; i++) {
            list.add("============"+i);
        }

        adapter.setList(list);
    }

    private void initView() {
        rcy = ((RecyclerView) view.findViewById(R.id.recycle_DreamWork));
        rcy.setLayoutManager(new LinearLayoutManager(getContext()));
    }

}
