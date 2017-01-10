package com.qf.nwt.application.service;

import com.qf.nwt.application.bean.DiscountInfo;
import com.qf.nwt.application.bean.DreamWorksInfo;
import com.qf.nwt.application.bean.InspirationInfo;
import com.qf.nwt.application.bean.MatchBean;
import com.qf.nwt.application.bean.NewProductInfo;
import com.qf.nwt.application.bean.SpecialInfo;
import com.qf.nwt.application.fragment.tendencyFragments.Discount;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by fyl on 2016/12/27.
 */

public interface MatchApiService {
    //总接口
    @GET("ic/get_collocation_flow?token=71bd917527a52c55&ua=Android%7C2.6.2&sig=0d4954aa715c1482495268478&{page=1}&temp=255")
    public Observable<MatchBean> getMatchBeanList(
            @Query("page") int page
            );
    //温度
    @GET("ic/get_collocation_flow?token=71bd917527a52c55&ua=Android%7C2.6.2&{sig=1966f6b4cb8e1482495421005}&{page=1}&{temp=30}")
    public Observable<MatchBean> getMatchTemperature(
            @Query("page") int page,
            @Query("sig") String sig,
            @Query("temp") int temp
    );

    //场合
    @GET("ic/get_collocation_flow?token=71bd917527a52c55&ua=Android%7C2.6.2&{sig=2c4016e32b041482495743259}&{page=1}&temp=0&{occ=1}")
    public Observable<MatchBean> getMatchOccasion(
            @Query("page") int page,
            @Query("sig") String sig,
            @Query("occ") int occ
    );

    //颜色
    @GET("ic/get_collocation_flow?token=71bd917527a52c55&ua=Android%7C2.6.2&{sig=246d83bb0eb31482496167967}&{page=1}&temp=0&occ=8&{col=1}")
    public Observable<MatchBean> getMatchCollor(
            @Query("page") int page,
            @Query("sig") String sig,
            @Query("col") int col
    );

    //折扣
    @GET("trend/sale/sale_list.psj?token=71bd917527a52c55&ua=Android|2.6.2&sig=52778e6166a21482494682966")
    Call<DiscountInfo> getMatchData(@Query("page") int page);

    //折扣(方法二)
    @GET("trend/sale/sale_list.psj?token=71bd917527a52c55&ua=Android|2.6.2&sig=52778e6166a21482494682966")
    Observable<DiscountInfo> getMatchDiscont(@Query("page") int page);

    //梦工厂
    @GET("dw/list.psj?token=71bd917527a52c55&ua=Android%7C2.6.2&sig=3752065a89bc1482493986582")
    Observable<DreamWorksInfo> getMatchDreamWork(@Query("page") int page);

    //专题
    @GET("trend/topic/free_list.psj?token=71bd917527a52c55&ua=Android%7C2.6.2&sig=1be6ac721aa81482493628568")
    Observable<SpecialInfo> getMatchSpecial(@Query("page") int page);

    //灵感
    @GET("trend/set/list.psj?token=71bd917527a52c55&ua=Android%7C2.6.2&sig=97dd7bf86def1482493640117")
    Observable<InspirationInfo> getMatchInspiration(@Query("page") int page);

    //新品详情
    @GET("search/search_item.psj?token=5c118d640cb0d8a302ac9264d79d4fe6e&ua=Android%7C2.6.2&sig=9559c2b9e2ba1482550855337&vendor=23%2C8%2C44%2C43%2C16%2C36%2C3%2C31%2C10%2C38%2C30%2C40%2C32")
    Observable<NewProductInfo> getMatchNewProduct(@Query("page") int page);

    //主题详情
    @GET("trend/topic/free_detail.psj?token=5c118d640cb0d8a302ac9264d79d4fe6e&ua=Android%7C2.6.2&sig=ec64d9f980041482545266564")
    Observable<NewProductInfo> getMatchThem(@Query("topicid") int topicid);

}
