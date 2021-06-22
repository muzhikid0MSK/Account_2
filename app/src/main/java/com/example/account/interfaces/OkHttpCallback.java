package com.example.account.interfaces;

import java.io.IOException;

import okhttp3.Response;

public interface OkHttpCallback {
    void onSuccess(Response response);
    void onFailure(IOException e);

}
