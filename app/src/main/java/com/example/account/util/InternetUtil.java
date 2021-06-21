package com.example.account.util;

import com.example.account.Constants;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import okhttp3.Call;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;

public class InternetUtil {

    public static OkHttpClient getOkHttpClient(long timeout){
        return new OkHttpClient.Builder().readTimeout(timeout, TimeUnit.MILLISECONDS).build();
    }

    public static void doGet(String url){

    }
}
