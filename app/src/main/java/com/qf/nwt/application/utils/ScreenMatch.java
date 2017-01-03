package com.qf.nwt.application.utils;

import android.content.Context;
import android.util.DisplayMetrics;

/**
 * Created by Administrator on 2016/12/28.
 */

public class ScreenMatch {


    /**
     * Px------>dp
     * @param pxValue 在代码中的px值
     * @param context 当前上下文
     * @return 转换后dp的值
     */
    public static int px2dp(int pxValue, Context context){

        //获取设备当前屏幕信息类
        DisplayMetrics metrics = context.getResources().getDisplayMetrics();

        //获取当前系统的密度系数
        float density = metrics.density;

        //计算并返回实际dp的值
        return (int)(pxValue/density+0.5f);

    }

    /**
     * dp------>px
     * @param dpValue 在代码中的dp值
     * @param context 当前上下文
     * @return 转换后px的值
     */
    public static int dp2px(int dpValue, Context context){

        //获取设备当前屏幕信息类
        DisplayMetrics metrics = context.getResources().getDisplayMetrics();

        //获取当前系统的密度系数
        float density = metrics.density;

        //计算并返回实际dp的值
        return (int)(dpValue*density+0.5f);

    }



}
