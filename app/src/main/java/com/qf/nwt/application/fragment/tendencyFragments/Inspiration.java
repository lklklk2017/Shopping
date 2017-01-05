package com.qf.nwt.application.fragment.tendencyFragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.qf.nwt.application.R;
import com.qf.nwt.application.adapter.AdapterOfInspirRcy;
import com.qf.nwt.application.bean.InspirationInfo;
import com.qf.nwt.application.service.HttpApiServiceOfInspiration;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * 趋势---灵感
 * A simple {@link Fragment} subclass.
 */
public class Inspiration extends Fragment {

    private String baseUrl = "http://api.palshock.cn/";

    private View view;
    private RecyclerView rcy;
    private ArrayList<InspirationInfo.SetsBean> list;
    private AdapterOfInspirRcy adapter;
    private SwipeRefreshLayout swipe;
    private HttpApiServiceOfInspiration api;
    private static int page;

    public Inspiration() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_inspiration, container, false);
        page = 1;//利用碎片的生命周期来初始化每次看到的接口是最新的
        init();
        
        return view;
    }

    private void init() {
        initView();
        initRetrofit();
        initAdapter();
        initData();
        initListetner();
    }

    private void initListetner() {

        //刷新框架
        swipe.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                initNet();
            }
        });

        //recycle的监听事件
        rcy.addOnScrollListener(new RecyclerView.OnScrollListener() {
            private int last = 0;

            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
                switch (newState){

                    //当rcy被拖拽时候的状态
                    case RecyclerView.SCROLL_STATE_DRAGGING:

                        break;

                    //当rcy停止时候的状态
                    case RecyclerView.SCROLL_STATE_IDLE:
                        if(last==list.size()-1){
                            initNet();
                        }
                        break;

                    //当rcy惯性滚动时候的状态
                    case RecyclerView.SCROLL_STATE_SETTLING:
                        if(last==list.size()-1){
                            initNet();
                        }
                        break;
                    default:break;
                }
            }

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);

                LinearLayoutManager lm = (LinearLayoutManager)recyclerView.getLayoutManager();

                //获取当前可看见的加载完整的最后一位item的位置
                last = lm.findLastCompletelyVisibleItemPosition();
            }
        });
    }

    private void initRetrofit() {

        //初始化retrofit
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        api = retrofit.create(HttpApiServiceOfInspiration.class);
    }

    private void initAdapter() {
        adapter = new AdapterOfInspirRcy(getContext());
        rcy.setAdapter(adapter);
    }

    private void initData() {
        list = new ArrayList<>();

        //开始调用下载网络的方法
        initNet();
    }

    private void initNet() {

        //每次加载数据之前都会开始转圈
        swipe.setRefreshing(true);
        Call<InspirationInfo> call = api.getData(page++);
        call.enqueue(new Callback<InspirationInfo>() {
            @Override
            public void onResponse(Call<InspirationInfo> call, Response<InspirationInfo> response) {
                InspirationInfo info = response.body();
                List<InspirationInfo.SetsBean> sets = info.getSets();
                if(sets!=null&&sets.size()!=0){

                    list.addAll(sets);
                }
                adapter.setList(list);
                call.cancel();
                swipe.setRefreshing(false);
            }

            @Override
            public void onFailure(Call<InspirationInfo> call, Throwable t) {
                Toast.makeText(getContext(),"请求网络数据失败", Toast.LENGTH_LONG).show();
                call.cancel();
                swipe.setRefreshing(false);
            }
        });
    }

    private void initView() {
        rcy = ((RecyclerView) view.findViewById(R.id.recycle_Inspiration));
        swipe = ((SwipeRefreshLayout) view.findViewById(R.id.swipe_Inspiration));

        //初始化rcy
        rcy.setLayoutManager(new LinearLayoutManager(getContext()));

        //初始化swip
        swipe.setRefreshing(true);
    }

}
