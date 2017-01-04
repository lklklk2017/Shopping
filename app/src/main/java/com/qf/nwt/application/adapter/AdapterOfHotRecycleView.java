package com.qf.nwt.application.adapter;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.bumptech.glide.Glide;
import com.qf.nwt.application.R;
import com.qf.nwt.application.bean.HotInfo;
import com.qf.nwt.application.utils.ScreenMatch;

import java.util.ArrayList;
import java.util.List;

import cn.trinea.android.view.autoscrollviewpager.AutoScrollViewPager;

/**
 * Created by Administrator on 2016/12/27.
 * 设置recycle中的adpater实现多布局复用
 */

public class AdapterOfHotRecycleView extends RecyclerView.Adapter {

    //设置item的类型
    private static final int ITEM_TYPE_HEADER = 5;//vp：头布局
    private static final int ITEM_TYPE_CONTENT_WATERFALL = 4;//瀑布流布局
    private static final int ITEM_TYPE_CONTENT_ONE = 1;//一张图片
    private static final int ITEM_TYPE_CONTENT_TWO = 6;//两张图片合并
    private static final int ITEM_TYPE_CONTENT_ONE_LARGE = 8;//一张大图

    private List<HotInfo.ContentBean> list;
    private LayoutInflater layoutInflater;
    private Context context;
    private List<String> list_vp;
    private AdapterOfHotViewpage adapterOfHotViewpage;
    private List<ImageView> dotsList;//用于存放小点点的集合

    public AdapterOfHotRecycleView(Context context) {
        this.layoutInflater = layoutInflater.from(context);
        this.context = context;
    }

    public void setList(List<HotInfo.ContentBean> list, List<String> list_vp) {
        this.list = list;
        this.list_vp = list_vp;
        notifyDataSetChanged();
    }

    //传出vipager的数据
    public void setviewpagerList(List<String> list_vp) {
        this.list_vp = list_vp;
        notifyDataSetChanged();
    }

    public void setItemList(List<HotInfo.ContentBean> list) {
        Log.i("info","setItemList===========list.size()"+list.size());
        this.list = list;
        notifyDataSetChanged();
    }

    //判断当前item是否是header
    public boolean isHeaderView(int position) {

        return position == 0;
    }

    //判断当前item是否是一张图片
    public boolean isOneView(int position) {

        return position == 2 || position == 5 || position == 7;
    }

    //判断当前item是否是两张图片
    public boolean isTwoView(int position) {

        return position == 3 || position == 4;
    }

    //判断当前item是否是瀑布流布局
    public boolean isWaterView(int position) {

        return position == 1;
    }

    //判断当前item是否是一张大图布局
    public boolean isLargeOne(int position) {
        return position == 6;
    }

    //判断当前item的类型
    @Override
    public int getItemViewType(int position) {

        if (isHeaderView(position)) {
            return ITEM_TYPE_HEADER;
        } else if (isOneView(position)) {
            return ITEM_TYPE_CONTENT_ONE;
        } else if (isTwoView(position)) {
            return ITEM_TYPE_CONTENT_TWO;
        } else if (isWaterView(position)) {
            return ITEM_TYPE_CONTENT_WATERFALL;
        } else if (isLargeOne(position)) {
            return ITEM_TYPE_CONTENT_ONE_LARGE;
        }

        return -1;
    }

    /**
     * 创建viewholder，实现多布局在这里根据类型的不同，而实现返回不同的布局viewholder对象
     *
     * @param parent
     * @param viewType
     * @return
     */
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        switch (viewType) {
            case ITEM_TYPE_HEADER://vp的布局
                View headView = layoutInflater.inflate(R.layout.headviewpager_hot, parent, false);
                return new HeaderViewHolder(headView);

            case ITEM_TYPE_CONTENT_WATERFALL://瀑布流布局
                View waterfallView = layoutInflater.inflate(R.layout.waterfall, parent, false);
                return new WaterViewHolder(waterfallView);

            case ITEM_TYPE_CONTENT_ONE://一张图片的布局
                View oneView = layoutInflater.inflate(R.layout.one_pic, parent, false);
                return new OneViewHolder(oneView);
            case ITEM_TYPE_CONTENT_TWO://两张图片的布局
                View twoView = layoutInflater.inflate(R.layout.two_pic, parent, false);
                return new TwoViewHolder(twoView);
            case ITEM_TYPE_CONTENT_ONE_LARGE://一张大图的布局
                View oneLargeView = layoutInflater.inflate(R.layout.onelarge_pic, parent, false);
                return new OneLargeViewHolder(oneLargeView);

            default:
                break;
        }

        return null;
    }

    /**
     * 使用viewholder来进行数据的绑定,根据不同的类型的viewholder来绑定不同的数据
     *
     * @param holder
     * @param position
     */
    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        if (holder instanceof HeaderViewHolder) {

            if(list_vp!=null&&list_vp.size()!=0){
                //头布局是一个vp，初始化vp的数据
                HeaderViewHolder holder1 = ((HeaderViewHolder) holder);
                //初始化数据适配器
                adapterOfHotViewpage = new AdapterOfHotViewpage(context, list_vp);
                holder1.vp.setAdapter(adapterOfHotViewpage);

                //初始化小点点
                initDots(holder1.dotsLayout);

                //设置vp的监听事件
                holder1.vp.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {

                    @Override
                    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                    }

                    @Override
                    public void onPageSelected(int position) {

                        //每当vp页面的滑动有变化或者被选中时候，重新更新小点点list中的图片，当前选中为明色，否则暗色
                        for (int i = 0; i < list_vp.size(); i++) {
                            Drawable drawable = null;

                            if (position % list_vp.size() == i) {
                                drawable = context.getResources().getDrawable(R.drawable.checked);
                                dotsList.get(i).setImageDrawable(drawable);
                            } else {
                                drawable = context.getResources().getDrawable(R.drawable.uncheck);
                                dotsList.get(i).setImageDrawable(drawable);
                            }
                        }

                    }

                    @Override
                    public void onPageScrollStateChanged(int state) {

                    }
                });

                //开始滚动
                holder1.vp.startAutoScroll(4000);
            }

        } else if (holder instanceof WaterViewHolder) {
            if(null != list&&list.size()!=0){
                WaterViewHolder holder2 = ((WaterViewHolder) holder);
                HotInfo.ContentBean contentBean = list.get(1);

                List<HotInfo.ContentBean.EntriesBean> entries = contentBean.getEntries();

                Glide.with(context).load(entries.get(0).getImgURL()).placeholder(R.mipmap.ic_launcher).into(holder2.img_lt);
                holder2.img_lt.setScaleType(ImageView.ScaleType.FIT_XY);

                Glide.with(context).load(entries.get(1).getImgURL()).placeholder(R.mipmap.ic_launcher).into(holder2.img_rt);
                holder2.img_rt.setScaleType(ImageView.ScaleType.FIT_XY);

                Glide.with(context).load(entries.get(2).getImgURL()).placeholder(R.mipmap.ic_launcher).into(holder2.img_lb);
                holder2.img_lb.setScaleType(ImageView.ScaleType.FIT_XY);

                Glide.with(context).load(entries.get(3).getImgURL()).placeholder(R.mipmap.ic_launcher).into(holder2.img_rb);
                holder2.img_rb.setScaleType(ImageView.ScaleType.FIT_XY);

                //设置控件的监听事件
//                holder2.img_lt.setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View v) {
//                        Intent intent = new Intent(context, NewProduct.class);
//                        context.startActivity(intent);
//                    }
//                });
            }

        } else if (holder instanceof OneViewHolder) {
            if(null != list&&list.size()!=0){
                OneViewHolder holder3 = ((OneViewHolder) holder);
                if(position==2){
                    HotInfo.ContentBean contentBean = list.get(2);
                    Glide.with(context).load(contentBean.getImgURL()).placeholder(R.mipmap.ic_launcher).into(holder3.img);
                    holder3.img.setScaleType(ImageView.ScaleType.FIT_XY);
                }else if(position == 5){
                    HotInfo.ContentBean contentBean = list.get(5);
                    Glide.with(context).load(contentBean.getImgURL()).placeholder(R.mipmap.ic_launcher).into(holder3.img);
                    holder3.img.setScaleType(ImageView.ScaleType.FIT_XY);
                }else if(position == 7){
                    HotInfo.ContentBean contentBean = list.get(7);
                    Glide.with(context).load(contentBean.getImgURL()).placeholder(R.mipmap.ic_launcher).into(holder3.img);
                    holder3.img.setScaleType(ImageView.ScaleType.FIT_XY);
                }

            }

        } else if (holder instanceof TwoViewHolder) {
            if(null != list&&list.size()!=0) {

                TwoViewHolder holder4 = ((TwoViewHolder) holder);
                if(position==3){
                    HotInfo.ContentBean contentBean = list.get(3);
                    List<HotInfo.ContentBean.EntriesBean> entries = contentBean.getEntries();

                    Glide.with(context).load(entries.get(0).getImgURL()).placeholder(R.mipmap.ic_launcher).into(holder4.img_left);
                    holder4.img_left.setScaleType(ImageView.ScaleType.FIT_XY);

                    Glide.with(context).load(entries.get(1).getImgURL()).placeholder(R.mipmap.ic_launcher).into(holder4.img_right);
                    holder4.img_right.setScaleType(ImageView.ScaleType.FIT_XY);
                }else if(position==4){
                    HotInfo.ContentBean contentBean = list.get(4);
                    List<HotInfo.ContentBean.EntriesBean> entries = contentBean.getEntries();

                    Glide.with(context).load(entries.get(0).getImgURL()).placeholder(R.mipmap.ic_launcher).into(holder4.img_left);
                    holder4.img_left.setScaleType(ImageView.ScaleType.FIT_XY);

                    Glide.with(context).load(entries.get(1).getImgURL()).placeholder(R.mipmap.ic_launcher).into(holder4.img_right);
                    holder4.img_right.setScaleType(ImageView.ScaleType.FIT_XY);
                }

            }
        } else if (holder instanceof OneLargeViewHolder) {
            if(null != list&&list.size()!=0) {

                OneLargeViewHolder holder5 = ((OneLargeViewHolder) holder);
                HotInfo.ContentBean contentBean = list.get(6);

                Glide.with(context).load(contentBean.getImgURL()).placeholder(R.mipmap.ic_launcher).into(holder5.img);
                holder5.img.setScaleType(ImageView.ScaleType.FIT_XY);
            }
        }
    }

    /**
     * 初始化小点点模块
     */
    private void initDots(LinearLayout dotsLayout) {
        //定义开始初始化接受小点点的list
        dotsList = new ArrayList<>();

        //每次加载，清空集合
        dotsList.clear();

        //每次刷新之前都要移除所有dotslayout中的view
        dotsLayout.removeAllViews();

        //开始遍历数组添加小点点
        for (int i = 0; i < list_vp.size(); i++) {
            ImageView img = new ImageView(context);
            Drawable drawable = null;

            //默认第一次初始化将第一个小点点设置为选中状态
            if (i == 0) {
                drawable = context.getResources().getDrawable(R.drawable.checked);
            } else {
                drawable = context.getResources().getDrawable(R.drawable.uncheck);
            }

            img.setImageDrawable(drawable);

            //考虑适配：
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(ScreenMatch.dp2px(15, context), ScreenMatch.dp2px(3, context));
            params.setMargins(ScreenMatch.dp2px(3, context), 0, ScreenMatch.dp2px(3, context), 0);

            //添加到父容器中去,同时设置img的布局属性
            dotsLayout.addView(img, params);
            //添加到小点点的list中去
            dotsList.add(img);
        }
    }

    @Override
    public int getItemCount() {
        if(null != list&& list.size()!=0){
            return 8;
        }else{
            return -1;
        }
    }

    /**
     * 查找控件(头部viewholder)
     */
    class HeaderViewHolder extends RecyclerView.ViewHolder {

        AutoScrollViewPager vp;
        LinearLayout dotsLayout;//找到小点点的布局容器

        public HeaderViewHolder(View itemView) {
            super(itemView);
            vp = (AutoScrollViewPager) itemView.findViewById(R.id.vp_headofrecycle_Hot);
            dotsLayout = ((LinearLayout) itemView.findViewById(R.id.lin_tap));
        }
    }

    /**
     * 查找控件(两张图片的viewholder)
     */
    class TwoViewHolder extends RecyclerView.ViewHolder {

        ImageView img_left;
        ImageView img_right;

        public TwoViewHolder(View itemView) {
            super(itemView);
            img_left = (ImageView) itemView.findViewById(R.id.pic_left_TwoPic);
            img_right = (ImageView) itemView.findViewById(R.id.pic_right_TwoPic);
        }
    }

    /**
     * 查找控件(一个图片的viewholder)
     */
    class OneViewHolder extends RecyclerView.ViewHolder {

        ImageView img;

        public OneViewHolder(View itemView) {
            super(itemView);
            img = (ImageView) itemView.findViewById(R.id.img_One);
        }
    }

    /**
     * 查找控件(瀑布流的viewholder)
     */
    class WaterViewHolder extends RecyclerView.ViewHolder {

        ImageView img_lt;
        ImageView img_rt;
        ImageView img_lb;
        ImageView img_rb;

        public WaterViewHolder(View itemView) {
            super(itemView);
            img_lt = (ImageView) itemView.findViewById(R.id.img_newPic_water);
            img_rt = (ImageView) itemView.findViewById(R.id.img_rtPic_water);
            img_lb = (ImageView) itemView.findViewById(R.id.img_lbPic_water);
            img_rb = (ImageView) itemView.findViewById(R.id.img_rbPic_water);
        }
    }

    /**
     * 查找控件(一张大图的viewholder)
     */
    class OneLargeViewHolder extends RecyclerView.ViewHolder {

        ImageView img;

        public OneLargeViewHolder(View itemView) {
            super(itemView);
            img = (ImageView) itemView.findViewById(R.id.img_OneLarge);
        }
    }

}
