package com.samorodov.ilia.myapplication.presentation;

import com.samorodov.ilia.myapplication.BaseTest;
import com.samorodov.ilia.myapplication.presentation.base.BasePresenter;
import com.samorodov.ilia.myapplication.presentation.commtis.CommitsPresenter;
import com.samorodov.ilia.myapplication.presentation.commtis.CommitsView;

import org.junit.Before;
import org.junit.Test;

import rx.observers.TestSubscriber;

import static org.mockito.Mockito.mock;
import static org.junit.Assert.*;

public class BasePresenterTest extends BaseTest {

    BasePresenter basePresenter;
    @Override
    @Before
    public void setUp() throws Exception {
        super.setUp();

        CommitsView commitsView = mock(CommitsView.class);
        basePresenter = new CommitsPresenter(null);

        basePresenter.onCreate(commitsView);

    }

    @Test
    public void viewPresenterTest(){
        assertNotNull(basePresenter.getView());
    }

    @Test
    public void subscriptionTest(){
        basePresenter.addSubscription(new TestSubscriber<>());
        assertTrue(basePresenter.getSubscriptions().hasSubscriptions());
    }

    @Test
    public void onStopTest(){
        basePresenter.addSubscription(new TestSubscriber<>());

        basePresenter.onStop();
        assertFalse(basePresenter.getSubscriptions().hasSubscriptions());
    }
}
