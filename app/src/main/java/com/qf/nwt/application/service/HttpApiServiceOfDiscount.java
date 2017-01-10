package com.qf.nwt.application.service;

import com.qf.nwt.application.bean.DiscountInfo;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Administrator on 2017/1/5.
 */

public interface HttpApiServiceOfDiscount {

    @GET("trend/sale/sale_list.psj?token=71bd917527a52c55&ua=Android|2.6.2&sig=52778e6166a21482494682966")
    Call<DiscountInfo> getData(@Query("page") int page);

}
