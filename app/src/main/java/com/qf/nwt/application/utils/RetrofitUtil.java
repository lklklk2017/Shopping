package com.qf.nwt.application.utils;

import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.qf.nwt.application.adapter.MatchRecyclerAdapter;
import com.qf.nwt.application.bean.MatchBean;
import com.qf.nwt.application.service.MatchApiService;

import java.util.List;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by fyl on 2017/1/3.
 * 适配pullToRefreshListView数据的帮助类
 */
public class RetrofitUtil {
    private static  String baseUrl="http://api.palshock.cn/";//根地址

    private static  Retrofit retrofit=new Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
            .build();
    private static  MatchApiService httpApiService = retrofit.create(MatchApiService.class);
    /**
     * 所有的数据
     * @param matchRecyclerAdapter
     */
    public static void updateData(final MatchRecyclerAdapter matchRecyclerAdapter, final int page,
                                  final SwipeRefreshLayout swipeRefreshLayout, final List<MatchBean.CollsBean> list) {
        Observable<MatchBean> matchBean = httpApiService.getMatchBeanList(page);
        matchBean.observeOn(AndroidSchedulers.mainThread())//指定 Subscriber 的回调发生在主线程
                .subscribeOn(Schedulers.io())//指定 subscribe() 发生在 IO 线程
                .subscribe(new Subscriber<MatchBean>() {
                    @Override
                    public void onCompleted() {
                        //数据加载完成后刷新图片消失
                        swipeRefreshLayout.setRefreshing(false);
                    }
                    @Override
                    public void onError(Throwable e) {
                    }
                    @Override
                    public void onNext(MatchBean matchBeen1) {
                        Log.e("=======","===updateData检测有没有数据="+matchBeen1.getColls().get(0).getDesc());
                        Log.e("=======","===updateData最外层数组大小="+matchBeen1.getColls().size());
                        list.addAll(matchBeen1.getColls());
                        final int size = matchBeen1.getColls().size();
                        for (int i = 0; i < size; i++) {
                            if (i%2==0){
                                matchBeen1.getColls().get(i).setType(0);
                            }else {
                                matchBeen1.getColls().get(i).setType(1);
                            }
                            matchRecyclerAdapter.setMatchBeanList(list);
                            matchRecyclerAdapter.notifyDataSetChanged();
                        }

                    }
                });

    }

    /**
     * 温度的数据
     * @param matchRecyclerAdapter
     * @param sig
     * @param temp
     */
    public static void updateTemperatureData(final MatchRecyclerAdapter matchRecyclerAdapter,String sig,
                                             int temp,int page,final SwipeRefreshLayout swipeRefreshLayout,
                                             final List<MatchBean.CollsBean> list) {
        Observable<MatchBean> matchBean = httpApiService.getMatchTemperature(page,sig,temp);
        matchBean.observeOn(AndroidSchedulers.mainThread())//指定 Subscriber 的回调发生在主线程
                .subscribeOn(Schedulers.io())//指定 subscribe() 发生在 IO 线程
                .subscribe(new Subscriber<MatchBean>() {
                    @Override
                    public void onCompleted() {
                        //数据加载完成后刷新图片消失
                        swipeRefreshLayout.setRefreshing(false);
                    }
                    @Override
                    public void onError(Throwable e) {
                    }
                    @Override
                    public void onNext(MatchBean matchBeen1) {
                        Log.e("=======","===updateTemperatureData检测有没有数据="+matchBeen1.getColls().get(0).getDesc());
                        Log.e("=======","===updateTemperatureData最外层数组大小="+matchBeen1.getColls().size());
                        list.addAll(matchBeen1.getColls());
                        int size = matchBeen1.getColls().size();
                        for (int i = 0; i < size; i++) {
                            if (i%2==0){
                                matchBeen1.getColls().get(i).setType(0);
                            }else {
                                matchBeen1.getColls().get(i).setType(1);
                            }
                            matchRecyclerAdapter.setMatchBeanList(list);
                            matchRecyclerAdapter.notifyDataSetChanged();
                        }

                    }
                });

    }

    /**
     * 场合的数据
     * @param matchRecyclerAdapter
     * @param sig
     * @param occ
     */
    public static void updateOccasionData(final MatchRecyclerAdapter matchRecyclerAdapter,String sig,
                                          int occ,int page,final SwipeRefreshLayout swipeRefreshLayout,
                                          final List<MatchBean.CollsBean> list) {
        Observable<MatchBean> matchBean = httpApiService.getMatchOccasion(page,sig,occ);
        matchBean.observeOn(AndroidSchedulers.mainThread())//指定 Subscriber 的回调发生在主线程
                .subscribeOn(Schedulers.io())//指定 subscribe() 发生在 IO 线程
                .subscribe(new Subscriber<MatchBean>() {
                    @Override
                    public void onCompleted() {
                        //数据加载完成后刷新图片消失
                        swipeRefreshLayout.setRefreshing(false);
                    }
                    @Override
                    public void onError(Throwable e) {
                    }
                    @Override
                    public void onNext(MatchBean matchBeen1) {
                        Log.e("=======","===updateOccasionData检测有没有数据="+matchBeen1.getColls().get(0).getDesc());
                        Log.e("=======","===updateOccasionData最外层数组大小="+matchBeen1.getColls().size());
                        list.addAll(matchBeen1.getColls());
                        int size = matchBeen1.getColls().size();
                        for (int i = 0; i < size; i++) {
                            if (i%2==0){
                                matchBeen1.getColls().get(i).setType(0);
                            }else {
                                matchBeen1.getColls().get(i).setType(1);
                            }
                            matchRecyclerAdapter.setMatchBeanList(list);
                            matchRecyclerAdapter.notifyDataSetChanged();
                        }

                    }
                });

    }

    /**
     * 颜色的数据
     * @param matchRecyclerAdapter
     * @param sig
     * @param col
     */
    public static void updateColorData(final MatchRecyclerAdapter matchRecyclerAdapter,String sig,
                                       int col,int page,final SwipeRefreshLayout swipeRefreshLayout,
                                       final List<MatchBean.CollsBean> list) {
        Observable<MatchBean> matchBean = httpApiService.getMatchCollor(page,sig,col);
        matchBean.observeOn(AndroidSchedulers.mainThread())//指定 Subscriber 的回调发生在主线程
                .subscribeOn(Schedulers.io())//指定 subscribe() 发生在 IO 线程
                .subscribe(new Subscriber<MatchBean>() {
                    @Override
                    public void onCompleted() {
                        //数据加载完成后刷新图片消失
                        swipeRefreshLayout.setRefreshing(false);
                    }
                    @Override
                    public void onError(Throwable e) {
                    }
                    @Override
                    public void onNext(MatchBean matchBeen1) {
                        Log.e("=======","===updateColorData检测有没有数据="+matchBeen1.getColls().get(0).getDesc());
                        Log.e("=======","===updateColorData最外层数组大小="+matchBeen1.getColls().size());
                        list.addAll(matchBeen1.getColls());
                        int size = matchBeen1.getColls().size();
                        for (int i = 0; i < size; i++) {
                            if (i%2==0){
                                matchBeen1.getColls().get(i).setType(0);
                            }else {
                                matchBeen1.getColls().get(i).setType(1);
                            }
                            matchRecyclerAdapter.setMatchBeanList(list);
                            matchRecyclerAdapter.notifyDataSetChanged();
                        }

                    }
                });

    }

}
