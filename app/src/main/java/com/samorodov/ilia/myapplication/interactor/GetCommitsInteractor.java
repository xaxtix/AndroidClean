package com.samorodov.ilia.myapplication.interactor;

import com.samorodov.ilia.myapplication.injection.dependencies.SchedulersModule;
import com.samorodov.ilia.myapplication.model.vo.Repo;
import com.samorodov.ilia.myapplication.repository.commits.CommitsDataRepository;
import com.samorodov.ilia.myapplication.model.vo.Commit;


import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import rx.Observable;
import rx.Scheduler;

public class GetCommitsInteractor extends BaseInteractor<Repo,List<Commit>> {

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
    protected Observable<List<Commit>> buildUseCaseObservable(Repo repo) {
        return repository.getCommits(repo.getAuthor(),repo.getRepo())
                .subscribeOn(job)
                .observeOn(ui)
                .unsubscribeOn(job);
    }
}
