package com.samorodov.ilia.myapplication.interactor;

import com.samorodov.ilia.myapplication.BaseTest;
import com.samorodov.ilia.myapplication.injections.dependencies.CommitsRepositoryTestModule;
import com.samorodov.ilia.myapplication.model.Commit;
import com.samorodov.ilia.myapplication.model.Repository;
import com.samorodov.ilia.myapplication.repository.commits.CommitsDataRepository;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import javax.inject.Inject;

import static junit.framework.Assert.*;
import static org.mockito.Mockito.verify;
import static com.samorodov.ilia.myapplication.injections.dependencies.CommitsRepositoryTestModule.*;

public class GetCommitsInteractorTest extends BaseTest {

    @Inject
    GetCommitsInteractor interactor;

    @Inject
    CommitsDataRepository repository;

    @Override
    @Before
    public void setUp() throws Exception {
        super.setUp();
        injector.inject(this);
    }

    @Test
    public void injectTest(){
        assertNotNull(interactor);
    }

    @Test
    public void executeTrueTest(){
        interactor.execute(new Repository(OWNER,REPO_TRUE),new SubscriberAdapter<>(null, commits ->
                assertEquals(commits.size(),2)));
        verify(repository).getCommits(OWNER,REPO_TRUE);

    }

    @Test
    public void executeFailTest(){
        interactor.execute(new Repository(OWNER,REPO_FAIL),new SubscriberAdapter<>(e ->
                assertEquals(e.getMessage(),TEST_EXCEPTION), null));
        verify(repository).getCommits(OWNER,REPO_FAIL);
    }
}
