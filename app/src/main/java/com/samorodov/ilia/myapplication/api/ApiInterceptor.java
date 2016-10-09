package com.samorodov.ilia.myapplication.api;

import android.util.Log;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Response;

public class ApiInterceptor implements Interceptor {

    @Override
    public Response intercept(Chain chain) throws IOException {
        Log.d("HTTP client","--> " + chain.request().method() + chain.request().url());
        Response response = chain.proceed(chain.request());
        Log.d("HTTP client","<-- " + response.body());
        return response;
    }

}
