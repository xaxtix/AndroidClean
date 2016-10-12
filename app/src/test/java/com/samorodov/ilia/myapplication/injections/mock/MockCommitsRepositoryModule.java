package com.samorodov.ilia.myapplication.injections.mock;

import com.samorodov.ilia.myapplication.model.vo.Commit;
import com.samorodov.ilia.myapplication.repository.commits.CommitsDataRepository;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import rx.Observable;

import static com.samorodov.ilia.myapplication.injections.mock.Constants.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@Module
public class MockCommitsRepositoryModule {



    @Provides
    @Singleton
    CommitsDataRepository provideCommitsrRepository(){
        CommitsDataRepository repository = mock(CommitsDataRepository.class);

        when(repository.getCommits(OWNER,REPO_TRUE)).thenReturn(Observable.create(subscriber -> {

            List<Commit> commits = new ArrayList<>();
            commits.add(0,new Commit("Илья","КеК"));
            commits.add(1,new Commit("Илья","КеК"));

            subscriber.onNext(new ArrayList<Commit>());
        }));

        when(repository.getCommits(OWNER,REPO_FAIL)).thenReturn(Observable.create(subscriber -> {
            subscriber.onError(new Exception(TEST_EXCEPTION));
        }));

        return repository;
    }


}
