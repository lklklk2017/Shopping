package com.qf.nwt.application.adapter;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.qf.nwt.application.R;

import java.util.List;

/**
 * Created by Administrator on 2016/12/27.
 */

public class AdapterOfHotViewpage extends PagerAdapter {

    private Context context;
    private List<String> list;

    public AdapterOfHotViewpage(Context context,List<String> list) {

        this.context = context;
        this.list = list;
    }

    public void setList(List<String> list) {
        this.list = list;
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        if(null != list){
            return Integer.MAX_VALUE;
        }else{
            return -1;
        }
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view==object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        ImageView img = new ImageView(context);
        Glide.with(context).
                load(list.get(position%list.size()))
                .placeholder(R.mipmap.ic_launcher)//当数据没有时候使用该图标代替
                .into(img);
        img.setScaleType(ImageView.ScaleType.FIT_XY);
        container.addView(img);

        return img;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView(((ImageView) object));
    }
}
