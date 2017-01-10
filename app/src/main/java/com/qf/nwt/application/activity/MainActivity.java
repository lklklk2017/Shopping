package com.qf.nwt.application.activity;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.qf.nwt.application.R;
import com.qf.nwt.application.fragment.Cart;
import com.qf.nwt.application.fragment.Match;
import com.qf.nwt.application.fragment.Me;
import com.qf.nwt.application.fragment.Show;
import com.qf.nwt.application.fragment.Tendency;

public class MainActivity extends AppCompatActivity {

    private RadioGroup rgp;
    private FragmentManager fragmentManager;
    private RadioButton tendency;
    private long mBackPress = 0;
    private static final int INTERVAL = 2000;//设置间隔时间

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //初始化fragment管理器
        fragmentManager = getSupportFragmentManager();

        //各项初始化
        init();
    }

    //初始化
    private void init() {

        initView();
        initListener();
        tendency.setChecked(true);
    }

    /**
     * 设置rgp的监听：用于初始化不同fragement
     */
    private void initListener() {
        rgp.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(RadioGroup group, int i) {

                switch(i){
                    case R.id.rb_tendency:
                        FragmentTransaction t1 = fragmentManager.beginTransaction();
                        t1.replace(R.id.replaceLayout_main,new Tendency());
                        t1.commit();
                        break;
                    case R.id.rb_match:
                        FragmentTransaction t2 = fragmentManager.beginTransaction();
                        t2.replace(R.id.replaceLayout_main,new Match());
                        t2.commit();
                        break;
                    case R.id.rb_show:
                        FragmentTransaction t3 = fragmentManager.beginTransaction();
                        t3.replace(R.id.replaceLayout_main,new Show());
                        t3.commit();
                        break;
                    case R.id.rb_cart:
                        FragmentTransaction t4 = fragmentManager.beginTransaction();
                        t4.replace(R.id.replaceLayout_main,new Cart());
                        t4.commit();
                        break;
                    case R.id.rb_me:
                        FragmentTransaction t5 = fragmentManager.beginTransaction();
                        t5.replace(R.id.replaceLayout_main,new Me());
                        t5.commit();
                        break;
                }
            }
        });
    }

    private void initView() {
        rgp = ((RadioGroup) findViewById(R.id.rgp_main));
        tendency = ((RadioButton) findViewById(R.id.rb_tendency));
    }

    /**
     * 程序防止误操作导致退出
     */
    @Override
    public void onBackPressed() {
        if (mBackPress+INTERVAL>System.currentTimeMillis()){

            super.onBackPressed();
            return;

        }else{//第一次点击返回键，提示消息

            Toast.makeText(MainActivity.this,"再按一次退出程序哦~",Toast.LENGTH_LONG).show();
            mBackPress = System.currentTimeMillis();
        }
    }
}
