package com.qf.nwt.application.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.qf.nwt.application.bean.ThemeInfo;

import java.util.List;

/**
 * Created by Administrator on 2017/1/9.
 * 该适配器用于结合主题详情的数据信息
 */

public class ApdapterOfThemConent extends RecyclerView.Adapter<ApdapterOfThemConent.MyViewHolder> {


    private Context context;
    private LayoutInflater inflater;
    private List<ThemeInfo> list;

    private static final int IsHead = 000;
    private static final int IsFoot = 111;


    public void setList(List<ThemeInfo> list) {
        this.list = list;
        notifyDataSetChanged();
    }

    public ApdapterOfThemConent(Context context) {
        this.context = context;
        this.inflater = LayoutInflater.from(context);
    }


    /*************************以下是不同类型的判断依据******************************************/

    /**
     * 判断是否是头部
     */
    private boolean isHead(int position){

        if(position == 0){
            return true;
        }else{
            return false;
        }
    }

    /**
     * 判断是尾部
     */
//    private boolean isFoot(int position){
//        if(){
//
//        }else{
//
//        }
//    }


    /*************************以上不同类型的判断依据******************************************/

    /**
     * 判断不同类型
     */
    @Override
    public int getItemViewType(int position) {
        if(isHead(position)){
            return IsHead;
        }
        return 10;
    }

    /**
     * 根据不同类型的来加载不同的布局
     * @param parent
     * @param viewType
     * @return
     */
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        if(null!=list&&list.size()!=0){
            return list.size()+2;
        }else {
            return -1;
        }
    }

    static class MyViewHolder extends RecyclerView.ViewHolder{

        public MyViewHolder(View itemView, int type) {
            super(itemView);


        }
    }
}
