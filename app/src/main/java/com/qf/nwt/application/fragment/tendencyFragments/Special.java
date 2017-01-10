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
import com.qf.nwt.application.adapter.AdapterOfSpecial;
import com.qf.nwt.application.bean.SpecialInfo;
import com.qf.nwt.application.service.HttpApiServiceOfSpecial;
import com.qf.nwt.application.utils.MyRetrofitUtil;

import java.util.ArrayList;

/**
 * 趋势--->专题 该布局采用瀑布流
 * A simple {@link Fragment} subclass.
 */
public class Special extends Fragment {


    private View view;
    private RecyclerView rcy;
    private ArrayList<SpecialInfo.TopicsBean> list;
    private HttpApiServiceOfSpecial api;
    private static int page;
    private SwipeRefreshLayout swip;
    private AdapterOfSpecial adapter;

    public Special() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_special, container, false);
        page = 1;//利用碎片的生命周期来初始化每次看到的接口是最新的
        init();

        return view;
    }

    private void init() {
        initView();
        initAdatpter();
        initData();
        initListener();
    }

    private void initListener() {
        swip.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                MyRetrofitUtil.getSpecialData(page++,list,adapter,swip);
            }
        });

        rcy.addOnScrollListener(new RecyclerView.OnScrollListener() {
            public LinearLayoutManager lm;
            public int last = 0;

            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
                switch (newState) {

                    case RecyclerView.SCROLL_STATE_DRAGGING:
                        break;

                    case RecyclerView.SCROLL_STATE_IDLE:
                        if (last == (list.size() - 1)) {
                            MyRetrofitUtil.getSpecialData(page++,list,adapter,swip);
                        }
                        break;

                    default:
                        break;
                }
            }

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);

                lm = (LinearLayoutManager) recyclerView.getLayoutManager();
                last = lm.findLastCompletelyVisibleItemPosition();
            }
        });
    }

    private void initAdatpter() {
        adapter = new AdapterOfSpecial(getContext());
        rcy.setAdapter(adapter);
    }

    private void initData() {
        list = new ArrayList<>();
        MyRetrofitUtil.getSpecialData(page++,list,adapter,swip);
    }

    private void initView() {
        rcy = ((RecyclerView) view.findViewById(R.id.recycle_Special));
        swip = (SwipeRefreshLayout) view.findViewById(R.id.swipe_Special);

        //设置layoutManager
        rcy.setLayoutManager(new LinearLayoutManager(Myapplication.getContext()));
        swip.setColorSchemeColors(Color.RED, Color.BLUE, Color.YELLOW);
    }
}
