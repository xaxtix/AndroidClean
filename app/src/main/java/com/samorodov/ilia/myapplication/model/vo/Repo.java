package com.samorodov.ilia.myapplication.model.vo;

import java.io.Serializable;

public class Repo implements Serializable {

    String author;
    String repo;

    public Repo(String author, String repo) {
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
