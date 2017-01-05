package com.qf.nwt.application.service;

import com.qf.nwt.application.bean.InspirationInfo;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Administrator on 2017/1/4.
 */

public interface HttpApiServiceOfInspiration {

    @GET("trend/set/list.psj?token=71bd917527a52c55&ua=Android%7C2.6.2&sig=97dd7bf86def1482493640117")
    Call<InspirationInfo> getData(@Query("page") int page);
}
