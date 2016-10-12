package com.samorodov.ilia.myapplication.injections.module;

import com.samorodov.ilia.myapplication.api.ApiInterface;
import com.samorodov.ilia.myapplication.repository.commits.CommitsDataRepository;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class CommitsRepositoryModule {

    @Provides
    @Singleton
    public CommitsDataRepository provideCommitsDataRepository(ApiInterface apiInterface){
        return new CommitsDataRepository(apiInterface,null);
    }
}
