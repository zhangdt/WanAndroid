package com.sise.abner.abaselib.util;

import android.content.Context;

import com.sise.abner.abaselib.SDKBaseLib;
import com.sise.abner.abaselib.base.BaseApp;

/**
 * <pre>
 *     author: Blankj
 *     blog  : http://blankj.com
 *     time  : 16/12/08
 *     desc  : Utils初始化相关
 * </pre>
 */
public class Utils {

    //
//    private static Context context;
//    private static SPUtils spUtils;

    private Utils() {
        throw new UnsupportedOperationException("u can't instantiate me...");
    }

    /**
     * 初始化工具类
     *
     * @param context 上下文
     */
    @Deprecated
    public static void init(Context context) {
//        Utils.context = context.getApplicationContext();
//        spUtils = new SPUtils("utilcode");
    }

    /**
     * 获取ApplicationContext
     *
     * @return ApplicationContext
     */
    public static Context getContext() {
//        if (context != null) return context;
        return SDKBaseLib.application;
    }

//    public static SPUtils getSpUtils() {
//        return spUtils;
//    }
}