package com.qf.nwt.application.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.qf.nwt.application.R;

import java.util.List;

/**
 * Created by Administrator on 2016/12/30.
 */
public class AdapterOfDiscount extends RecyclerView.Adapter<AdapterOfDiscount.MyViewholder>{

    private LayoutInflater inflater;
    private List<String> list;

    public void setList(List<String> list) {
        this.list = list;
        notifyDataSetChanged();
    }

    public AdapterOfDiscount(Context context) {
        this.inflater = LayoutInflater.from(context);
    }

    @Override
    public MyViewholder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.recycleitem_discount,parent,false);
        return new MyViewholder(view);
    }

    @Override
    public void onBindViewHolder(MyViewholder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class MyViewholder extends RecyclerView.ViewHolder{

        RelativeLayout img;
        TextView title;
        TextView time;

        public MyViewholder(View itemView) {
            super(itemView);
            img = (RelativeLayout) itemView.findViewById(R.id.img_discount);
            title = (TextView) itemView.findViewById(R.id.title_discount);
            time = (TextView) itemView.findViewById(R.id.title_discount);
        }
    }

}
