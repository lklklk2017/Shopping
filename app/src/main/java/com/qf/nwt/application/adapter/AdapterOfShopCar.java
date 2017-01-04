package com.qf.nwt.application.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.qf.nwt.application.R;
import com.qf.nwt.application.bean.GoodsPropertiesEntity;
import com.qf.nwt.application.bean.ShopCarDetailEntity;
import com.qf.nwt.application.callback.OnItemCheckedListener;
import com.qf.nwt.application.callback.OnNumAscListener;
import com.qf.nwt.application.callback.OnNumDescListener;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2016/12/29 0029.
 */

public class AdapterOfShopCar extends RecyclerView.Adapter<AdapterOfShopCar.MyViewHodler>{
    private List<ShopCarDetailEntity.CartsBean> data = new ArrayList<>();
    private Context context;
    private LayoutInflater inflater;
    private Map<Integer,Boolean> map;
    private CheckBox ck_all;
    OnItemCheckedListener onItemCheckedListener;
    OnNumAscListener onNumAscListener;
    OnNumDescListener onNumDescListener;
    private int totalPrice;

    public int getTotalPrice() {
        return totalPrice;
    }

    public void setOnItemCheckedListener(OnItemCheckedListener onItemCheckedListener) {
        this.onItemCheckedListener = onItemCheckedListener;
    }

    public void setOnNumAscListener(OnNumAscListener onNumAscListener) {
        this.onNumAscListener = onNumAscListener;
    }

    public void setOnNumDescListener(OnNumDescListener onNumDescListener) {
        this.onNumDescListener = onNumDescListener;
    }

    public void setMap(Map<Integer, Boolean> map) {
        this.map = map;
        notifyDataSetChanged();
    }

    public Map<Integer, Boolean> getMap() {
        return map;
    }

    public AdapterOfShopCar(Context context,CheckBox ck_all) {
        this.context = context;
        this.ck_all = ck_all;
        inflater = LayoutInflater.from(context);
    }

    public void setData(List<ShopCarDetailEntity.CartsBean> data) {
        this.data = data;
        notifyDataSetChanged();
    }

    @Override
    public MyViewHodler onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.shopcar_item, parent, false);
        return new MyViewHodler(view);
    }

    @Override
    public void onBindViewHolder(final MyViewHodler holder, final int position) {
        data.get(position).getSkus().size();
        final ShopCarDetailEntity.CartsBean cartsBean = data.get(position);
        //LOGO地址
        String logo_url = cartsBean.getLogo();
        //品牌名
        String vendorName = cartsBean.getVendorName();
        List<ShopCarDetailEntity.CartsBean.SkusBean> skusBeen = cartsBean.getSkus();
        //商品数量
        int quantity = skusBeen.get(position).getQuantity();
        //商品价格
        int sprice = skusBeen.get(position).getSprice();
        //商品颜色
        String color = skusBeen.get(position).getColor().getText();
        //商品尺码
        String size = skusBeen.get(position).getSize().getText();
        //商品图片地址
        String url = cartsBean.getSkus().get(position).getUrl();
        //商品名
        String name = cartsBean.getSkus().get(position).getTitle();
        //总价格
        totalPrice = skusBeen.get(position).getTotalPrice();



        //同一品牌下的全选
        holder.checkBoxAll.setTag(position);
        holder.checkBoxAll.setChecked(map.get(position));
        holder.checkBoxAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (onItemCheckedListener != null) {
                    onItemCheckedListener.onItemCheckedListener(holder.checkBoxAll,position);
                }
            }
        });
        /*//单件商品是否选中
        holder.checkBox.setTag(position);
        holder.checkBox.setChecked(map.get(position));
        holder.checkBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (onItemCheckedListener != null) {
                    onItemCheckedListener.onItemCheckedListener(holder.checkBox,position);
                }
            }
        });*/
        if (holder.checkBox.isChecked()) {
            int trueCount = 0;
            //选中
            if (holder.checkBox.getTag() != null && holder.checkBox.getTag().equals(position)) {
                map.put(position,true);
            }
            //统计true的个数
            for (int i = 0; i < map.size(); i++) {
                trueCount++;
            }
            //判断trueCount和具体的个数
            if (trueCount == getItemCountDetail(position)) {
                holder.checkBoxAll.setChecked(true);
            }
        }else {
            //不选中
            if (holder.checkBox.getTag() != null && holder.checkBox.getTag().equals(position)) {
                holder.checkBox.setChecked(false);
            }
            holder.checkBoxAll.setChecked(false);
        }
        //数量增加
        holder.tv_asc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (onNumAscListener != null) {
                    onNumAscListener.onNumAscListener();
                }
            }
        });
        //数量减少
        holder.tv_desc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (onNumDescListener != null) {
                    onNumDescListener.onNumDescListener();
                }
            }
        });
        //适配数据
        holder.tv_brand.setText(vendorName);
        holder.tv_quantity.setText(quantity+"");
        holder.tv_name.setText(name);
        holder.tv_color.setText(color);
        holder.tv_size.setText(size);
        holder.tv_price.setText(sprice+"");
        Glide.with(context).load(logo_url).placeholder(R.mipmap.ic_launcher).into(holder.img_logo);
        Glide.with(context).load(url).placeholder(R.mipmap.ic_launcher).into(holder.img);
    }
    //品牌数
    @Override
    public int getItemCount() {
        return data.size();
    }
    //同一品牌下的商品数量
    public int getItemCountDetail(int position) {
        return data.get(position).getSkus().size();
    }
    static class MyViewHodler extends RecyclerView.ViewHolder{
        TextView tv_name,tv_size,tv_price,tv_color,tv_brand,tv_quantity,tv_asc,tv_desc;
        ImageView img,img_logo;
        CheckBox checkBoxAll,checkBox;
        public MyViewHodler(View itemView) {
            super(itemView);
            tv_name = (TextView) itemView.findViewById(R.id.tv_description);
            tv_size = (TextView) itemView.findViewById(R.id.tv_size1);
            tv_price = (TextView) itemView.findViewById(R.id.tv_price);
            tv_color = (TextView) itemView.findViewById(R.id.tv_color1);
            tv_brand = (TextView) itemView.findViewById(R.id.tv_brand);
            tv_quantity = (TextView) itemView.findViewById(R.id.textView5);
            img = (ImageView) itemView.findViewById(R.id.imageView2);
            img_logo = (ImageView) itemView.findViewById(R.id.img_brand);
            checkBox = (CheckBox) itemView.findViewById(R.id.checkBox);
            checkBoxAll = (CheckBox) itemView.findViewById(R.id.ck_allChoose);
            tv_asc = (TextView) itemView.findViewById(R.id.tv_asc);
            tv_desc = (TextView) itemView.findViewById(R.id.tv_desc);
        }
    }
}
