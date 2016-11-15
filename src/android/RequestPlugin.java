package com.ktb.plugin;

/**
 * 项目名称：android
 * 类描述：
 * 创建人：HONGYU.LIU
 * 创建时间：2016/10/19 17:36
 * 修改人：HONGYU.LIU
 * 修改时间：2016/10/19 17:36
 * 修改备注：
 */


import com.ktb.plugin.util.OkHttpUtil;

import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaInterface;
import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CordovaWebView;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;


/**
 * 项目名称：android
 * 类描述：
 * 创建人：HONGYU.LIU
 * 创建时间：2016/10/19 10:23
 * 修改人：HONGYU.LIU
 * 修改时间：2016/10/19 10:23
 * 修改备注：
 */

public class RequestPlugin extends CordovaPlugin {
    private static final String getRequest_Action = "getRequest";
    private static final String postRequest_Action = "postRequest";
    private static final String putRequest_Action = "putRequest";
    private static final String deleteRequest_Action = "deleteRequest";

    /**
     * Constructor.
     */
    public RequestPlugin() {
    }

    public void initialize(CordovaInterface cordova, CordovaWebView webView) {
        super.initialize(cordova, webView);
    }

    @Override //插件的执行方法，
    public boolean execute(String action, String args, final CallbackContext callbackContext) throws JSONException {
        String url = "";
        JSONArray jsonArray = new JSONArray(args);
        Callback callback = new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                callbackContext.error(e.toString());
            }

            @Override
            public void onResponse(Call call, final Response response) throws IOException {
                String result = response.body().string();
                callbackContext.success(result);
            }
        };
        if (action.equals(getRequest_Action)) {
            url = jsonArray.get(0).toString();//请求地址
            OkHttpUtil.doGet(url, callback);
        } else if (action.equals(deleteRequest_Action)) {
            url = jsonArray.get(0).toString();//请求地址
            OkHttpUtil.doDelete(url, null, callback);
        } else if (action.equals(postRequest_Action)) {
            JSONObject argJson = jsonArray.getJSONObject(0);
            url = argJson.getString("url");//请求地址
            JSONObject jsonObject = argJson.getJSONObject("params");//请求参数
            String params = jsonObject.toString();
            OkHttpUtil.doPost(url, params, callback);
        } else if (action.equals(putRequest_Action)) {
            JSONObject argJson = jsonArray.getJSONObject(0);
            url = argJson.getString("url");//请求地址
            JSONObject jsonObject = argJson.getJSONObject("params");//请求参数
            String params = jsonObject.toString();
            OkHttpUtil.doPut(url, params, callback);
        }
        return true;
    }

    @Override //插件的执行方法，
    public boolean execute(String action, JSONArray args, final CallbackContext callbackContext) throws JSONException {
        JSONObject argJson = args.getJSONObject(0);
        String url = "";
        Callback callback = new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                callbackContext.error(e.toString());
            }

            @Override
            public void onResponse(Call call, final Response response) throws IOException {
                String result = response.body().string();
                callbackContext.success(result);
            }
        };
        if (action.equals(postRequest_Action)) {
            url = argJson.getString("url");//请求地址
            JSONObject jsonObject = argJson.getJSONObject("params");//请求参数
            String params = jsonObject.toString();
            OkHttpUtil.doPost(url, params, callback);
        } else if (action.equals(putRequest_Action)) {
            url = argJson.getString("url");//请求地址
            JSONObject jsonObject = argJson.getJSONObject("params");//请求参数
            String params = jsonObject.toString();
            OkHttpUtil.doPut(url, params, callback);
        }
        return true;
    }

}

