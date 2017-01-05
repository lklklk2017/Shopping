package com.qf.nwt.application.service;

import com.qf.nwt.application.bean.LoginEntity;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by Administrator on 2017/1/3 0003.
 */

public interface LoginHttpService {
    /*
    ptoken=0
    &ua=Android%7C2.6.2
    &sig=ae22636563bb1483430575691
    &lang=zh
    &password=e10adc3949ba59abbe56e057f20f883e
    &mobile=18408249795
    &from=5
    &did=71bd917527a52c55

    */
    @GET("me/login.php?ptoken=0&ua=Android%7C2.6.2&sig=ae22636563bb1483430575691&lang=zh&{password=e10adc3949ba59abbe56e057f20f883e}&{mobile=18408249795}&from=5&did=71bd917527a52c55")
    Observable<LoginEntity> getData(
            @Query("password") String password,
            @Query("mobile") String mobile
    );
}
