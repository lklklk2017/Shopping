package com.qf.nwt.application.service;

import com.qf.nwt.application.bean.SpecialInfo;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Administrator on 2017/1/4.
 */

public interface HttpApiServiceOfSpecial {

    @GET("trend/topic/free_list.psj?token=71bd917527a52c55&ua=Android%7C2.6.2&sig=1be6ac721aa81482493628568")
    Call<SpecialInfo> getData(@Query("page") int page);
}
