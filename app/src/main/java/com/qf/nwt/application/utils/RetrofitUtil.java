package com.qf.nwt.application.utils;

import android.util.Log;

import com.qf.nwt.application.adapter.MatchPullListAdapter;
import com.qf.nwt.application.bean.MatchBean;
import com.qf.nwt.application.service.MatchApiService;

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
    //private static int page=1;//页数

    //private MatchPullListAdapter pullListAdapter;//PullToRefreshListView控件适配器

    /**
     * 所有的数据
     * @param pullListAdapter
     */
    public static void updateData(final MatchPullListAdapter pullListAdapter,int page) {
        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
        MatchApiService httpApiService = retrofit.create(MatchApiService.class);
        Observable<MatchBean> matchBean = httpApiService.getMatchBeanList(page);
        matchBean.observeOn(AndroidSchedulers.mainThread())//指定 Subscriber 的回调发生在主线程
                .subscribeOn(Schedulers.io())//指定 subscribe() 发生在 IO 线程
                .subscribe(new Subscriber<MatchBean>() {
                    @Override
                    public void onCompleted() {
                    }
                    @Override
                    public void onError(Throwable e) {
                    }
                    @Override
                    public void onNext(MatchBean matchBeen1) {
                        Log.e("=======","===检测有没有数据="+matchBeen1.getColls().get(0).getDesc());
                        Log.e("=======","===最外层数组大小="+matchBeen1.getColls().size());
                        int size = matchBeen1.getColls().size();
                        for (int i = 0; i < size-2; i++) {
                            pullListAdapter.setMatchBeanList(matchBeen1.getColls());
                            pullListAdapter.notifyDataSetChanged();
                        }

                    }
                });

    }

    /**
     * 温度的数据
     * @param pullListAdapter
     * @param sig
     * @param temp
     */
    public static void updateTemperatureData(final MatchPullListAdapter pullListAdapter,String sig,int temp,int page) {
        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
        MatchApiService httpApiService = retrofit.create(MatchApiService.class);
        Observable<MatchBean> matchBean = httpApiService.getMatchTemperature(page,sig,temp);
        matchBean.observeOn(AndroidSchedulers.mainThread())//指定 Subscriber 的回调发生在主线程
                .subscribeOn(Schedulers.io())//指定 subscribe() 发生在 IO 线程
                .subscribe(new Subscriber<MatchBean>() {
                    @Override
                    public void onCompleted() {
                    }
                    @Override
                    public void onError(Throwable e) {
                    }
                    @Override
                    public void onNext(MatchBean matchBeen1) {
                        Log.e("=======","===检测有没有数据="+matchBeen1.getColls().get(0).getDesc());
                        Log.e("=======","===最外层数组大小="+matchBeen1.getColls().size());
                        int size = matchBeen1.getColls().size();
                        for (int i = 0; i < size-2; i++) {
                            pullListAdapter.setMatchBeanList(matchBeen1.getColls());
                            pullListAdapter.notifyDataSetChanged();
                        }

                    }
                });

    }

    /**
     * 场合的数据
     * @param pullListAdapter
     * @param sig
     * @param occ
     */
    public static void updateOccasionData(final MatchPullListAdapter pullListAdapter,String sig,int occ,int page) {
        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
        MatchApiService httpApiService = retrofit.create(MatchApiService.class);
        Observable<MatchBean> matchBean = httpApiService.getMatchOccasion(page,sig,occ);
        matchBean.observeOn(AndroidSchedulers.mainThread())//指定 Subscriber 的回调发生在主线程
                .subscribeOn(Schedulers.io())//指定 subscribe() 发生在 IO 线程
                .subscribe(new Subscriber<MatchBean>() {
                    @Override
                    public void onCompleted() {
                    }
                    @Override
                    public void onError(Throwable e) {
                    }
                    @Override
                    public void onNext(MatchBean matchBeen1) {
                        Log.e("=======","===检测有没有数据="+matchBeen1.getColls().get(0).getDesc());
                        Log.e("=======","===最外层数组大小="+matchBeen1.getColls().size());
                        int size = matchBeen1.getColls().size();
                        for (int i = 0; i < size-2; i++) {
                            pullListAdapter.setMatchBeanList(matchBeen1.getColls());
                            pullListAdapter.notifyDataSetChanged();
                        }

                    }
                });

    }

    /**
     * 颜色的数据
     * @param pullListAdapter
     * @param sig
     * @param col
     */
    public static void updateColorData(final MatchPullListAdapter pullListAdapter,String sig,int col,int page) {
        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
        MatchApiService httpApiService = retrofit.create(MatchApiService.class);
        Observable<MatchBean> matchBean = httpApiService.getMatchCollor(page,sig,col);
        matchBean.observeOn(AndroidSchedulers.mainThread())//指定 Subscriber 的回调发生在主线程
                .subscribeOn(Schedulers.io())//指定 subscribe() 发生在 IO 线程
                .subscribe(new Subscriber<MatchBean>() {
                    @Override
                    public void onCompleted() {
                    }
                    @Override
                    public void onError(Throwable e) {
                    }
                    @Override
                    public void onNext(MatchBean matchBeen1) {
                        Log.e("=======","===检测有没有数据="+matchBeen1.getColls().get(0).getDesc());
                        Log.e("=======","===最外层数组大小="+matchBeen1.getColls().size());
                        int size = matchBeen1.getColls().size();
                        for (int i = 0; i < size-2; i++) {
                            pullListAdapter.setMatchBeanList(matchBeen1.getColls());
                            pullListAdapter.notifyDataSetChanged();
                        }

                    }
                });

    }

}
