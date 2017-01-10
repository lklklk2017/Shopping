package com.qf.nwt.application.activity;

import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;

import com.qf.nwt.application.R;
import com.qf.nwt.application.adapter.AdpaterOfNewProduct;
import com.qf.nwt.application.bean.NewProductInfo;
import com.qf.nwt.application.utils.MyRetrofitUtil;

import java.util.ArrayList;

public class NewProductActivity extends AppCompatActivity {

    private RecyclerView rcy;
    private SwipeRefreshLayout swip;
    private ArrayList<NewProductInfo.ItemsBean> list;
    private AdpaterOfNewProduct adapter;
    private static int page;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_product);

        page = 1;
        init();
    }

    private void init() {

        initview();
        initAdapter();
        initData();
        initListener();
    }

    private void initListener() {
        rcy.addOnScrollListener(new RecyclerView.OnScrollListener() {
            public int[] last;

            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
                if((newState==RecyclerView.SCROLL_STATE_IDLE)&&(last[1] == list.size()-1)){
                    MyRetrofitUtil.getNewproductData(page++,list,adapter,swip);
                }
            }

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                StaggeredGridLayoutManager lm = (StaggeredGridLayoutManager) recyclerView.getLayoutManager();
                last = lm.findLastCompletelyVisibleItemPositions(null);
            }
        });

        swip.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                MyRetrofitUtil.getNewproductData(page++,list,adapter,swip);
            }
        });
    }

    private void initData() {
        list = new ArrayList<>();
        MyRetrofitUtil.getNewproductData(page++,list,adapter,swip);
    }

    private void initAdapter() {
        adapter = new AdpaterOfNewProduct(this);
        rcy.setAdapter(adapter);
    }

    private void initview() {
        rcy = ((RecyclerView) findViewById(R.id.recycle_NewProduct));
        swip = ((SwipeRefreshLayout) findViewById(R.id.swipe_NewProduct));

        //初始化rcy
        rcy.setLayoutManager(new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL));
    }

    public void back(View view) {
        finish();
    }
}
