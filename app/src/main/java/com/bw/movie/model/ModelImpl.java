package com.bw.movie.model;

import com.bw.movie.myinterface.MyInterFace;
import com.bw.movie.utils.OkHttpUtil;
import com.google.gson.Gson;

import java.util.HashMap;

/**
 * <p>文件描述：<p>
 * <p>作者：${刘宇飞}<p>
 * <p>创建时间：2019/1/24 00249:20<p>
 */
public class ModelImpl implements MyInterFace.Model {
    @Override
    public void getData(String url, HashMap<String, Object> header, HashMap<String, Object> map, final Class kind, final MyInterFace.MyCallBack myCallBack) {
        OkHttpUtil.getOkInstance().getData(url, header, map).setOkHttpFace(new OkHttpUtil.OkHttpFace() {
            @Override
            public void onSuccess(String data) {
                Gson gson = new Gson();
                Object o = gson.fromJson(data, kind);
                myCallBack.onSuccess(o, kind);
            }

            @Override
            public void onError(String error) {
                myCallBack.onError(error, kind);
            }
        });
    }

    @Override
    public void postData(String url, HashMap<String, Object> header, HashMap<String, Object> map, String path, final Class kind, final MyInterFace.MyCallBack myCallBack) {
        OkHttpUtil.getOkInstance().postData(url, header, map, path).setOkHttpFace(new OkHttpUtil.OkHttpFace() {
            @Override
            public void onSuccess(String data) {
                Gson gson = new Gson();
                Object o = gson.fromJson(data, kind);
                myCallBack.onSuccess(o, kind);
            }

            @Override
            public void onError(String error) {
                myCallBack.onError(error, kind);
            }
        });
    }
}
