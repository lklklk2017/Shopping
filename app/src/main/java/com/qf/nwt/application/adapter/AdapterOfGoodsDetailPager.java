package com.qf.nwt.application.adapter;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.qf.nwt.application.R;
import com.qf.nwt.application.bean.GoodsDetailEntity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/1/9 0009.
 */

public class AdapterOfGoodsDetailPager extends PagerAdapter {
    private Context context;
    private List<GoodsDetailEntity.ImagesBean> imagesBeanList = new ArrayList<>();

    public AdapterOfGoodsDetailPager(Context context) {
        this.context = context;
    }

    public void setImagesBeanList(List<GoodsDetailEntity.ImagesBean> imagesBeanList) {
        this.imagesBeanList = imagesBeanList;
    }

    @Override
    public int getCount() {
        return imagesBeanList.size();
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        ImageView imageView = new ImageView(context);
        Glide.with(context)
                .load(imagesBeanList.get(position).getUrl())
                .placeholder(R.mipmap.ic_launcher)
                .into(imageView);
        imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        container.addView(imageView);
        return imageView;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((ImageView)object);
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }
}
