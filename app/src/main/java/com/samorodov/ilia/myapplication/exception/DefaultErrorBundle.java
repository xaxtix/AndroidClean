package com.samorodov.ilia.myapplication.exception;

public class DefaultErrorBundle implements ErrorBundle{

    Throwable e;

    public DefaultErrorBundle(Throwable e) {
        this.e = e;
    }

    @Override
    public Throwable getException() {
        return e;
    }

    @Override
    public String getErrorTitle() {
        return "Ooops";
    }

    @Override
    public String getMessage() {
        return e.getMessage();
    }
}
