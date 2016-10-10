package com.samorodov.ilia.myapplication.interactor;

import com.samorodov.ilia.myapplication.injection.dependencies.SchedulersModule;
import com.samorodov.ilia.myapplication.repository.commits.CommitsDataRepository;
import com.samorodov.ilia.myapplication.model.Commit;


import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import rx.Observable;
import rx.Scheduler;
import rx.functions.Func1;

public class GetCommitsInteractor extends BaseInteractor<List<Commit>> {

    CommitsDataRepository repository;

    Scheduler job;
    Scheduler ui;

    @Inject
    public GetCommitsInteractor(@Named(SchedulersModule.JOB) Scheduler jobScheduler,
                                @Named(SchedulersModule.UI) Scheduler uiScheduler,
                                CommitsDataRepository commitsDataRepository) {
        job = jobScheduler;
        ui = uiScheduler;
        repository = commitsDataRepository;
    }




    @Override
    protected Observable<List<Commit>> buildUseCaseObservable() {
        return repository.getCommits()
                .subscribeOn(job)
                .observeOn(ui)
                .unsubscribeOn(job);
    }
}
