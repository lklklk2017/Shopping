package com.qf.nwt.application.activity;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.qf.nwt.application.R;
import com.qf.nwt.application.fragment.loginfragments.CodeLoginFragment;
import com.qf.nwt.application.fragment.loginfragments.PwdLoginFragment;

import java.util.HashMap;

import cn.smssdk.EventHandler;
import cn.smssdk.SMSSDK;
import cn.smssdk.gui.RegisterPage;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageView img_back;
    private TextView tv_login;
    private FragmentManager fragmentManager;
    private int i = 0;
    private Button btn_login;
    private String phone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        findViewId();
        firstLoadingLogin();
        initListener();



    }

    /**
     * 打开注册页面
     */
    private void msgRegist() {
        //打开注册页面
        RegisterPage registerPage = new RegisterPage();
        registerPage.setRegisterCallback(new EventHandler() {
            public void afterEvent(int event, int result, Object data) {
// 解析注册结果
                if (result == SMSSDK.RESULT_COMPLETE) {
                    @SuppressWarnings("unchecked")
                    HashMap<String,Object> phoneMap = (HashMap<String, Object>) data;
                    String country = (String) phoneMap.get("country");
                    phone = (String) phoneMap.get("phone");

                }
            }

        });
        registerPage.show(this);
    }

    /**
     * 提交用户信息
     * @param
     * @param phone
     */
    private void registerUser(String phone) {
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        CodeLoginFragment codeLoginFragment = new CodeLoginFragment();
        Bundle bundle = new Bundle();
        bundle.putString("phone",phone);
        codeLoginFragment.setArguments(bundle);
        transaction.replace(R.id.layout_login,new CodeLoginFragment());
        transaction.commit();

    }

    /**
     * 第一次加载登录布局
     */
    private void firstLoadingLogin() {
        fragmentManager = getSupportFragmentManager();
        FragmentTransaction beginTransaction = fragmentManager.beginTransaction();
        beginTransaction.replace(R.id.layout_login,new PwdLoginFragment());
        beginTransaction.commit();
        tv_login.setText("使用验证码登录");
    }

    /**
     * 初始化监听
     */
    private void initListener() {
        img_back.setOnClickListener(this);
        tv_login.setOnClickListener(this);
        btn_login.setOnClickListener(this);
    }

    /**
     * 找id
     */
    private void findViewId() {
        img_back = (ImageView) findViewById(R.id.img_back);
        tv_login = (TextView) findViewById(R.id.tv_login);
        btn_login = (Button) findViewById(R.id.btn_login);
    }

    /**
     * 点击事件
     * @param view
     */
    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.img_back:
                finish();
                break;
            case R.id.tv_login:
                if (i % 2 == 0) {
                    FragmentTransaction beginTransaction = fragmentManager.beginTransaction();
                    beginTransaction.replace(R.id.layout_login,new CodeLoginFragment());
                    beginTransaction.commit();
                    tv_login.setText("使用密码登录");
                    msgRegist();
                   /* // 提交用户信息（此方法可以不调用）
                    registerUser(phone);*/
                    i++;
                }else {
                    FragmentTransaction beginTransaction = fragmentManager.beginTransaction();
                    beginTransaction.replace(R.id.layout_login,new PwdLoginFragment());
                    beginTransaction.commit();
                    tv_login.setText("使用验证码登录");
                    i++;
                }
                break;
            case R.id.btn_login:
                //...登录成功
               /* Intent intent = new Intent(this, Me.class);
                startActivity(intent);*/
                finish();
                break;
        }
    }
}
