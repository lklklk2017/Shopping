package com.qf.nwt.application.adapter;

import android.content.Context;
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
 * 趋势--->梦工厂
 * Created by Administrator on 2016/12/29.
 */
public class AdapterOfDreamWorks extends RecyclerView.Adapter<AdapterOfDreamWorks.MyViewHolder> {

    private LayoutInflater layoutInflater;
    private List<String> list;


    public AdapterOfDreamWorks(Context context) {
        this.layoutInflater = layoutInflater.from(context);
    }

    public void setList(List<String> list){
        this.list = list;
        notifyDataSetChanged();
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = layoutInflater.inflate(R.layout.recycleitem_dreamwroks, parent, false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.title.setText(list.get(position));
    }

    @Override
    public int getItemCount() {

        return list.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        RelativeLayout img;
        TextView title;
        TextView desc;

        public MyViewHolder(View itemView) {
            super(itemView);

            img = (RelativeLayout) itemView.findViewById(R.id.img_dreamworks);
            title = (TextView) itemView.findViewById(R.id.title_dreamworks);
            desc = (TextView) itemView.findViewById(R.id.desc_dreamworks);
        }
    }
}
