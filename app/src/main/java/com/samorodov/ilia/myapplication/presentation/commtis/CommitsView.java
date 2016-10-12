package com.samorodov.ilia.myapplication.presentation.commtis;

import com.samorodov.ilia.myapplication.exception.ErrorBundle;
import com.samorodov.ilia.myapplication.model.vo.Commit;
import com.samorodov.ilia.myapplication.model.vo.Repo;

import java.util.List;

public interface CommitsView {

    void showError(ErrorBundle e);

    void showProgress();

    void setCommits(List<Commit> commits);

    Repo getRepoVO();
}
