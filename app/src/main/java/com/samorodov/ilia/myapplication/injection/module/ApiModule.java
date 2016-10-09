package com.samorodov.ilia.myapplication.injection.module;

import com.samorodov.ilia.myapplication.api.ApiInterceptor;
import com.samorodov.ilia.myapplication.api.ApiInterface;
import com.samorodov.ilia.myapplication.api.ApiInterfaceCreator;
import com.samorodov.ilia.myapplication.injection.dependencies.UrlModule;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.Interceptor;

@Module
public class ApiModule {

    @Provides
    @Singleton
    ApiInterface provideApiInterface(@Named(UrlModule.PROD) String url, Interceptor interceptor){
        return ApiInterfaceCreator.getApiInterface(url,interceptor);
    }
}
