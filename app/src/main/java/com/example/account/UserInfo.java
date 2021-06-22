package com.example.account;

import android.app.Application;
import android.os.StrictMode;
import android.util.Log;


import com.example.account.Constants.UrlConstants;
import com.example.account.entity.UserBean;
import com.example.account.util.InternetUtil;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;

import org.jetbrains.annotations.NotNull;

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

public class UserInfo extends Application {
    UserBean userBean;

    public UserBean getUserBean() {
        return userBean;
    }

    public void setUserBean(UserBean userBean) {
        this.userBean = userBean;
    }

    @Override
    public void onCreate() {
        final String[] result = new String[1];
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        OkHttpClient client = new OkHttpClient.Builder().readTimeout(5, TimeUnit.SECONDS).build();
        FormBody.Builder builder = new FormBody.Builder();
        builder.add("id","1");
        RequestBody requestBody = builder.build();
        Request request = new Request.Builder().url(UrlConstants.GET_ONE_USER)
                .post(requestBody).build();
        Call call = client.newCall(request);
        try {
            Response response = call.execute();
            result[0] = response.body().string();

            ObjectMapper objectMapper = new ObjectMapper();
            setUserBean(objectMapper.readValue(result[0],UserBean.class));
            Log.d("UserBean",result[0]);
            if(userBean == null){
                Log.d("UserBean","null");
            }
            response.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        super.onCreate();

//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                InternetUtil.sendOkHttpRequest(UrlConstants.GET_ONE_USER,
//                        new FormBody.Builder().
//                                add("id","1").
//                                build(),
//                        new Callback() {
//                            @Override
//                            public void onFailure(@NotNull Call call, @NotNull IOException e) {
//                                e.printStackTrace();
//                            }
//
//                            @Override
//                            public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {
//                                result[0] = response.body().string();
//                                Gson gson = new Gson();
//                                setUserBean(gson.fromJson(result[0],UserBean.class));
//
//                            }
//                        });
//            }
//        }).start();

    }
}
