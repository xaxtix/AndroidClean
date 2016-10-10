package com.samorodov.ilia.myapplication.exception;

import retrofit2.adapter.rxjava.HttpException;

public class ErrorBundleFactory {

    public static ErrorBundle createErrorBundle(Throwable e){
        if(e instanceof HttpException){
            return new HttpErrorBundle((HttpException) e);
        }

        return new DefaultErrorBundle(e);
    }
}
