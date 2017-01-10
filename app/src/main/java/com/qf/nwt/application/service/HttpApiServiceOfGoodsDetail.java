package com.qf.nwt.application.service;

import com.qf.nwt.application.bean.GoodsDetailEntity;

import retrofit2.http.GET;
import rx.Observable;

/**
 * Created by Administrator on 2017/1/9 0009.
 */

public interface HttpApiServiceOfGoodsDetail {
    @GET("trend/item/detail.psj?token=5c118d640cb0d8a302ac9264d79d4fe6e&ua=Android%7C2.6.2&sig=7936a908baad1483923065593&iid=638549&item_type=item")
    Observable<GoodsDetailEntity> getData();
}
