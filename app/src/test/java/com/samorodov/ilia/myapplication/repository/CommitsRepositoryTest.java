package com.samorodov.ilia.myapplication.repository;

import com.samorodov.ilia.myapplication.BaseTest;
import com.samorodov.ilia.myapplication.api.ApiInterface;
import com.samorodov.ilia.myapplication.injections.component.DaggerRepositoryTestComponent;
import com.samorodov.ilia.myapplication.injections.mock.MockApiModule;
import com.samorodov.ilia.myapplication.repository.commits.CommitsDataRepository;

import org.junit.Before;
import org.junit.Test;

import javax.inject.Inject;

import static com.samorodov.ilia.myapplication.injections.mock.Constants.OWNER;
import static com.samorodov.ilia.myapplication.injections.mock.Constants.REPO_TRUE;
import static junit.framework.Assert.assertNotNull;
import static org.mockito.Mockito.verify;

public class CommitsRepositoryTest extends BaseTest {

    @Inject
    ApiInterface apiInterface;

    @Inject
    CommitsDataRepository repository;

    @Before
    @Override
    public void setUp() throws Exception {

        DaggerRepositoryTestComponent
                .builder()
                .mockApiModule(new MockApiModule())
                .build()
                .inject(this);

    }

    @Test
    public void injectionsTest(){
        assertNotNull(apiInterface);
        assertNotNull(repository);
    }

    @Test
    public void getCommitsTest(){
        repository.getCommits(OWNER,REPO_TRUE);
        verify(apiInterface).getCommits(OWNER,REPO_TRUE);
    }


}
