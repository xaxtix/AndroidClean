package com.samorodov.ilia.myapplication.exception;

public interface ErrorBundle {

    Throwable exception();

    String getErrorTitle();

    String getMessage();
}
