package com.example.account.interfaces;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

public class MyCallBack implements Callback {
    private OkHttpCallback okHttpCallBack;

    public MyCallBack(OkHttpCallback okHttpCallBack) {
        this.okHttpCallBack = okHttpCallBack;
    }

    @Override
    public void onFailure(Call call, IOException e) {
        okHttpCallBack.onFailure(e);
    }

    @Override
    public void onResponse(Call call, Response response) throws IOException {
        okHttpCallBack.onSuccess(response);
    }
}