package com.samorodov.ilia.myapplication.presentation.commtis;


import android.os.Bundle;

import com.samorodov.ilia.myapplication.exception.ErrorBundleFactory;
import com.samorodov.ilia.myapplication.interactor.GetCommitsInteractor;
import com.samorodov.ilia.myapplication.model.Commit;
import com.samorodov.ilia.myapplication.presentation.base.BasePresenter;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import rx.Subscriber;
import rx.Subscription;


public class CommitsPresenter extends BasePresenter<CommitsView> {

    private static final String BUNDLE_COMMITS_KEY = "BUNDLE_COMMITS_KEY";
    private static final String BUNDLE_VIEW_STATE_KEY = "BUNDLE_VIEW_STATE_KEY";
    GetCommitsInteractor interactor;

    ViewState viewState;

    List<Commit> commits;

    @Inject
    public CommitsPresenter(GetCommitsInteractor interactor) {
        this.interactor = interactor;
    }

    public void onCreateView(Bundle savedInstanceState) {
        if (savedInstanceState != null) {
            commits = (List<Commit>) savedInstanceState.getSerializable(BUNDLE_COMMITS_KEY);
            viewState = (ViewState) savedInstanceState.getSerializable(BUNDLE_VIEW_STATE_KEY);
        }else {
            viewState = ViewState.DATA_LOADING;
        }

        if (viewState == ViewState.DATA_LOADING) {
            loadData();
        } else {
            getView().setCommits(commits);
        }
    }

    public void onSaveInstanceState(Bundle outState) {
        if (commits != null)
            outState.putSerializable(BUNDLE_COMMITS_KEY, new ArrayList<>(commits));

        outState.putSerializable(BUNDLE_VIEW_STATE_KEY,viewState);
    }


    private void loadData() {
        getView().showProgress();

        Subscription subscription = interactor.execute(getView().getRepoVO(),new Subscriber<List<Commit>>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {
                getView().showError(ErrorBundleFactory.createErrorBundle(e));
                viewState = ViewState.DATA_LOADED;
            }

            @Override
            public void onNext(List<Commit> commits) {
                CommitsPresenter.this.commits = commits;
                getView().setCommits(commits);
                viewState = ViewState.DATA_LOADED;
            }
        });

        addSubscription(subscription);
    }

    public enum ViewState{
        DATA_LOADING, DATA_LOADED
    }
}
