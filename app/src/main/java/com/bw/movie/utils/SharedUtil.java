package com.bw.movie.utils;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * <p>文件描述：<p>
 * <p>作者：${刘宇飞}<p>
 * <p>创建时间：2019/1/2 000220:47<p>
 */
public class SharedUtil {
    private static final String NAME = "MOVIE";
    private static SharedPreferences.Editor editor;
    private static SharedPreferences sharedPreferences;
    private static Context mcontext;
    private static final int TYPE_ONE = 1;
    private static final int TYPE_TWO = 2;
    private static final int TYPE_THREE = 3;

    static class Shared {
        private static final SharedUtil SHARED_UTIL = new SharedUtil();
    }

    //初始化
    public static SharedUtil SharedPrefrenceHelper(Context context) {
        mcontext = context;
        sharedPreferences = context.getSharedPreferences(NAME, Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
        return Shared.SHARED_UTIL;
    }

    public void setSave(String key, Object object) {
        if (object instanceof String) {
            editor.putString(key, (String) object);
        } else if (object instanceof Integer) {
            editor.putInt(key, (int) object);
        } else if (object instanceof Boolean) {
            editor.putBoolean(key, (boolean) object);
        }
        editor.commit();
    }

    public Object getData(String key, int type) {
        if (type == TYPE_ONE) {
            return sharedPreferences.getString(key, "");
        } else if (type == TYPE_TWO) {
            return sharedPreferences.getInt(key, 0);
        } else {
            return sharedPreferences.getBoolean(key, false);
        }
    }
}
