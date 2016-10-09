package com.samorodov.ilia.myapplication.presentation.commtis;


import com.samorodov.ilia.myapplication.interactor.GetCommitsInteractor;
import com.samorodov.ilia.myapplication.model.Commit;
import com.samorodov.ilia.myapplication.presentation.base.BasePresenter;
import com.trello.rxlifecycle.android.FragmentEvent;

import java.util.List;

import javax.inject.Inject;

import rx.Observable;
import rx.Subscriber;


public class CommitsPresenter extends BasePresenter<CommitsView> {

    GetCommitsInteractor interactor;

    @Inject
    public CommitsPresenter(GetCommitsInteractor interactor){
        this.interactor = interactor;
    }

    @Override
    public void onCreate(CommitsView commitsView) {
        super.onCreate(commitsView);
    }

    public void onStart() {
        interactor.execute(new Subscriber<List<Commit>>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {
                getView().showError(e);
            }

            @Override
            public void onNext(List<Commit> commits) {
                getView().setCommits(commits);
            }
        });
    }

    public void onDestroy() {
        interactor.unsubscribe();
    }
}
