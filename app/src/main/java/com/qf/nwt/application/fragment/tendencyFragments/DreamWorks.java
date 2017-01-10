package com.qf.nwt.application.fragment.tendencyFragments;


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
import com.qf.nwt.application.adapter.AdapterOfDreamWorks;
import com.qf.nwt.application.bean.DreamWorksInfo;
import com.qf.nwt.application.service.HttpApiServiceOfDreamWorks;
import com.qf.nwt.application.utils.MyRetrofitUtil;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class DreamWorks extends Fragment {


    private View view;
    private RecyclerView rcy;
    private ArrayList<DreamWorksInfo.SetsBean> list;
    private AdapterOfDreamWorks adapter;
    private SwipeRefreshLayout swip;
    private static int page;

    public DreamWorks() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_dream_works, container, false);
        page = 1;//保证每次重新加载的数据都是最新的
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
        swip.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                MyRetrofitUtil.getDreamworkData(page++,list,adapter,swip);
            }
        });

        rcy.addOnScrollListener(new RecyclerView.OnScrollListener() {
            public int last = 0;
            public LinearLayoutManager lm;

            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
                switch (newState){
                    case RecyclerView.SCROLL_STATE_IDLE:
                        if(last==list.size()-1){
                            MyRetrofitUtil.getDreamworkData(page++,list,adapter,swip);
                        }
                        break;
                    default:break;
                }
            }

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                lm = (LinearLayoutManager)recyclerView.getLayoutManager();
                last = lm.findLastCompletelyVisibleItemPosition();
            }
        });
    }

    private void initAdapter() {
        adapter = new AdapterOfDreamWorks(getContext());
        rcy.setAdapter(adapter);
    }

    private void initData() {
        list = new ArrayList<>();
        MyRetrofitUtil.getDreamworkData(page++,list,adapter,swip);
    }


    private void initView() {
        
        rcy = ((RecyclerView) view.findViewById(R.id.recycle_DreamWork));
        swip = ((SwipeRefreshLayout) view.findViewById(R.id.swipe_DreamWorks));


        //初始化rcy
        rcy.setLayoutManager(new LinearLayoutManager(Myapplication.getContext()));
        //初始化swipe
        swip.setColorSchemeColors(Color.RED,Color.BLUE,Color.GREEN);
    }

}
