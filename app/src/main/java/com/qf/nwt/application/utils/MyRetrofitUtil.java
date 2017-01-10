package com.qf.nwt.application.utils;

import android.support.v4.widget.SwipeRefreshLayout;
import android.widget.Toast;

import com.qf.nwt.application.activity.Myapplication;
import com.qf.nwt.application.adapter.AdapterOfDiscount;
import com.qf.nwt.application.adapter.AdapterOfDreamWorks;
import com.qf.nwt.application.adapter.AdapterOfInspirRcy;
import com.qf.nwt.application.adapter.AdapterOfSpecial;
import com.qf.nwt.application.adapter.AdpaterOfNewProduct;
import com.qf.nwt.application.bean.DiscountInfo;
import com.qf.nwt.application.bean.DreamWorksInfo;
import com.qf.nwt.application.bean.InspirationInfo;
import com.qf.nwt.application.bean.NewProductInfo;
import com.qf.nwt.application.bean.SpecialInfo;
import com.qf.nwt.application.service.MatchApiService;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observable;
import rx.Observer;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by Administrator on 2017/1/6.
 * 使用观察者模式进行封装请求和返回网络数据
 */

public class MyRetrofitUtil {

    public static String baseurl = "http://api.palshock.cn/";
    static Retrofit retrofit =  new Retrofit.Builder()
            .baseUrl(baseurl)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
            .build();

    //将所有的接口都在该类中获取到
    static MatchApiService apiService = retrofit.create(MatchApiService.class);

    /**
     * 获取折扣的数据并进行返回（仅使用了retrofit,方法一）
     * @param page
     * @param list
     * @param adapter
     * @param swip
     */
    public static void getDiscontData(int page, final List<DiscountInfo.TopicsBean> list, final AdapterOfDiscount adapter, final SwipeRefreshLayout swip){

        Call<DiscountInfo> call = apiService.getMatchData(page);

        call.enqueue(new Callback<DiscountInfo>() {
            @Override
            public void onResponse(Call<DiscountInfo> call, Response<DiscountInfo> response) {
                DiscountInfo body = response.body();
                List<DiscountInfo.TopicsBean> topics = body.getTopics();
                list.addAll(topics);
                adapter.setList(list);
                swip.setRefreshing(false);
                call.cancel();
            }

            @Override
            public void onFailure(Call<DiscountInfo> call, Throwable t) {
                Toast.makeText(Myapplication.getContext(),"获取网络数据失败",Toast.LENGTH_LONG).show();
                call.cancel();
                swip.setRefreshing(false);
            }
        });

    }

    /**
     * 折扣网络数据返回
     * 使用retorifit+rxjava来实现网络数据的返回（方法二）
     */
    public static void getDiscontData1(int page, final List<DiscountInfo.TopicsBean> list, final AdapterOfDiscount adapter, final SwipeRefreshLayout swip) {

        swip.setRefreshing(true);
        Observable<DiscountInfo> discontData1 = apiService.getMatchDiscont(page);
        discontData1.subscribeOn(Schedulers.io())//将后台操作将执行在io线程中执行
                .observeOn(AndroidSchedulers.mainThread())//将后台消费事件处理制定在主线程中去完成
                .subscribe(new Subscriber<DiscountInfo>() {//指定订阅者

                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        Toast.makeText(Myapplication.getContext(),"获取网络数据失败",Toast.LENGTH_LONG).show();
                        swip.setRefreshing(false);
                    }

                    @Override
                    public void onNext(DiscountInfo discountInfo) {
                        //主线程中的处理逻辑在这里执行
                        list.addAll(discountInfo.getTopics());
                        adapter.setList(list);
                        swip.setRefreshing(false);
                    }
                });
    }

    /**
     * 趋势--梦工厂
     */
    public static void getDreamworkData(int page, final List<DreamWorksInfo.SetsBean> list, final AdapterOfDreamWorks adapter, final SwipeRefreshLayout swip){

        swip.setRefreshing(true);
        Observable<DreamWorksInfo> matchDreamWork = apiService.getMatchDreamWork(page);
        matchDreamWork.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<DreamWorksInfo>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        Toast.makeText(Myapplication.getContext(),"获取网络数据失败", Toast.LENGTH_LONG).show();
                        swip.setRefreshing(false);
                    }

                    @Override
                    public void onNext(DreamWorksInfo dreamWorksInfo) {
                        list.addAll(dreamWorksInfo.getSets());
                        adapter.setList(list);
                        swip.setRefreshing(false);
                    }
                });

    }

    /**
     * 趋势--专题
     */
    public static void getSpecialData(int page, final List<SpecialInfo.TopicsBean> list, final AdapterOfSpecial adapter, final SwipeRefreshLayout swip){
        swip.setRefreshing(true);

        Observable<SpecialInfo> matchSpecialData = apiService.getMatchSpecial(page);
        matchSpecialData.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<SpecialInfo>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        Toast.makeText(Myapplication.getContext(),"获取网络数据失败", Toast.LENGTH_LONG).show();
                        swip.setRefreshing(false);
                    }

                    @Override
                    public void onNext(SpecialInfo specialInfo) {
                        list.addAll(specialInfo.getTopics());
                        adapter.setList(list);
                        swip.setRefreshing(false);
                    }
                });
    }

    /**
     * 趋势--灵感
     */
    public static void getInspirData(int page, final List<InspirationInfo.SetsBean> list, final AdapterOfInspirRcy adapter, final SwipeRefreshLayout swip){
        swip.setRefreshing(true);

        Observable<InspirationInfo> matchInspiration = apiService.getMatchInspiration(page);
        matchInspiration.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<InspirationInfo>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        Toast.makeText(Myapplication.getContext(),"获取网络数据失败", Toast.LENGTH_LONG).show();
                        swip.setRefreshing(false);
                    }

                    @Override
                    public void onNext(InspirationInfo inspirationInfo) {
                        list.addAll(inspirationInfo.getSets());
                        adapter.setList(list);
                        swip.setRefreshing(false);
                    }
                });
    }

    /**
     * 趋势-新品详情
     */
    public static void getNewproductData(int page, final List<NewProductInfo.ItemsBean> list, final AdpaterOfNewProduct adapter,final SwipeRefreshLayout swip){
        swip.setRefreshing(true);

        Observable<NewProductInfo> matchNewProduct = apiService.getMatchNewProduct(page);
        matchNewProduct.subscribeOn(Schedulers.io())//事件执行的线程（子线程）
                .observeOn(AndroidSchedulers.mainThread())//结果展示的线程
                .subscribe(new Observer<NewProductInfo>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        Toast.makeText(Myapplication.getContext(),"获取网络数据失败",Toast.LENGTH_LONG).show();
                        swip.setRefreshing(false);
                    }

                    @Override
                    public void onNext(NewProductInfo newProductInfo) {
                        list.addAll(newProductInfo.getItems());
                        adapter.setList(list);
                        swip.setRefreshing(false);
                    }
                });
    }
}
