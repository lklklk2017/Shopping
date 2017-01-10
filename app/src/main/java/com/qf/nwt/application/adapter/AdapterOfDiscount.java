package com.qf.nwt.application.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.qf.nwt.application.R;
import com.qf.nwt.application.bean.DiscountInfo;

import java.util.List;

/**
 * Created by Administrator on 2016/12/30.
 */
public class AdapterOfDiscount extends RecyclerView.Adapter<AdapterOfDiscount.MyViewholder>{

    private LayoutInflater inflater;
    private List<DiscountInfo.TopicsBean> list;
    private Context context;

    public void setList(List<DiscountInfo.TopicsBean> list) {
        this.list = list;
        notifyDataSetChanged();
    }

    public AdapterOfDiscount(Context context) {
        this.inflater = LayoutInflater.from(context);
        this.context = context;
    }

    @Override
    public MyViewholder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.recycleitem_discount,parent,false);
        return new MyViewholder(view);
    }

    @Override
    public void onBindViewHolder(MyViewholder holder, int position) {
        DiscountInfo.TopicsBean topicsBean = list.get(position);
        holder.title.setText(topicsBean.getTitle());
        holder.time.setText(topicsBean.getDesc());
        Glide.with(context)
                .load(topicsBean.getImg())
                .skipMemoryCache(true)
                .placeholder(R.mipmap.ic_launcher)
                .into(holder.img);

        holder.img.setScaleType(ImageView.ScaleType.FIT_XY);
    }

    @Override
    public int getItemCount() {
        if(null!=list&&list.size()!=0){
            return list.size();
        }else{
            return -1;
        }
    }

    class MyViewholder extends RecyclerView.ViewHolder{

        ImageView img;
        TextView title;
        TextView time;

        public MyViewholder(View itemView) {
            super(itemView);
            img = (ImageView) itemView.findViewById(R.id.img_discount);
            title = (TextView) itemView.findViewById(R.id.title_discount);
            time = (TextView) itemView.findViewById(R.id.desc_discount);
        }
    }

}
