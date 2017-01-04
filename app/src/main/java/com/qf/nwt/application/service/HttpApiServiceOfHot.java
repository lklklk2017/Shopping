package com.qf.nwt.application.service;

import com.qf.nwt.application.bean.HotInfo;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by Administrator on 2017/1/3.
 */

public interface HttpApiServiceOfHot {

    @GET("trend/homepage.psj?token=71bd917527a52c55&ua=Android%7C2.6.2&sig=2e22b5acd0791482492677531")
    Call<HotInfo> getData();

}

