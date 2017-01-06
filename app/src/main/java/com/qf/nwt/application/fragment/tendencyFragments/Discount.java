package com.qf.nwt.application.fragment.tendencyFragments;


import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.qf.nwt.application.R;
import com.qf.nwt.application.activity.Myapplication;
import com.qf.nwt.application.adapter.AdapterOfDiscount;
import com.qf.nwt.application.bean.DiscountInfo;
import com.qf.nwt.application.service.HttpApiServiceOfDiscount;
import com.qf.nwt.application.utils.MyRetrofitUtil;

import java.io.DataOutputStream;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * 趋势--->折扣
 * A simple {@link Fragment} subclass.
 */
public class Discount extends Fragment {

    private String path = "http://api.palshock.cn/";

    private View view;
    private RecyclerView rcy;
    private AdapterOfDiscount adapter;
    private ArrayList<DiscountInfo.TopicsBean> list;
    private HttpApiServiceOfDiscount apiServiceOfDiscount;
    private static int page;
    private SwipeRefreshLayout swip;

    public Discount() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_discount, container, false);
        page = 1;
        init();
        return view;
    }

    private void init() {
        initView();
        initAdatper();
        initData();
        initListener();
    }

    private void initListener() {

        swip.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                MyRetrofitUtil.getDiscontData1(page++,list,adapter,swip);
            }
        });

        rcy.addOnScrollListener(new RecyclerView.OnScrollListener() {
            public int[] last = new int[2];
            public StaggeredGridLayoutManager mlin;

            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
                switch (newState){
                    case RecyclerView.SCROLL_STATE_IDLE:
                        if(last[1]==list.size()-1){
                            MyRetrofitUtil.getDiscontData1(page++,list,adapter,swip);
                        }
                        break;
                    default:break;
                }
            }

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);

                mlin = (StaggeredGridLayoutManager)recyclerView.getLayoutManager();
                last = mlin.findLastCompletelyVisibleItemPositions(null);
            }
        });
    }

    private void initData() {
        list = new ArrayList<>();
        MyRetrofitUtil.getDiscontData1(page++,list,adapter,swip);
    }

    private void initAdatper() {
        adapter = new AdapterOfDiscount(getContext());
        rcy.setAdapter(adapter);
    }

    private void initView() {
        rcy = ((RecyclerView) view.findViewById(R.id.recycle_Discount));
        swip = ((SwipeRefreshLayout) view.findViewById(R.id.swipe_Discount));

        rcy.setLayoutManager(new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL));
        swip.setColorSchemeColors(Color.RED, Color.GREEN, Color.BLUE);
    }

}
