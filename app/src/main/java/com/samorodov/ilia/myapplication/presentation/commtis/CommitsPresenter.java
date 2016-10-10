package com.samorodov.ilia.myapplication.presentation.commtis;


import android.os.Bundle;

import com.samorodov.ilia.myapplication.interactor.GetCommitsInteractor;
import com.samorodov.ilia.myapplication.model.Commit;
import com.samorodov.ilia.myapplication.presentation.base.BasePresenter;
import com.trello.rxlifecycle.android.FragmentEvent;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import rx.Observable;
import rx.Subscriber;
import rx.Subscription;


public class CommitsPresenter extends BasePresenter<CommitsView> {

    private static final String BUNDLE_COMMITS_KEY = "BUNDLE_COMMITS_KEY";
    GetCommitsInteractor interactor;

    List<Commit> commits;

    @Inject
    public CommitsPresenter(GetCommitsInteractor interactor) {
        this.interactor = interactor;
    }

    @Override
    public void onCreate(CommitsView commitsView) {
        super.onCreate(commitsView);
    }

    public void onCreateView(Bundle savedInstanceState) {
        if (savedInstanceState != null) {
            commits = (List<Commit>) savedInstanceState.getSerializable(BUNDLE_COMMITS_KEY);
        }

        if (commits == null) {
            loadData();
        } else {
            getView().setCommits(commits);
        }
    }

    public void onSaveInstanceState(Bundle outState) {
        if (commits != null)
            outState.putSerializable(BUNDLE_COMMITS_KEY, new ArrayList<>(commits));
    }


    private void loadData() {
        Subscription subscription = interactor.execute(new Subscriber<List<Commit>>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {
                getView().showError(e);
            }

            @Override
            public void onNext(List<Commit> commits) {
                CommitsPresenter.this.commits = commits;
                getView().setCommits(commits);
            }
        });

        addSubscription(subscription);
    }

}
