package com.samorodov.ilia.myapplication.interactor;

import com.samorodov.ilia.myapplication.BaseTest;
import com.samorodov.ilia.myapplication.injections.component.DaggerTestComponent;
import com.samorodov.ilia.myapplication.injections.mock.MockCommitsRepositoryModule;
import com.samorodov.ilia.myapplication.model.vo.Repo;
import com.samorodov.ilia.myapplication.repository.commits.CommitsDataRepository;

import org.junit.Before;
import org.junit.Test;

import javax.inject.Inject;

import static junit.framework.Assert.*;
import static org.mockito.Mockito.verify;
import static com.samorodov.ilia.myapplication.injections.mock.Constants.*;

public class GetCommitsInteractorTest extends BaseTest {

    @Inject
    GetCommitsInteractor interactor;

    @Inject
    CommitsDataRepository repository;

    @Override
    @Before
    public void setUp() throws Exception {
        super.setUp();

        DaggerTestComponent.builder()
                .mockCommitsRepositoryModule(new MockCommitsRepositoryModule())
                .build()
                .inject(this);
    }

    @Test
    public void injectTest(){
        assertNotNull(interactor);
    }

    @Test
    public void executeTrueTest(){
        interactor.execute(new Repo(OWNER,REPO_TRUE),new SubscriberAdapter<>(null, commits ->
                assertEquals(commits.size(),2)));
        verify(repository).getCommits(OWNER,REPO_TRUE);

    }

    @Test
    public void executeFailTest(){
        interactor.execute(new Repo(OWNER,REPO_FAIL),new SubscriberAdapter<>(e ->
                assertEquals(e.getMessage(),TEST_EXCEPTION), null));
        verify(repository).getCommits(OWNER,REPO_FAIL);
    }
}
