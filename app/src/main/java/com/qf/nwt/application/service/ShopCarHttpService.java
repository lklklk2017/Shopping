package com.qf.nwt.application.service;

import com.qf.nwt.application.bean.GoodsPropertiesEntity;
import com.qf.nwt.application.bean.ShopCarDetailEntity;

import retrofit2.http.GET;
import rx.Observable;

/**
 * Created by Administrator on 2016/12/29 0029.
 */
public interface ShopCarHttpService {
    @GET("buy/cart/cart.psj?token=5c118d640cb0d8a302ac9264d79d4fe6e&ua=Android%7C2.6.2&sig=f21a55ed14bf1482551167318&page=1")
    Observable<ShopCarDetailEntity> getShopCarData();
}
