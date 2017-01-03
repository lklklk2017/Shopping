package com.qf.nwt.application.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.qf.nwt.application.R;
import com.thinkcool.circletextimageview.CircleTextImageView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by fyl on 2016/12/27.
 * Match页面的GridView的适配器
 */

public class MatchGridViewAdapter extends BaseAdapter {
    Context context;
    //List<Integer> lists=new ArrayList<>();
    List<String> lists=new ArrayList<>();
    public MatchGridViewAdapter(Context context, List<String> lists) {
        this.context = context;
        this.lists = lists;
    }
    @Override
    public int getCount() {
        return lists.size();
    }

    @Override
    public Object getItem(int i) {
        return lists.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        view= LayoutInflater.from(context).inflate(R.layout.popupwindow_view_item,viewGroup,false);
        CircleTextImageView img= (CircleTextImageView) view.findViewById(R.id.ctiv_match);
        //img.setBackgroundResource(lists.get(i));
        img.setText(lists.get(i));
        return view;
    }
}
