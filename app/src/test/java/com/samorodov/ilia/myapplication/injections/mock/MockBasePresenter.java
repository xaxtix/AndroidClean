package com.samorodov.ilia.myapplication.injections.mock;

import com.samorodov.ilia.myapplication.presentation.commtis.CommitsPresenter;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

import static org.mockito.Mockito.mock;

@Module
public class MockBasePresenter {

    @Singleton
    @Provides
    public CommitsPresenter provideCommitsPresenter(){
        CommitsPresenter commitsPresenter = mock(CommitsPresenter.class);
        return commitsPresenter;
    }
}
