package com.qf.nwt.application.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.qf.nwt.application.R;
import com.qf.nwt.application.bean.MatchBean;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by fyl on 2016/12/28.
 */

public class MatchPullListAdapter extends BaseAdapter {
    Context context;
    List<MatchBean.CollsBean> matchBeanList=new ArrayList<>();
    LayoutInflater inflater;

    public static final int ITEM_LEFT = 0;//左边标记
    public static final int ITEM_RIGHT = 1;//右边标记

    public MatchPullListAdapter(Context context) {
        this.context = context;
        inflater=LayoutInflater.from(context);
    }
    public void setMatchBeanList(List<MatchBean.CollsBean> matchBeanList) {
        this.matchBeanList = matchBeanList;
    }
    @Override
    public int getCount() {
        return matchBeanList.size();
    }
    @Override
    public Object getItem(int i) {
        return matchBeanList.get(i);
    }
    @Override
    public long getItemId(int i) {
        return i;
    }
   /* @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        MyMatchViewHolder matchViewHolder=null;
        //数据源
        MatchBean.CollsBean collsBean = matchBeanList.get(i);
        List<MatchBean.CollsBean.ItemsBean> itemsBeanList = collsBean.getItems();
        //判断加载哪个布局 单数右边 双数左边
        if (i%2==0){//左边
            if (view==null){
                view=inflater.inflate(R.layout.match_listview_item_left,viewGroup,false);
                matchViewHolder=new MyMatchViewHolder(view,ITEM_LEFT);
            }else {
                matchViewHolder= (MyMatchViewHolder) view.getTag();
            }
            //适配数据 显示
            matchLeftData(matchViewHolder, collsBean, itemsBeanList);
            itemsBeanList.clear();
            notifyDataSetChanged();

        }else {//右边
            if (view==null){
                view=inflater.inflate(R.layout.match_listview_item_right,viewGroup,false);
                matchViewHolder=new MyMatchViewHolder(view,ITEM_RIGHT);
            }else {
                matchViewHolder= (MyMatchViewHolder) view.getTag();
            }
            //适配数据 显示
            matchRightData(matchViewHolder, collsBean, itemsBeanList);
            itemsBeanList.clear();
            notifyDataSetChanged();

        }

        return view;
    }*/
    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        MyMatchViewHolder1 matchViewHolder1=null;
        //数据源
        MatchBean.CollsBean collsBean = matchBeanList.get(i);
        List<MatchBean.CollsBean.ItemsBean> itemsBeanList = collsBean.getItems();
        if (view==null){
            view=inflater.inflate(R.layout.match_listview_item,viewGroup,false);
            matchViewHolder1=new MyMatchViewHolder1(view);
        }else {
            matchViewHolder1= (MyMatchViewHolder1) view.getTag();
        }
        //适配数据
        //文字
        String desc = collsBean.getDesc();
        matchViewHolder1.tv_match.setText("[搭配小贴士]:"+desc);
        //数组大小
        int size = itemsBeanList.size();
        if (size==6){
            if (i%2==0){//左边
                for (int j = 0; j <1 ; j++) {
                    //左边
                    ImageView img=addImageView(matchViewHolder1.layout_left);
                    setImage(itemsBeanList.get(j).getUrl(),img);
                }
                for (int j = 1; j <3 ; j++) {
                    //右边
                    ImageView img=addImageView(matchViewHolder1.layout_right);
                    setImage(itemsBeanList.get(j).getUrl(),img);
                }
                for (int j =3; j <size ; j++) {
                    //底部
                    ImageView img=addImageView(matchViewHolder1.layout_bottom);
                    setImage(itemsBeanList.get(j).getUrl(),img);
                }
                itemsBeanList.clear();

            }else {
                for (int j = 0; j <2 ; j++) {
                    //左边
                    ImageView img=addImageView(matchViewHolder1.layout_left);
                    setImage(itemsBeanList.get(j).getUrl(),img);
                }
                for (int j =2; j <3 ; j++) {
                    //右边
                    ImageView img=addImageView(matchViewHolder1.layout_right);
                    setImage(itemsBeanList.get(j).getUrl(),img);
                }
                for (int j =3; j <size ; j++) {
                    //底部
                    ImageView img=addImageView(matchViewHolder1.layout_bottom);
                    setImage(itemsBeanList.get(j).getUrl(),img);
                }
                itemsBeanList.clear();
            }
                itemsBeanList.clear();

        }else if (size==4){
            for (int j = 0; j <1 ; j++) {
                //左边
                ImageView img=addImageView(matchViewHolder1.layout_left);
                setImage(itemsBeanList.get(j).getUrl(),img);
            }
            for (int j = 1; j <2 ; j++) {
                //右边
                ImageView img=addImageView(matchViewHolder1.layout_right);
                setImage(itemsBeanList.get(j).getUrl(),img);
            }
            for (int j = 2; j <size ; j++) {
                //底部
                ImageView img = addImageView(matchViewHolder1.layout_bottom);
                setImage(itemsBeanList.get(j).getUrl(),img);
            }
                itemsBeanList.clear();

        }
        itemsBeanList.clear();

        return view;
    }

    /**
     * 添加图片
     * @param layout
     * @return
     */
    @NonNull
    private ImageView addImageView(LinearLayout layout) {
        ImageView img=new ImageView(context);
        img.setScaleType(ImageView.ScaleType.FIT_XY);
        //img.setLayoutParams(new LinearLayout.LayoutParams());
        layout.addView(img);
        return img;
    }

    /**
     * 左边布局数据
     * @param matchViewHolder
     * @param collsBean
     * @param itemsBeanList
     */
    private void matchLeftData(MyMatchViewHolder matchViewHolder, MatchBean.CollsBean collsBean, List<MatchBean.CollsBean.ItemsBean> itemsBeanList) {
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
    private void matchRightData(MyMatchViewHolder matchViewHolder, MatchBean.CollsBean collsBean, List<MatchBean.CollsBean.ItemsBean> itemsBeanList) {
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

    static class MyMatchViewHolder{
        TextView tv_match_left,tv_match_right;
        ImageView img_top_left_left,img_top_right_left,img_center_right_left,
                img_bottom_right_left,img_bottom_left_left,img_bottom_center_left;
        ImageView img_top_left_right,img_top_right_right,img_center_left_right,
                img_bottom_right_right,img_bottom_left_right,img_bottom_center_right;
        View itemView;
        public MyMatchViewHolder(View itemView,int type) {
            this.itemView = itemView;
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
            itemView.setTag(this);
        }
    }
    static class MyMatchViewHolder1{
        LinearLayout layout_left;
        LinearLayout layout_right;
        LinearLayout layout_bottom;
        TextView tv_match;
        View itemView;
        public MyMatchViewHolder1(View itemView) {
            this.itemView = itemView;
            layout_left= (LinearLayout) itemView.findViewById(R.id.layout_left);
            layout_right= (LinearLayout) itemView.findViewById(R.id.layout_right);
            layout_bottom= (LinearLayout) itemView.findViewById(R.id.layout_bottom);
            tv_match= (TextView) itemView.findViewById(R.id.tv_match);
            itemView.setTag(this);
        }
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
    }
}
