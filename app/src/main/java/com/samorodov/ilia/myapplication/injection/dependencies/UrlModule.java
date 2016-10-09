package com.samorodov.ilia.myapplication.injection.dependencies;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class UrlModule {

    public static final String PROD = "PROD";
    public static final String TEST = "TEST";

    @Provides
    @Named(PROD)
    @Singleton
    public String provideProdUrl(){
        return "https://api.github.com";
    }

    @Provides
    @Named(TEST)
    @Singleton
    public String provideTestUrl(){
        return "https://api.test.github.com";
    }
}
