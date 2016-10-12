package com.samorodov.ilia.myapplication.presentation.base;

import android.os.Bundle;
import android.view.LayoutInflater;

import com.samorodov.ilia.myapplication.BaseTest;
import com.samorodov.ilia.myapplication.injections.component.DaggerFragmentComponentTest;
import com.samorodov.ilia.myapplication.injections.component.FragmentComponentTest;
import com.samorodov.ilia.myapplication.injections.mock.MockBasePresenter;
import com.samorodov.ilia.myapplication.presentation.commtis.CommitsFragment;
import com.samorodov.ilia.myapplication.presentation.commtis.CommitsPresenter;

import org.junit.Before;
import org.junit.Test;

import javax.inject.Inject;

import static junit.framework.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class BaseFragmentTest extends BaseTest {

    BaseFragment baseFragment;

    @Inject
    CommitsPresenter presenter;

    @Before
    @Override
    public void setUp() throws Exception {
        super.setUp();

        baseFragment = new CommitsFragment();

        FragmentComponentTest fragmentComponentTest = DaggerFragmentComponentTest
                .builder()
                .mockBasePresenter(new MockBasePresenter())
                .build();

        fragmentComponentTest.inject((CommitsFragment)baseFragment);
        fragmentComponentTest.inject(this);

    }

    @Test
    public void injectionsTest(){
        assertNotNull(baseFragment);
        assertNotNull(presenter);
    }

    @Test
    public void onStopTest(){
        baseFragment.onStop();
        verify(presenter).onStop();
    }

    @Test
    public void onSaveInstanceState(){
        Bundle bundle = new Bundle();
        baseFragment.onSaveInstanceState(bundle);
        verify(presenter).onSaveInstanceState(bundle);
    }
}
