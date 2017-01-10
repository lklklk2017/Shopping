package com.qf.nwt.application.service;

import com.qf.nwt.application.bean.DreamWorksInfo;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Administrator on 2017/1/5.
 */
public interface HttpApiServiceOfDreamWorks {

    @GET("dw/list.psj?token=71bd917527a52c55&ua=Android%7C2.6.2&sig=3752065a89bc1482493986582")
    Call<DreamWorksInfo> getData(@Query("page") int page);
}
