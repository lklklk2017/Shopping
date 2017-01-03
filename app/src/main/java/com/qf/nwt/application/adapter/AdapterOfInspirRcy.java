package com.qf.nwt.application.adapter;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.qf.nwt.application.R;

import java.util.List;

/**
 * Created by Administrator on 2016/12/29.
 */
public class AdapterOfInspirRcy extends RecyclerView.Adapter<AdapterOfInspirRcy.MyViewHolder>{

    private List<Integer> list;
    private LayoutInflater layoutInflater;

    public AdapterOfInspirRcy(List<Integer> list, Context context) {
        this.list = list;
        this.layoutInflater = layoutInflater.from(context);
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = layoutInflater.inflate(R.layout.recyitem_inspir,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder{

        RelativeLayout bg_img;
        TextView title;

        public MyViewHolder(View itemView) {
            super(itemView);
            bg_img = (RelativeLayout) itemView.findViewById(R.id.backimg_inspir);
            title = (TextView) itemView.findViewById(R.id.title_inspir);
        }
    }
}
