package com.qf.nwt.application.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.qf.nwt.application.R;
import com.qf.nwt.application.bean.Children;
import com.qf.nwt.application.bean.Group;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/1/9 0009.
 */

public class AdapterOfExpandableListView extends BaseExpandableListAdapter {
    private Context context;
    private LayoutInflater inflater;
    private List<Group> groups = new ArrayList<>();

    public AdapterOfExpandableListView(Context context/*,List<Group> groups*/) {
            this.context = context;
//        this.groups = groups;
        inflater = LayoutInflater.from(context);
    }

    public void setGroups(List<Group> groups) {
        this.groups = groups;
        notifyDataSetChanged();
    }


    @Override
    public int getGroupCount() {
        Log.e("====","groups.size()="+groups.size());
        return groups.size();
    }

    @Override
    public int getChildrenCount(int i) {
        Log.e("====","groups.get(i).getChildrens().size()="+groups.get(i).getChildrens().size());
        return groups.get(i).getChildrens().size();
    }

    @Override
    public Object getGroup(int i) {
        return groups.get(i);
    }

    @Override
    public Object getChild(int i, int i1) {
        return groups.get(i).getChildrens().get(i1);
    }

    @Override
    public long getGroupId(int i) {
        return 0;
    }

    @Override
    public long getChildId(int i, int i1) {
        return 0;
    }

    @Override
    public boolean hasStableIds() {
        return true;
    }

    @Override
    public View getGroupView(int i, boolean b, View view, ViewGroup viewGroup) {
        GroupViewHolder groupViewHolder = null;
        if (view == null) {
            view = inflater.inflate(R.layout.item_group,viewGroup,false);
            groupViewHolder = new GroupViewHolder();
            groupViewHolder.textView = (TextView) view.findViewById(R.id.tv_goodsDetail);
            view.setTag(groupViewHolder);
        }else {
            groupViewHolder = (GroupViewHolder) view.getTag();
        }
        groupViewHolder.textView.setText(groups.get(i).getTitle());
        return view;
    }

    @Override
    public View getChildView(int i, int i1, boolean b, View view, ViewGroup viewGroup) {
        ChildrenViewHolder childrenViewHolder = null;
        if (view == null) {
            view = inflater.inflate(R.layout.item_expandablelistview,viewGroup,false);
            childrenViewHolder = new ChildrenViewHolder(view);
        }else {
            childrenViewHolder = (ChildrenViewHolder) view.getTag();
        }
        Group group = groups.get(i);
        Children children = group.getChildrens().get(i1);
        Glide.with(context)
                .load(children.getImg_url())
                .placeholder(R.mipmap.ic_launcher)
                .into(childrenViewHolder.imageView);
        return view;
    }

    @Override
    public boolean isChildSelectable(int i, int i1) {
        return true;
    }
    static class GroupViewHolder {
        TextView textView;
    }
    static class ChildrenViewHolder {
        ImageView imageView;
        View itemView;
        public ChildrenViewHolder(View itemView) {
            this.itemView = itemView;
            imageView = (ImageView) itemView.findViewById(R.id.img_content);
            itemView.setTag(this);
        }
    }
}
