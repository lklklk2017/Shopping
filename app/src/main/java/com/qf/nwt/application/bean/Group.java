package com.qf.nwt.application.bean;

import java.util.List;

/**
 * Created by Administrator on 2017/1/9 0009.
 */

public class Group {
    private String title;
    private List<Children> childrens;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Children> getChildrens() {
        return childrens;
    }

    public void setChildrens(List<Children> childrens) {
        this.childrens = childrens;
    }
}
