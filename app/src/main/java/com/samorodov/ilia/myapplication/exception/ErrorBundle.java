package com.samorodov.ilia.myapplication.exception;

import java.io.Serializable;

public interface ErrorBundle extends Serializable{

    Throwable exception();

    String getErrorTitle();

    String getMessage();
}
