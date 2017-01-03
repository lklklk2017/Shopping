package com.qf.nwt.application.service;

import com.qf.nwt.application.bean.MatchBean;

import java.util.List;

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

}
