package com.samorodov.ilia.myapplication.api;


import android.support.annotation.Nullable;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiInterfaceCreator {

    public static ApiInterface getApiInterface(String url){
        return getApiInterface(url,null);
    }

    public static ApiInterface getApiInterface(String url,
                                               @Nullable Interceptor interceptor) {

        OkHttpClient.Builder client = new OkHttpClient().newBuilder();
            client.addNetworkInterceptor(interceptor);


        Retrofit.Builder builder = new Retrofit.Builder().
                baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .client(client.build())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create());

        ApiInterface apiInterface = builder.build().create(ApiInterface.class);

        return apiInterface;
    }
}
