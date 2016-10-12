package com.samorodov.ilia.myapplication.repository.commits;

import android.support.annotation.Nullable;

import com.samorodov.ilia.myapplication.api.ApiInterface;
import com.samorodov.ilia.myapplication.model.vo.Commit;
import com.samorodov.ilia.myapplication.model.maper.CommitsMapper;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import rx.Observable;

@Singleton
public class CommitsDataRepository implements CommitsRepository {

    ApiInterface mApiInterface;

    @Nullable
    CommitsMapper mMapper;

    @Inject
    public CommitsDataRepository(ApiInterface apiInterface, CommitsMapper mapper) {
        mApiInterface = apiInterface;
        mMapper = mapper;
    }

    @Override
    public Observable<List<Commit>> getCommits(String owner, String repo) {
        Observable observable = mApiInterface.getCommits(owner, repo);
        if (mMapper != null) observable.map(mMapper);
        return observable;
    }
}
