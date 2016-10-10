package com.samorodov.ilia.myapplication.presentation.starting;

import com.samorodov.ilia.myapplication.model.Repository;
import com.samorodov.ilia.myapplication.presentation.base.BasePresenter;

import javax.inject.Inject;

public class StartingPresenter extends BasePresenter<StartingView>{

    @Inject
    public StartingPresenter(){

    }

    public void onNextClick(String owner,String repo){
        getView().startCommitsFragment(new Repository(owner,repo));
    }
}
