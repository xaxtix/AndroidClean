package com.samorodov.ilia.myapplication.injections.dependencies;

import com.samorodov.ilia.myapplication.model.Commit;
import com.samorodov.ilia.myapplication.repository.commits.CommitsDataRepository;
import com.samorodov.ilia.myapplication.repository.commits.CommitsRepository;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import rx.Observable;
import rx.Subscriber;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@Module
public class CommitsRepositoryTestModule {

    public final static String OWNER = "OWNER";

    public final static String REPO_TRUE = "kek";
    public final static String REPO_FAIL = "lol";

    public final static String TEST_EXCEPTION = "test exception";

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
