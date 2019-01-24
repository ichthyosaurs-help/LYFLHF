package com.bw.movie.utils;

import java.util.HashMap;

import okhttp3.MultipartBody;
import okhttp3.ResponseBody;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.HeaderMap;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.QueryMap;
import retrofit2.http.Url;
import rx.Observable;

/**
 * <p>文件描述：<p>
 * <p>作者：${刘宇飞}<p>
 * <p>创建时间：2019/1/23 002320:27<p>
 */
public interface MyApiService {

    @GET
    Observable<ResponseBody> getData(@Url String url, @HeaderMap HashMap<String, Object> header, @QueryMap HashMap<String, Object> map);

    @POST
    Observable<ResponseBody> postData(@Url String url, @HeaderMap HashMap<String, Object> header, @QueryMap HashMap<String, Object> map);

    @Multipart
    @POST
    Observable<ResponseBody> postHeader(@Url String url, @HeaderMap HashMap<String, Object> header, @Body MultipartBody body);

}