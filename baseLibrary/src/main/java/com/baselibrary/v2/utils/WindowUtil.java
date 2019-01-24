package com.baselibrary.v2.utils;

import android.content.Context;

import com.baselibrary.v2.utils.Static;


/**
 * @author: zjl
 * @Time: 2017/11/22 10:58
 * @Desc:
 */

public class WindowUtil {


    /**
     * 获取导航栏高度
     */
    public static int getNavHeight() {
        int result = 0;
        int resourceId = 0;
        int rid = Static.CONTEXT.getResources().getIdentifier("config_showNavigationBar", "bool", "android");
        if (rid != 0) {
            resourceId = Static.CONTEXT.getResources().getIdentifier("navigation_bar_height", "dimen", "android");
            return Static.CONTEXT.getResources().getDimensionPixelSize(resourceId);
        } else
            return 0;
    }
}
