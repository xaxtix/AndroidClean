package com.samorodov.ilia.myapplication.injections.mock;

import com.samorodov.ilia.myapplication.api.ApiInterface;
import com.samorodov.ilia.myapplication.model.dto.CommitDTO;

import java.util.ArrayList;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import rx.Observable;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import static com.samorodov.ilia.myapplication.injections.mock.Constants.*;

@Module
public class MockApiModule {


    @Provides
    @Singleton
    ApiInterface provideApiInterface(){
        ApiInterface apiInterface = mock(ApiInterface.class);

        when(apiInterface.getCommits(OWNER,REPO_TRUE)).thenReturn(Observable.create(subscriber -> {
            subscriber.onNext(new ArrayList<CommitDTO>());
        }));

        return apiInterface;
    }

}
