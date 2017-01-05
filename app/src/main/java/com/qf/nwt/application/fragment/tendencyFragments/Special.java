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
import android.widget.Toast;

import com.qf.nwt.application.R;
import com.qf.nwt.application.adapter.AdapterOfSpecial;
import com.qf.nwt.application.bean.SpecialInfo;
import com.qf.nwt.application.service.HttpApiServiceOfSpecial;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * 趋势--->专题 该布局采用瀑布流
 * A simple {@link Fragment} subclass.
 */
public class Special extends Fragment {

    private String path = "http://api.palshock.cn/";

    private View view;
    private RecyclerView rcy;
    private ArrayList<SpecialInfo.TopicsBean> list;
    private AdapterOfSpecial adater;
    private HttpApiServiceOfSpecial api;
    private static int page;
    private SwipeRefreshLayout swip;

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
        initRetrofit();
        initAdatpter();
        initData();
        initListener();
    }

    private void initListener() {
        swip.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                initNet();
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
                            initNet();
                        }
                        break;

                    case RecyclerView.SCROLL_STATE_SETTLING:
                        if (last == (list.size() - 1)) {
                            initNet();
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

    private void initRetrofit() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(path)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        api = retrofit.create(HttpApiServiceOfSpecial.class);
    }

    private void initAdatpter() {
        adater = new AdapterOfSpecial(getContext());
        rcy.setAdapter(adater);
    }

    private void initData() {
        list = new ArrayList<>();

        initNet();
    }

    private void initNet() {

        swip.setRefreshing(true);
        Call<SpecialInfo> call = api.getData(page++);
        call.enqueue(new Callback<SpecialInfo>() {
            @Override
            public void onResponse(Call<SpecialInfo> call, Response<SpecialInfo> response) {
                SpecialInfo info = response.body();
                List<SpecialInfo.TopicsBean> topics = info.getTopics();
                list.addAll(topics);
                adater.setList(list);
                call.cancel();
                swip.setRefreshing(false);
            }

            @Override
            public void onFailure(Call<SpecialInfo> call, Throwable t) {
                Toast.makeText(getContext(), "请求网络数据失败", Toast.LENGTH_LONG).show();
                call.cancel();
                swip.setRefreshing(false);
            }
        });
    }

    private void initView() {
        rcy = ((RecyclerView) view.findViewById(R.id.recycle_Special));
        swip = (SwipeRefreshLayout) view.findViewById(R.id.swipe_Special);

        //设置layoutManager
        rcy.setLayoutManager(new LinearLayoutManager(getContext()));
        swip.setColorSchemeColors(Color.RED, Color.BLUE, Color.YELLOW);
    }
}
