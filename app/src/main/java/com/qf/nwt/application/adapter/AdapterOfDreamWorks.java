package com.qf.nwt.application.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.qf.nwt.application.R;
import com.qf.nwt.application.bean.DreamWorksInfo;

import java.util.List;

/**
 * 趋势--->梦工厂
 * Created by Administrator on 2016/12/29.
 */
public class AdapterOfDreamWorks extends RecyclerView.Adapter<AdapterOfDreamWorks.MyViewHolder> {

    private final Context context;
    private LayoutInflater layoutInflater;
    private List<DreamWorksInfo.SetsBean> list;


    public AdapterOfDreamWorks(Context context) {
        this.layoutInflater = layoutInflater.from(context);
        this.context = context;
    }

    public void setList(List<DreamWorksInfo.SetsBean> list){
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

        DreamWorksInfo.SetsBean info = list.get(position);

        holder.title.setText(info.getTitle());
        holder.desc.setText(info.getDesc());

        Glide.with(context).load(info.getUrl1())
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

    class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView img;
        TextView title;
        TextView desc;

        public MyViewHolder(View itemView) {
            super(itemView);

            img = (ImageView) itemView.findViewById(R.id.img_dreamworks);
            title = (TextView) itemView.findViewById(R.id.title_dreamworks);
            desc = (TextView) itemView.findViewById(R.id.desc_dreamworks);
        }
    }
}
