package com.samorodov.ilia.myapplication.exception;

import retrofit2.adapter.rxjava.HttpException;

public class HttpErrorBundle implements ErrorBundle {

    HttpException e;

    public HttpErrorBundle(HttpException e) {
        this.e = e;
    }

    @Override
    public Throwable exception() {
        return e;
    }

    @Override
    public String getErrorTitle() {
        return Integer.toString(e.code());
    }

    @Override
    public String getMessage() {
        return e.message();
    }
}
