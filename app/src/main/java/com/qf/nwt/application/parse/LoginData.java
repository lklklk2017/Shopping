package com.qf.nwt.application.parse;

import android.content.Context;
import android.widget.Toast;

import com.qf.nwt.application.activity.LoginActivity;
import com.qf.nwt.application.bean.LoginEntity;
import com.qf.nwt.application.service.LoginHttpService;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by Administrator on 2017/1/3 0003.
 */

public class LoginData {
    private String password;
    private String mobile;
    private Context context;
    private LoginActivity loginActivity;

    public LoginData(Context context) {
        this.context = context;
    }

    public LoginData(LoginActivity loginActivity) {
        this.loginActivity = loginActivity;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    /**
     * 初始化数据
     */
    public void initData() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://api.palshock.cn/")
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        LoginHttpService loginHttpService = retrofit.create(LoginHttpService.class);
        Observable<LoginEntity> data = loginHttpService.getData(password,mobile);
        data.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<LoginEntity>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(LoginEntity loginEntity) {
                        int psj = loginEntity.getPsj();
                        if (psj == 0) {
                            Toast.makeText(loginActivity,"登录成功!!!",Toast.LENGTH_SHORT).show();
                            loginActivity.finish();
                        }
                        if (psj == 106) {
                            Toast.makeText(loginActivity,"手机号未注册!!!",Toast.LENGTH_SHORT).show();
                        }
                        if (psj == 111) {
                            Toast.makeText(loginActivity,"密码错误!!!",Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }
}
