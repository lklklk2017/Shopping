package com.qf.nwt.application.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.qf.nwt.application.R;
import com.qf.nwt.application.fragment.tendencyFragments.Special;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;

/**
 * Created by Administrator on 2016/12/29.
 */
public class AdapterOfSpecial extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private static final int RIGHT = 1;
    private static final int LEFT = 2;

    private LayoutInflater layoutInflater;
    private List<String> list;

    public AdapterOfSpecial(Context context, List<String> list) {
        this.layoutInflater = layoutInflater.from(context);
        this.list = list;
    }

    @Override
    public int getItemViewType(int position) {
        int n = position%2;

        if(0 == n){
            return LEFT;
        }else{
            return RIGHT;
        }
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = null;
        switch (viewType) {
            case RIGHT:
                view = layoutInflater.inflate(R.layout.recycleitem_spcialright, parent, false);
                return new RightViewHolder(view);

            case LEFT:
                view = layoutInflater.inflate(R.layout.recycleitem_spcialleft, parent, false);
                return new LeftViewHolder(view);
        }
        return null;
    }


    /**
     * 绑定数值（根据类型的不同）
     * @param holder
     * @param position
     */
    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        int n = position%2;

        if(0==n){
            LeftViewHolder leftholder = (LeftViewHolder) holder;
            leftholder.title.setText("这是左布局");
            leftholder.desc.setText("左布局");
//            leftholder.img.setImageResource(R.drawable.uncheck);
        }else {
            RightViewHolder rightholder = (RightViewHolder) holder;
            rightholder.title.setText("这是右布局");
            rightholder.desc.setText("右布局");
//            rightholder.img.setImageResource(R.drawable.checked);
        }

    }

    @Override
    public int getItemCount() {
        return 10;
    }

    /**
     * 右布局的viewholder
     */
    class RightViewHolder extends RecyclerView.ViewHolder {

        ImageView img;
        TextView title;
        TextView desc;

        public RightViewHolder(View itemView) {
            super(itemView);
            img = (ImageView) itemView.findViewById(R.id.img_specialright);
            title = (TextView) itemView.findViewById(R.id.tv_title_specialright);
            desc = (TextView) itemView.findViewById(R.id.tv_desc_specialright);
        }
    }

    /**
     * 左布局的viewholder
     */
    class LeftViewHolder extends RecyclerView.ViewHolder {

        ImageView img;
        TextView title;
        TextView desc;

        public LeftViewHolder(View itemView) {
            super(itemView);
            img = (ImageView) itemView.findViewById(R.id.img_specialleft);
            title = (TextView) itemView.findViewById(R.id.tv_title_specialleft);
            desc = (TextView) itemView.findViewById(R.id.tv_desc_specialleft);
        }
    }
}
