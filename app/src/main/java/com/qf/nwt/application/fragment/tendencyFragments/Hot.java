package com.qf.nwt.application.fragment.tendencyFragments;


import android.graphics.Color;
import android.graphics.Rect;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.qf.nwt.application.R;
import com.qf.nwt.application.adapter.AdapterOfHotRecycleView;
import com.qf.nwt.application.bean.HotInfo;
import com.qf.nwt.application.service.HttpApiServiceOfHot;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * A simple {@link Fragment} subclass.
 * 趋势-热门
 * 该页面采用了recycle和SwipeRefreshLayout联用，实现数据的加载和更新
 */
public class Hot extends Fragment {

    private String path = "http://api.palshock.cn/";

    private View view;
    private List<String> list_vp;
    private List<HotInfo.ContentBean> list_info;
    private AdapterOfHotRecycleView adapterOfHotRecycleView;
    private RecyclerView rcy;
    private SwipeRefreshLayout swip;
    private Retrofit retrofit;
    private HttpApiServiceOfHot apiServiceOfHot;
    private Call<HotInfo> call;
    private TabLayout tablayout;

    public Hot() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_hot, container, false);

        init();
        return view;
    }

    private void init() {
        initView();
        initRetrofit();
        initAdapter();
        initListener();
        initData();
    }

    //使用retrofit初始化网络请求
    private void initRetrofit() {

        //创建retrofit的对象
        retrofit = new Retrofit.Builder()
                .baseUrl(path)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        //构建接口的实体类
        apiServiceOfHot = retrofit.create(HttpApiServiceOfHot.class);

        //任务转化
        call = apiServiceOfHot.getData();
    }

    private void initListener() {
        swip.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                initDataAgain();
            }
        });

        rcy.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
            }

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
            }
        });
    }

    private void initAdapter() {
        adapterOfHotRecycleView = new AdapterOfHotRecycleView(getContext());
        rcy.setAdapter(adapterOfHotRecycleView);
    }

    /**
     * 初始化数据
     */
    private void initData() {

        //初始化vp的数据
        list_vp = new ArrayList<>();

        //recycle的数据初始化
        list_info = new ArrayList<>();

        //使用回调取出数据
        call.enqueue(new Callback<HotInfo>() {
            @Override
            public void onResponse(Call<HotInfo> call, Response<HotInfo> response) {
                Log.i("info","网络数据获取成功");
                HotInfo info = response.body();
                list_info = info.getContent();
                for (int i = 0; i < list_info.size(); i++) {

                    HotInfo.ContentBean obj = list_info.get(i);
                    switch (obj.getType()){
                        case 5://viewpager的数据
                            List<HotInfo.ContentBean.EntriesBean> entrieslist = obj.getEntries();
                            for (int j = 0; j < entrieslist.size(); j++) {
                                HotInfo.ContentBean.EntriesBean entriesBean = entrieslist.get(j);
                                Log.i("info","图片地址："+entriesBean.getImgURL());
                                list_vp.add(entriesBean.getImgURL());
                            }
                            Log.i("info","广告条地址加载完毕:list.size() = "+list_vp.size());
                            adapterOfHotRecycleView.setviewpagerList(list_vp);
                            call.cancel();
                            break;
                        default:break;
                    }
                }
                adapterOfHotRecycleView.setItemList(list_info);
                swip.setRefreshing(false);
            }

            @Override
            public void onFailure(Call<HotInfo> call, Throwable t) {
                Toast.makeText(getContext(),"网络数据获取失败",Toast.LENGTH_LONG).show();
                call.cancel();
                swip.setRefreshing(false);
            }
        });
    }

    private void initView() {

        rcy = ((RecyclerView) view.findViewById(R.id.recycle_Hot));
        swip = ((SwipeRefreshLayout) view.findViewById(R.id.swipe_Hot));

        //初始化swip
        swip.setColorSchemeColors(Color.RED,Color.BLUE, Color.BLACK);//初始化颜色
        swip.setRefreshing(true);

        //初始化layoutManager
        rcy.setLayoutManager(new LinearLayoutManager(getContext()));
    }

    public void initDataAgain(){

        final Call<HotInfo> callAgain = apiServiceOfHot.getData();

        //使用回调取出数据
        callAgain.enqueue(new Callback<HotInfo>() {
            @Override
            public void onResponse(Call<HotInfo> call, Response<HotInfo> response) {
                Log.i("info","网络数据获取成功");
                HotInfo info = response.body();
                list_info = info.getContent();
                list_vp.clear();
                for (int i = 0; i < list_info.size(); i++) {

                    HotInfo.ContentBean obj = list_info.get(i);
                    switch (obj.getType()){
                        case 5://viewpager的数据
                            List<HotInfo.ContentBean.EntriesBean> entrieslist = obj.getEntries();
                            for (int j = 0; j < entrieslist.size(); j++) {
                                HotInfo.ContentBean.EntriesBean entriesBean = entrieslist.get(j);
                                Log.i("info","图片地址："+entriesBean.getImgURL());
                                list_vp.add(entriesBean.getImgURL());
                            }
                            Log.i("info","广告条地址加载完毕:list.size() = "+list_vp.size());
                            adapterOfHotRecycleView.setviewpagerList(list_vp);
                            callAgain.cancel();
                            break;
                        default:break;
                    }
                }
                adapterOfHotRecycleView.setItemList(list_info);
                swip.setRefreshing(false);
            }

            @Override
            public void onFailure(Call<HotInfo> call, Throwable t) {
                Toast.makeText(getContext(),"网络数据获取失败",Toast.LENGTH_LONG).show();
                callAgain.cancel();
                swip.setRefreshing(false);
            }
        });
    }
}

//自定义一个设置recycelview中item中的间距的类
class SpaceItemDecoration extends RecyclerView.ItemDecoration{

    private int interval;

    public SpaceItemDecoration(int interval) {
        this.interval = interval;
    }

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        outRect.left = interval;
        outRect.right = interval;
        outRect.bottom = interval;

        if(parent.getChildAdapterPosition(view) == 0){
            outRect.top = interval;
        }
    }
}