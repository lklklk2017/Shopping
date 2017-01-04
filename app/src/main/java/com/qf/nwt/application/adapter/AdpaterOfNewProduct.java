package com.qf.nwt.application.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.qf.nwt.application.R;
import com.qf.nwt.application.bean.NewProductInfo;

import java.util.List;

/**
 * Created by Administrator on 2017/1/4.
 */

public class AdpaterOfNewProduct extends RecyclerView.Adapter<AdpaterOfNewProduct.MyViewHolder>{

    private Context context;
    private LayoutInflater layoutInflater;
    private List<NewProductInfo> list;



    public AdpaterOfNewProduct(Context context) {
        this.layoutInflater = layoutInflater.from(context);
        this.context = context;
    }

    public void setList(List<NewProductInfo> list) {
        this.list = list;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = layoutInflater.inflate(R.layout.recycleitem_newproduct,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 10;
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
