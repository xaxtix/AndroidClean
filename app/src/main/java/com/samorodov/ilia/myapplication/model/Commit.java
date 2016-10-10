package com.samorodov.ilia.myapplication.model;

import java.io.Serializable;

public class Commit implements Serializable{

    String author;

    String message;

    public Commit(String author, String message) {
        this.author = author;
        this.message = message;
    }

    public String getAuthor() {
        return author;
    }

    public String getMessage() {
        return message;
    }

}
