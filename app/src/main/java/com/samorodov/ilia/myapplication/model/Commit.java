package com.samorodov.ilia.myapplication.model;

public class Commit {

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
