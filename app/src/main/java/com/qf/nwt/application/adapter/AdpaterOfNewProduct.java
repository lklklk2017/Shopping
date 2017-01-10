package com.qf.nwt.application.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.qf.nwt.application.R;
import com.qf.nwt.application.activity.GoodsDetailActivity;
import com.qf.nwt.application.bean.GoodsDetailEntity;
import com.qf.nwt.application.bean.NewProductInfo;

import java.util.List;

/**
 * Created by Administrator on 2017/1/4.
 */

public class AdpaterOfNewProduct extends RecyclerView.Adapter<AdpaterOfNewProduct.MyViewHolder>{

    private Context context;
    private LayoutInflater layoutInflater;
    private List<NewProductInfo.ItemsBean> list;



    public AdpaterOfNewProduct(Context context) {
        this.layoutInflater = layoutInflater.from(context);
        this.context = context;
    }

    public void setList(List<NewProductInfo.ItemsBean> list) {
        this.list = list;
        notifyDataSetChanged();
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = layoutInflater.inflate(R.layout.recycleitem_newproduct,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        NewProductInfo.ItemsBean itemsBean = list.get(position);

        //图片
        Glide.with(context)
                .load(itemsBean.getImgURL())
                .placeholder(R.mipmap.ic_launcher)
                .skipMemoryCache(true)
                .into(holder.img);
        holder.img.setScaleType(ImageView.ScaleType.FIT_XY);

        //title
        holder.title.setText(itemsBean.getTitle());

        //品牌
        holder.brand.setText(itemsBean.getBrand());

        //价钱
        holder.price.setText("￥"+itemsBean.getMprice());

        holder.img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, GoodsDetailActivity.class);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        if(null!=list&&list.size()!=0){
            return list.size();
        }else{
            return -1;
        }
    }

    class MyViewHolder extends RecyclerView.ViewHolder{
        ImageView img;
        TextView brand;
        TextView title;
        TextView price;

        public MyViewHolder(View itemView) {
            super(itemView);
            img = ((ImageView) itemView.findViewById(R.id.img_newProduct));
            title = ((TextView) itemView.findViewById(R.id.title_newProduct));
            brand = ((TextView) itemView.findViewById(R.id.brand_newProduct));
            price = ((TextView) itemView.findViewById(R.id.price_newProduct));
        }
    }
}
