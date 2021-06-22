package com.example.account.util;

import com.example.account.Constants.UrlConstants;
import com.example.account.interfaces.MyCallBack;
import com.example.account.interfaces.OkHttpCallback;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.internal.LinkedTreeMap;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class InternetUtil {

    /**
     *
     * @param url
     * @param callback
     * @param formBody
     */
    public static void sendOkHttpRequest(String url, FormBody formBody,Callback callback ){
        OkHttpClient okHttpClient = new OkHttpClient();
        if(formBody == null){ //Get请求
            Request request =new Request.Builder()
                    .url(url)
                    .build();
            okHttpClient.newCall(request).enqueue(callback);
        }else{
            Request request = new Request.Builder()
                    .url(url)
                    .post(formBody).build();
            okHttpClient.newCall(request).enqueue(callback);
        }
    }
    /**
     * 参考用法 带参数
     *
     *  keyValue.put("user_id","123");
     *  keyValue.put("year",""+calendar.get(Calendar.YEAR));
     *  keyValue.put("month",""+(calendar.get(Calendar.MONTH)+1));
     *  keyValue.put("day",""+calendar.get(Calendar.DAY_OF_MONTH));
     *  String content = InternetUtil.sendSyncRequest(UrlConstants.GET_WEEKLY_COST_STATISTICS,keyValue).body().string();
     *  ObjectMapper objectMapper = new ObjectMapper();
     *  weeklyCostBean[0] = objectMapper.readValue(content,WeeklyCostBean.class);
     */


    /**
     * 同步请求
     * @param url
     * @param params
     * @return
     */
    public static Response sendSyncRequest(String url, Map<String,String>params){
        OkHttpClient client = new OkHttpClient.Builder().readTimeout(5, TimeUnit.SECONDS).build();
        FormBody.Builder builder = new FormBody.Builder();
        if(params!=null) {
            for (String key : params.keySet()) {
                builder.add(key, params.get(key));
            }
            RequestBody requestBody = builder.build();
            Request request = new Request.Builder().url(url)
                    .post(requestBody).build();
            Call call = client.newCall(request);
            try {
                return call.execute();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }else{
            Request request = new Request.Builder().url(url).get().build();
            Call call = client.newCall(request);
            try{
                return call.execute();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}
