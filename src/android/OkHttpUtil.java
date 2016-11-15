package com.ktb.plugin.util;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.Iterator;
import java.util.Map;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;

/**
 * 项目名称：android
 * 类描述：
 * 创建人：HONGYU.LIU
 * 创建时间：2016/11/8 17:06
 * 修改人：HONGYU.LIU
 * 修改时间：2016/11/8 17:06
 * 修改备注：
 */
public class OkHttpUtil {
    public static void doGet(String url, Callback callback) {
        final Request request = new Request.Builder()
                .url(url)
                .build();
        OkHttpClient okHttpClient = new OkHttpClient();
        Call call = okHttpClient.newCall(request);
        call.enqueue(callback);
    }

    public static void doPost(String url, String requestBody, Callback callback) {
        FormBody.Builder builder = addParamToBuilder(requestBody);
        RequestBody body = builder.build();
        Request request = new Request.Builder()
                .url(url)
                .post(body)
                .build();
        OkHttpClient okHttpClient = new OkHttpClient();
        Call call = okHttpClient.newCall(request);
        call.enqueue(callback);
    }

    public static void doPut(String url, String requestBody, Callback callback) {
        FormBody.Builder builder = addParamToBuilder(requestBody);
        RequestBody body = builder.build();
        Request request = new Request.Builder()
                .url(url)
                .post(body)
                .build();
        OkHttpClient okHttpClient = new OkHttpClient();
        Call call = okHttpClient.newCall(request);
        call.enqueue(callback);
    }

    public static void doDelete(String url, String requestBody, Callback callback) {
        FormBody.Builder builder = addParamToBuilder(requestBody);
        RequestBody body = builder.build();
        Request request = new Request.Builder()
                .url(url)
                .post(body)
                .build();
        OkHttpClient okHttpClient = new OkHttpClient();
        Call call = okHttpClient.newCall(request);
        call.enqueue(callback);
    }

    public static FormBody.Builder addParamToBuilder(String requestBody) {
        Map<String, Object> map = new Gson().fromJson(requestBody, new TypeToken<Map>() {
        }.getType());
        FormBody.Builder builder = new FormBody.Builder();
        if (map != null) {
            Iterator<Map.Entry<String, Object>> ite = map.entrySet().iterator();
            for (; ite.hasNext(); ) {
                Map.Entry<String, Object> kv = ite.next();
                builder.add(kv.getKey(), kv.getValue().toString());
            }
        }
        return builder;
    }


}
