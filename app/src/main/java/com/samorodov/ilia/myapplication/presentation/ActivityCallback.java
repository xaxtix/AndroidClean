package com.samorodov.ilia.myapplication.presentation;

import com.samorodov.ilia.myapplication.model.Repository;

public interface ActivityCallback {

    void startCommitsFragment(Repository repository);

    void back();

}
