package com.bw.movie.myinterface;

import java.util.HashMap;

/**
 * <p>文件描述：<p>
 * <p>作者：${刘宇飞}<p>
 * <p>创建时间：2019/1/23 002320:56<p>
 */
public interface MyInterFace {
    interface MyCallBack<T> {
        void onSuccess(T data, Class kind);

        void onError(String error, Class kind);
    }

    interface MyView<T> {
        void onRequestOk(T data, Class kind);

        void onRequestNo(String error, Class kind);
    }

    interface Model {
        void getData(String url, HashMap<String, Object> header, HashMap<String, Object> map, Class kind, MyCallBack myCallBack);

        void postData(String url, HashMap<String, Object> header, HashMap<String, Object> map, String path, Class kind, MyCallBack myCallBack);

    }
    interface Presenter {
        void getData(String url, HashMap<String, Object> header, HashMap<String, Object> map, Class kind);

        void postData(String url, HashMap<String, Object> header, HashMap<String, Object> map, String path, Class kind);

    }
}
