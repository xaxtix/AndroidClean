package com.samorodov.ilia.myapplication.presentation.commtis;

import com.samorodov.ilia.myapplication.model.Commit;

import java.util.List;

public interface CommitsView {

    void showError(Throwable e);

    void setCommits(List<Commit> commits);
}
