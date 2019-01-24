package com.bw.movie.utils;


import com.bw.movie.contacts.Contact;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * <p>文件描述：<p>
 * <p>作者：${刘宇飞}<p>
 * <p>创建时间：2019/1/24 00248:34<p>
 */
public class OkHttpUtil {

    private final MyApiService myApiService;

    private OkHttpUtil() {
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .addInterceptor(interceptor)
                .writeTimeout(20, TimeUnit.SECONDS)
                .connectTimeout(20, TimeUnit.SECONDS)
                .readTimeout(20, TimeUnit.SECONDS)
                .build();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Contact.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .client(okHttpClient)
                .build();
        myApiService = retrofit.create(MyApiService.class);
    }

    public static OkHttpUtil getOkInstance() {
        return OkHttp.oKHttpUtil;
    }

    static class OkHttp {
        private static final OkHttpUtil oKHttpUtil = new OkHttpUtil();
    }

    public OkHttpUtil getData(String url, HashMap<String, Object> header, HashMap<String, Object> map) {
        if (header == null) {
            header = new HashMap<>();
        }
        if (map == null) {
            map = new HashMap<>();
        }
        Observer<ResponseBody> observer = new Observer<ResponseBody>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {
                if (okHttpFace != null) {
                    okHttpFace.onError(e.getMessage());
                }
            }

            @Override
            public void onNext(ResponseBody responseBody) {
                if (okHttpFace != null) {
                    try {
                        okHttpFace.onSuccess(responseBody.string());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        };
        myApiService.getData(url, header, map)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);
        return OkHttp.oKHttpUtil;
    }

    public OkHttpUtil postData(String url, HashMap<String, Object> header, HashMap<String, Object> map, String path) {
        if (header == null) {
            header = new HashMap<>();
        }
        if (map == null) {
            map = new HashMap<>();
        }
        Observer<ResponseBody> observer = new Observer<ResponseBody>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {
                if (okHttpFace != null) {
                    okHttpFace.onError(e.getMessage());
                }
            }

            @Override
            public void onNext(ResponseBody responseBody) {
                if (okHttpFace != null) {
                    try {
                        okHttpFace.onSuccess(responseBody.string());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        };
        if (!path.isEmpty()) {
            File file = new File(path);
            RequestBody requestBody = RequestBody.create(MediaType.parse("multipart/octet-stream"), file);
            MultipartBody.Builder builder = new MultipartBody.Builder();
            builder.setType(MultipartBody.FORM);
            builder.addFormDataPart("image", file.getName(), requestBody);
            myApiService.postHeader(url, header, builder.build())
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(observer);
        } else {
            myApiService.postData(url, header, map)
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(observer);
        }
        return OkHttp.oKHttpUtil;
    }

    public interface OkHttpFace {
        void onSuccess(String data);

        void onError(String error);
    }

    private OkHttpFace okHttpFace;

    public void setOkHttpFace(OkHttpFace okHttpFace) {
        this.okHttpFace = okHttpFace;
    }
}
