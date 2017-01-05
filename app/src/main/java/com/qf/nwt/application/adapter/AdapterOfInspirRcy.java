package com.qf.nwt.application.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.support.v4.graphics.drawable.RoundedBitmapDrawable;
import android.support.v4.graphics.drawable.RoundedBitmapDrawableFactory;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.BitmapImageViewTarget;
import com.qf.nwt.application.R;
import com.qf.nwt.application.bean.InspirationInfo;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by Administrator on 2016/12/29.
 */
public class AdapterOfInspirRcy extends RecyclerView.Adapter<AdapterOfInspirRcy.MyViewHolder>{

    private List<InspirationInfo.SetsBean> list;
    private LayoutInflater layoutInflater;
    private Context context;

    public AdapterOfInspirRcy( Context context) {
        this.layoutInflater = layoutInflater.from(context);
        this.context = context;
    }

    public void setList(List<InspirationInfo.SetsBean> list){
        this.list = list;
        notifyDataSetChanged();
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = layoutInflater.inflate(R.layout.recyitem_inspir,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, int position) {

        InspirationInfo.SetsBean setsBean = list.get(position);
        InspirationInfo.SetsBean.ImageBean image = setsBean.getImage();
        //背景图片
        Glide.with(context).load(image.getUrl())
                .placeholder(R.mipmap.ic_launcher)
                .skipMemoryCache(true)
                .into(holder.bg_img);

        holder.bg_img.setScaleType(ImageView.ScaleType.FIT_XY);

        //用户头像地址
        /**
         * 不能直接使用glide给圆形图片加载
         * 不能直接使用圆形图片框架
         * 使用glide对圆形图片的完美加载使用一下方法
         */
        InspirationInfo.SetsBean.PublisherBean publisher = setsBean.getPublisher();
        Glide.with(context)
                .load(publisher.getIcon().getUrl())
                .asBitmap()
                .centerCrop()
                .placeholder(R.mipmap.ic_launcher)
                .into(new BitmapImageViewTarget(holder.user_img){

                    @Override
                    protected void setResource(Bitmap resource) {
                        RoundedBitmapDrawable circularBitmapDrawable =
                                RoundedBitmapDrawableFactory.create(context.getResources(),
                                        resource);
                        circularBitmapDrawable.setCircular(true);
                        holder.user_img.setImageDrawable(circularBitmapDrawable);
                    }
                });


        holder.user_img.setScaleType(ImageView.ScaleType.FIT_XY);


        //姓名
        holder.name.setText(publisher.getName());

        //title
        holder.title.setText(setsBean.getTitle());

        //点赞量
        holder.like.setText(setsBean.getLike()+"");

        //评论量
        holder.comment.setText(setsBean.getComment()+"");
    }

    @Override
    public int getItemCount() {
        if(list!=null && list.size()!=0){
            return list.size();
        }else{
            return -1;
        }
    }

    class MyViewHolder extends RecyclerView.ViewHolder{

        ImageView bg_img;
        ImageView user_img;
        TextView title;
        TextView name;
        TextView like;
        TextView comment;

        public MyViewHolder(View itemView) {
            super(itemView);
            bg_img = (ImageView) itemView.findViewById(R.id.backimg_inspir);
            user_img = (ImageView) itemView.findViewById(R.id.headportrait_inspir);
            name = (TextView) itemView.findViewById(R.id.tv_name_inspir);
            title = (TextView) itemView.findViewById(R.id.title_inspir);
            like = (TextView) itemView.findViewById(R.id.tv_like_inspir);
            comment = (TextView) itemView.findViewById(R.id.tv_commit_inspir);
        }
    }
}
