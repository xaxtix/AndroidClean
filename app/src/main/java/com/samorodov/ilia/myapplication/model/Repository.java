package com.samorodov.ilia.myapplication.model;

import java.io.Serializable;

public class Repository implements Serializable {

    String author;
    String repo;

    public Repository(String author, String repo) {
        this.author = author;
        this.repo = repo;
    }

    public String getAuthor() {
        return author;
    }

    public String getRepo() {
        return repo;
    }
}
