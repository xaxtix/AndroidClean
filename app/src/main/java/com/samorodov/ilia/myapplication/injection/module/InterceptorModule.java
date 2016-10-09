package com.samorodov.ilia.myapplication.injection.module;


import com.samorodov.ilia.myapplication.api.ApiInterceptor;

import dagger.Module;
import dagger.Provides;
import okhttp3.Interceptor;

@Module
public class InterceptorModule {

    @Provides
    public Interceptor interceptor(){
        return new ApiInterceptor();
    }
}
