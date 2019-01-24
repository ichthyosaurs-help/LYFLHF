package com.bw.movie.presenter;


import com.bw.movie.model.ModelImpl;
import com.bw.movie.myinterface.MyInterFace;

import java.util.HashMap;

/**
 * <p>文件描述：<p>
 * <p>作者：${刘宇飞}<p>
 * <p>创建时间：2019/1/24 00249:32<p>
 */
public class PresenterImpl implements MyInterFace.Presenter {

    private MyInterFace.MyView myView;
    private ModelImpl model;

    public PresenterImpl(MyInterFace.MyView myView) {
        this.myView = myView;
        model = new ModelImpl();
    }

    @Override
    public void getData(String url, HashMap<String, Object> header, HashMap<String, Object> map, Class kind) {
        model.getData(url, header, map, kind, new MyInterFace.MyCallBack() {
            @Override
            public void onSuccess(Object data, Class kind) {
                myView.onRequestOk(data, kind);
            }

            @Override
            public void onError(String error, Class kind) {
                myView.onRequestNo(error, kind);
            }
        });
    }

    @Override
    public void postData(String url, HashMap<String, Object> header, HashMap<String, Object> map, String path, Class kind) {
        model.postData(url, header, map, path, kind, new MyInterFace.MyCallBack() {
            @Override
            public void onSuccess(Object data, Class kind) {
                myView.onRequestOk(data, kind);
            }

            @Override
            public void onError(String error, Class kind) {
                myView.onRequestNo(error, kind);
            }
        });
    }
}
