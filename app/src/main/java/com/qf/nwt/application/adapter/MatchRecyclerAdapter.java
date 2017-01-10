package com.qf.nwt.application.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.qf.nwt.application.R;
import com.qf.nwt.application.bean.MatchBean;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by fyl on 2017/1/6.
 */

public class MatchRecyclerAdapter extends RecyclerView.Adapter<MatchRecyclerAdapter.MyMatchRecyclerViewHolder> {
    public static final int ITEM_LEFT = 0;//左边标记
    public static final int ITEM_RIGHT = 1;//右边标记
    Context context;
    List<MatchBean.CollsBean> matchBeanList=new ArrayList<>();
    LayoutInflater inflater;

    public void setMatchBeanList(List<MatchBean.CollsBean> matchBeanList) {
        this.matchBeanList = matchBeanList;
    }

    public MatchRecyclerAdapter(Context context) {
        this.context = context;
        inflater=LayoutInflater.from(context);
    }

    @Override
    public MyMatchRecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view=null;
        switch (viewType){
            case 0:
                view = inflater.inflate(R.layout.match_listview_item_left, parent, false);
                break;
            case 1:
                view = inflater.inflate(R.layout.match_listview_item_right, parent, false);
                break;
        }
        return new MyMatchRecyclerViewHolder(view,viewType);
    }

    @Override
    public void onBindViewHolder(MyMatchRecyclerViewHolder holder, int position) {
        int type = getItemViewType(position);
        MatchBean.CollsBean collsBean = matchBeanList.get(position);
        List<MatchBean.CollsBean.ItemsBean> itemsBeanList = collsBean.getItems();
        switch (type){
            case ITEM_LEFT:
                matchLeftData(holder,collsBean,itemsBeanList);
                break;
            case ITEM_RIGHT:
                matchRightData(holder,collsBean,itemsBeanList);
                break;
        }
    }

    @Override
    public int getItemCount() {
        return matchBeanList.size();
    }

    @Override
    public int getItemViewType(int position) {
        int type = matchBeanList.get(position).getType();
        switch (type){
            case 0:
                return ITEM_LEFT;
            case 1:
                return ITEM_RIGHT;
        }
        return ITEM_LEFT;
    }

    static class MyMatchRecyclerViewHolder extends RecyclerView.ViewHolder{
        TextView tv_match_left,tv_match_right;
        ImageView img_top_left_left,img_top_right_left,img_center_right_left,
                img_bottom_right_left,img_bottom_left_left,img_bottom_center_left;
        ImageView img_top_left_right,img_top_right_right,img_center_left_right,
                img_bottom_right_right,img_bottom_left_right,img_bottom_center_right;
        int type;

        public MyMatchRecyclerViewHolder(View itemView,int type) {
            super(itemView);
            this.type=type;
            if (type==ITEM_LEFT){//左边
                tv_match_left= (TextView) itemView.findViewById(R.id.tv_match_left);
                img_top_left_left= (ImageView) itemView.findViewById(R.id.img_top_left_left);
                img_top_right_left= (ImageView) itemView.findViewById(R.id.img_top_right_left);
                img_center_right_left= (ImageView) itemView.findViewById(R.id.img_center_right_left);
                img_bottom_right_left= (ImageView) itemView.findViewById(R.id.img_bottom_right_left);
                img_bottom_left_left= (ImageView) itemView.findViewById(R.id.img_bottom_left_left);
                img_bottom_center_left= (ImageView) itemView.findViewById(R.id.img_bottom_center_left);
            }else if (type==ITEM_RIGHT){//右边
                tv_match_right= (TextView) itemView.findViewById(R.id.tv_match_right);
                img_top_left_right= (ImageView) itemView.findViewById(R.id.img_top_left_right);
                img_top_right_right= (ImageView) itemView.findViewById(R.id.img_top_right_right);
                img_center_left_right= (ImageView) itemView.findViewById(R.id.img_center_left_right);
                img_bottom_right_right= (ImageView) itemView.findViewById(R.id.img_bottom_right_right);
                img_bottom_left_right= (ImageView) itemView.findViewById(R.id.img_bottom_left_right);
                img_bottom_center_right= (ImageView) itemView.findViewById(R.id.img_bottom_center_right);
            }
        }
    }

    /**
     * 左边布局数据
     * @param matchViewHolder
     * @param collsBean
     * @param itemsBeanList
     */
    private void matchLeftData(MyMatchRecyclerViewHolder matchViewHolder, MatchBean.CollsBean collsBean, List<MatchBean.CollsBean.ItemsBean> itemsBeanList) {
        //适配数据
        //文字
        /*String desc = collsBean.getDesc();
        matchViewHolder.tv_match_left.setText("[搭配小贴士]:"+desc);
        Log.e("=====","==文字部分==="+desc);*/
        if (itemsBeanList.size()==6){
            //图片地址
            String url = itemsBeanList.get(0).getUrl();//头部
            Log.e("=====","==url==="+url);
            setImage(url,matchViewHolder.img_bottom_left_left);

            String url1 = itemsBeanList.get(1).getUrl();//上身
            Log.e("=====","==url1==="+url1);
            setImage(url1,matchViewHolder.img_top_left_left);


            String url2= itemsBeanList.get(2).getUrl();//下身
            Log.e("=====","==url2==="+url2);
            setImage(url2,matchViewHolder.img_top_right_left);


            String url3 = itemsBeanList.get(3).getUrl();//包包
            Log.e("=====","==url3==="+url3);
            setImage(url3,matchViewHolder.img_center_right_left);


            String url4 = itemsBeanList.get(4).getUrl();//鞋子
            Log.e("=====","==url4==="+url4);
            setImage(url4,matchViewHolder.img_bottom_right_left);


            String url5 = itemsBeanList.get(5).getUrl();//附件
            Log.e("=====","==url5==="+url5);
            setImage(url5,matchViewHolder.img_bottom_center_left);

            itemsBeanList.clear();
        }else if (itemsBeanList.size()==4){
            //图片地址
            String url = itemsBeanList.get(0).getUrl();//头部
            Log.e("=====","==url==="+url);
            setImage(url,matchViewHolder.img_bottom_left_left);

            String url1 = itemsBeanList.get(1).getUrl();//上身
            Log.e("=====","==url1==="+url1);
            setImage(url1,matchViewHolder.img_top_left_left);


            String url2= itemsBeanList.get(2).getUrl();//下身
            Log.e("=====","==url2==="+url2);
            setImage(url2,matchViewHolder.img_top_right_left);


            String url3 = itemsBeanList.get(3).getUrl();//包包
            Log.e("=====","==url3==="+url3);
            setImage(url3,matchViewHolder.img_center_right_left);

            matchViewHolder.img_bottom_right_left.setVisibility(View.GONE);
            matchViewHolder.img_bottom_center_left.setVisibility(View.GONE);

            itemsBeanList.clear();
        }
        //文字
        String desc = collsBean.getDesc();
        matchViewHolder.tv_match_left.setText("[搭配小贴士]:"+desc);
        Log.e("=====","==文字部分==="+desc);
        itemsBeanList.clear();

    }
    /**
     * 右边布局数据
     * @param matchViewHolder
     * @param collsBean
     * @param itemsBeanList
     */
    private void matchRightData(MyMatchRecyclerViewHolder matchViewHolder, MatchBean.CollsBean collsBean, List<MatchBean.CollsBean.ItemsBean> itemsBeanList) {
        //文字
        /*String desc1 = collsBean.getDesc();
        matchViewHolder.tv_match_right.setText("[搭配小贴士]:"+desc1);
        Log.e("=====","==右边文字部分==="+desc1);*/
        if (itemsBeanList.size()==6){
            //图片地址
            String url10 = itemsBeanList.get(0).getUrl();//头部
            Log.e("=====","==url10==="+url10);
            setImage(url10,matchViewHolder.img_bottom_right_right);

            String url11 = itemsBeanList.get(1).getUrl();//上身
            Log.e("=====","==url11==="+url11);
            setImage(url11,matchViewHolder.img_top_right_right);


            String url12= itemsBeanList.get(2).getUrl();//下身
            Log.e("=====","==url12==="+url12);
            setImage(url12,matchViewHolder.img_top_left_right);


            String url13 = itemsBeanList.get(3).getUrl();//包包
            Log.e("=====","==url13==="+url13);
            setImage(url13,matchViewHolder.img_center_left_right);


            String url14 = itemsBeanList.get(4).getUrl();//鞋子
            Log.e("=====","==url14==="+url14);
            setImage(url14,matchViewHolder.img_bottom_left_right);


            String url15 = itemsBeanList.get(5).getUrl();//附件
            Log.e("=====","==url15==="+url15);
            setImage(url15,matchViewHolder.img_bottom_center_right);

            itemsBeanList.clear();

        }else if (itemsBeanList.size()==4){
            //图片地址
            String url10 = itemsBeanList.get(0).getUrl();//头部
            Log.e("=====","==url10==="+url10);
            setImage(url10,matchViewHolder.img_bottom_right_right);

            String url11 = itemsBeanList.get(1).getUrl();//上身
            Log.e("=====","==url11==="+url11);
            setImage(url11,matchViewHolder.img_top_right_right);


            String url12= itemsBeanList.get(2).getUrl();//下身
            Log.e("=====","==url12==="+url12);
            setImage(url12,matchViewHolder.img_top_left_right);


            String url13 = itemsBeanList.get(3).getUrl();//包包
            Log.e("=====","==url13==="+url13);
            setImage(url13,matchViewHolder.img_center_left_right);

            matchViewHolder.img_bottom_left_right.setVisibility(View.GONE);
            matchViewHolder.img_bottom_center_right.setVisibility(View.GONE);

            itemsBeanList.clear();
        }
        //文字
        String desc1 = collsBean.getDesc();
        matchViewHolder.tv_match_right.setText("[搭配小贴士]:"+desc1);
        Log.e("=====","==右边文字部分==="+desc1);
        itemsBeanList.clear();
    }

    /**
     * 加载图片
     * @param url
     * @param img
     */
    private void setImage(String url,ImageView img){
        Glide.with(context)
                .load(url)
                .placeholder(R.mipmap.ic_launcher)
                .skipMemoryCache(true)
                .thumbnail(0.5f)
                .override(400,400)
                .centerCrop()
                .into(img);
        //每一个Item的ImageView的点击事件
        img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Intent intent=new Intent(this,)
            }
        });
    }
}

