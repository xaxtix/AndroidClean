package com.samorodov.ilia.myapplication.presentation;

import com.samorodov.ilia.myapplication.model.vo.Repo;

public interface ActivityCallback {

    void startCommitsFragment(Repo repo);

    void back();

}
