package com.samorodov.ilia.myapplication.presentation;

import com.samorodov.ilia.myapplication.BaseTest;
import com.samorodov.ilia.myapplication.interactor.GetCommitsInteractor;
import com.samorodov.ilia.myapplication.interactor.SubscriberAdapter;
import com.samorodov.ilia.myapplication.presentation.base.BasePresenter;
import com.samorodov.ilia.myapplication.presentation.commtis.CommitsPresenter;
import com.samorodov.ilia.myapplication.presentation.commtis.CommitsView;

import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.verify;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class CommitsPresenterTest extends BaseTest {


    CommitsPresenter presenter;

    CommitsView commitsView;
    GetCommitsInteractor interactor;

    @Override
    @Before
    public void setUp() throws Exception {
        super.setUp();

        commitsView = mock(CommitsView.class);
        interactor = mock(GetCommitsInteractor.class);

        presenter = new CommitsPresenter(interactor);

        presenter.onCreate(commitsView);
    }

    @Test
    public void loadDataTest() {
        presenter.onCreateView(null);

        verify(commitsView).showProgress();
    }

    @Test
    public void showDataTest() {
        presenter.getView().setCommits(null);
        verify(commitsView).setCommits(null);
    }

}
