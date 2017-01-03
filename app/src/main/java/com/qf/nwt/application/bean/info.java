package com.qf.nwt.application.bean;

/**
 * Created by Administrator on 2016/12/27.
 */

public class Info {

    private String name;
    private int PicId;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPicId() {
        return PicId;
    }

    public void setPicId(int picId) {
        PicId = picId;
    }

    public Info(String name, int picId) {
        this.name = name;
        PicId = picId;
    }
}
