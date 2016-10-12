package com.samorodov.ilia.myapplication.injections.component;


import com.samorodov.ilia.myapplication.injection.component.AppComponent;
import com.samorodov.ilia.myapplication.injections.mock.MockBasePresenter;
import com.samorodov.ilia.myapplication.presentation.base.BaseFragmentTest;
import com.samorodov.ilia.myapplication.presentation.commtis.CommitsFragment;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {MockBasePresenter.class})
public interface FragmentComponentTest extends AppComponent {

    void inject(BaseFragmentTest baseFragmentTest);

    void inject(CommitsFragment commitsFragment);
}