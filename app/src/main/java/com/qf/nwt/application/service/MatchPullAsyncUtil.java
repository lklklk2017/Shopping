package com.qf.nwt.application.service;

import android.os.AsyncTask;

import com.handmark.pulltorefresh.library.PullToRefreshListView;
import com.qf.nwt.application.adapter.MatchPullListAdapter;
import com.qf.nwt.application.utils.RetrofitUtil;

import java.util.List;

/**
 * 异步下载工具类(针对PullToRefreshListView的监听事件的)
 */
public class MatchPullAsyncUtil extends AsyncTask<String,Void,List<String>>{
    private PullToRefreshListView pullToRefreshListView;
    private MatchPullListAdapter matchPullListAdapter;
    private int page;
    public MatchPullAsyncUtil(PullToRefreshListView pullToRefreshListView,
                     MatchPullListAdapter matchPullListAdapter,int page){
        this.pullToRefreshListView=pullToRefreshListView;
        this.matchPullListAdapter=matchPullListAdapter;
        this.page=page;
    }
    private String flag;//区分是上拉还是下拉的标记
    @Override
    protected List<String> doInBackground(String... strings) {
        flag=strings[0];//区分是上拉还是下拉的标记
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return null;
    }
    @Override
    protected void onPostExecute(List<String> strings) {
        super.onPostExecute(strings);
        //通知刷新控件异步请求事件完成
        pullToRefreshListView.onRefreshComplete();
        if ("1".equals(flag)){//说明是下拉刷新
            //RetrofitUtil.updateData(matchPullListAdapter,page);
            matchPullListAdapter.notifyDataSetChanged();
        }else if ("2".equals(flag)){//说明是上拉加载
            //RetrofitUtil.updateData(matchPullListAdapter,page);
            matchPullListAdapter.notifyDataSetChanged();
        }
    }

}
