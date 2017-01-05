package com.qf.nwt.application.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.List;

/**
 * Created by Administrator on 2016/12/27 0027.
 */

public class AdapterOfMsgCenter extends FragmentStatePagerAdapter {
    private List<Fragment>fragments;
    private String[] tabTitles;
    public AdapterOfMsgCenter(FragmentManager fm ,String[] tabTitles, List<Fragment>fragments) {
        super(fm);
        this.tabTitles = tabTitles;
        this.fragments = fragments;
    }

    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return fragments.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return tabTitles[position];
    }
}
