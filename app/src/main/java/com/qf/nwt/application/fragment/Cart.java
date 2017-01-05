package com.qf.nwt.application.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import com.qf.nwt.application.R;
import com.qf.nwt.application.adapter.AdapterOfShopCar;
import com.qf.nwt.application.bean.GoodsPropertiesEntity;
import com.qf.nwt.application.bean.ShopCarDetailEntity;
import com.qf.nwt.application.callback.OnItemCheckedListener;
import com.qf.nwt.application.callback.OnNumAscListener;
import com.qf.nwt.application.callback.OnNumDescListener;
import com.qf.nwt.application.service.ShopCarHttpService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * A simple {@link Fragment} subclass.
 *
 */
public class Cart extends Fragment {
    private String host = "http://api.palshock.cn/";
    private View view;
    private RecyclerView recyclerView;
    private SwipeRefreshLayout refreshLayout;
    private AdapterOfShopCar adapterOfShopCar;
    private CheckBox ck_all;
    private TextView tv_allMoney;
    private ShopCarDetailEntity shopCarDetailEntity = new ShopCarDetailEntity();
    private Map<Integer, Boolean> map = new HashMap<>();
    private Map<Integer,Boolean> mapItem = new HashMap<>();
    private ShopCarDetailEntity.CartsBean cartsBean;
    private List<ShopCarDetailEntity.CartsBean> carts;

    public Cart() {
        // Required empty public constructor
    }

    /**
     * //瀑布流的布局管理器
     StaggeredGridLayoutManager manager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);

     recyclerView.setLayoutManager(manager);
     * @param inflater
     * @param container
     * @param savedInstanceState
     * @return
     */

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_cart, container, false);
        findViewId();
        initAdapter();
        initData();
        initListener();
        return view;
    }

    /**
     * 初始化监听
     */
    private void initListener() {

        refreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                initData();
            }
        });

        adapterOfShopCar.setOnItemCheckedListener(new OnItemCheckedListener() {
            @Override
            public void onItemCheckedListener(CheckBox checkBox, int pos) {
                itemChecked(checkBox, pos);
            }
        });
        adapterOfShopCar.setOnNumAscListener(new OnNumAscListener() {
            @Override
            public void onNumAscListener() {
                for (int i = 0; i < cartsBean.getSkus().size(); i++) {
                    int quantity = cartsBean.getSkus().get(i).getQuantity();
                    quantity++;
                    adapterOfShopCar.notifyDataSetChanged();
                    totalMoney();
                }
            }
        });
        adapterOfShopCar.setOnNumDescListener(new OnNumDescListener() {
            @Override
            public void onNumDescListener() {
                for (int i = 0; i < cartsBean.getSkus().size(); i++) {
                    int quantity = cartsBean.getSkus().get(i).getQuantity();
                    if ((quantity - 1) >= 0) {
                        quantity--;
                        adapterOfShopCar.notifyDataSetChanged();
                        totalMoney();
                    }
                }
            }
        });
        ck_all.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                for (int i = 0; i < carts.size(); i++) {
                    map.put(i,ck_all.isChecked());
                }
                //设置点击发生变化刷新
                adapterOfShopCar.setMap(map);
            }
        });
    }

    /**
     * 初始化适配器
     */
    private void initAdapter() {
        //布局管理器
        LinearLayoutManager manager = new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,false);
        recyclerView.setLayoutManager(manager);
        //加载空数据
        adapterOfShopCar = new AdapterOfShopCar(getContext(),ck_all);
        recyclerView.setAdapter(adapterOfShopCar);
    }

    /**
     * 初始化数据
     */
    private void initData() {
        Retrofit retrofit = new Retrofit
                .Builder()
                .baseUrl(host)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
        ShopCarHttpService httpService = retrofit.create(ShopCarHttpService.class);
        final Observable<ShopCarDetailEntity> shopCarData = httpService.getShopCarData();
        shopCarData.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<ShopCarDetailEntity>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(ShopCarDetailEntity shopCarEntity) {

                        //加载有数据
                        for (int i = 0; i <shopCarEntity.getCarts().size() ; i++) {
                            //初始化默认值
                            map.put(i,false);
                            adapterOfShopCar.setMap(map);

                            adapterOfShopCar.setData(shopCarEntity.getCarts());
                            adapterOfShopCar.notifyDataSetChanged();
                            cartsBean = shopCarEntity.getCarts().get(i);
                            carts = shopCarEntity.getCarts();

                        }
                        refreshLayout.setRefreshing(false);

                        /*//设置监听
                        adapterOfShopCar.setOnItemCheckedListener(new OnItemCheckedListener() {
                            @Override
                            public void onItemCheckedListener(CheckBox checkBox, int pos) {
                                itemChecked(checkBox, pos);
                            }
                        });
                        adapterOfShopCar.setOnNumAscListener(new OnNumAscListener() {
                            @Override
                            public void onNumAscListener() {
                                for (int i = 0; i < cartsBean.getSkus().size(); i++) {
                                    int quantity = cartsBean.getSkus().get(i).getQuantity();
                                    quantity++;
                                    adapterOfShopCar.notifyDataSetChanged();
                                    totalMoney();
                                }
                            }
                        });
                        adapterOfShopCar.setOnNumDescListener(new OnNumDescListener() {
                            @Override
                            public void onNumDescListener() {
                                for (int i = 0; i < cartsBean.getSkus().size(); i++) {
                                    int quantity = cartsBean.getSkus().get(i).getQuantity();
                                    if ((quantity - 1) >= 0) {
                                        quantity--;
                                        adapterOfShopCar.notifyDataSetChanged();
                                        totalMoney();
                                    }
                                }
                            }
                        });
                        ck_all.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                for (int i = 0; i < cartsBean.getSkus().size(); i++) {
                                    map.put(i,ck_all.isChecked());
                                }
                                //设置点击发生变化刷新
                                adapterOfShopCar.setMap(map);
                            }
                        });*/

                    }
                });
    }

    /**
     * 找id
     */
    private void findViewId() {
        refreshLayout = (SwipeRefreshLayout) view.findViewById(R.id.shopCarRefreshLayout);
        recyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);
        ck_all = (CheckBox) view.findViewById(R.id.cb_all);
        tv_allMoney = (TextView) view.findViewById(R.id.tv_all_money);
    }

    /**
     * 购物车每项的选择状态
     * @param cb
     * @param pos
     */
    public void itemChecked(CheckBox cb,int pos) {
        int trueCount = 0;
        int trueItemCount = 0;
        if (cb.isChecked()) {
            //选中
            if (cb.getTag() != null && cb.getTag().equals(pos)) {
                map.put(pos,true);
                /*if (cbItem.getTag() != null && cbItem.getTag().equals(pos)) {
                    mapItem.put(pos,true);
                }
                //统计true的个数
                for (int i = 0; i < mapItem.size(); i++) {
                    boolean flag = mapItem.get(i);
                    trueItemCount++;
                }
                if (trueItemCount == adapterOfShopCar.getItemCountDetail(pos)) {
                    cb.setChecked(true);
                }
            }else {
                if (cbItem.getTag() != null && cbItem.getTag().equals(pos)) {
                    mapItem.put(pos,false);
                }
                cb.setChecked(false);*/
            }
            //统计true的个数
            for (int i = 0; i < map.size(); i++) {
                boolean flag = map.get(i);
                trueCount++;
            }
            if (trueCount == adapterOfShopCar.getItemCount()) {
                //表示全选按钮要选中
                ck_all.setChecked(true);
            }
        }else {
            //不选中
            if (cb.getTag() != null && cb.getTag().equals(pos)) {
                map.put(pos,false);
            }
            //全选按钮要取消
            ck_all.setChecked(false);
        }
    }
    public void totalMoney() {
        int totalPrice = 0;
        for (int i = 0; i < cartsBean.getSkus().size(); i++) {
            int totalPrice1 = cartsBean.getSkus().get(i).getTotalPrice();
            totalPrice += totalPrice1;
        }
        tv_allMoney.setText("合计:"+totalPrice+"元");
    }
}
