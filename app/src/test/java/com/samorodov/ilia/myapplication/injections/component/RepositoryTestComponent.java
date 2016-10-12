package com.samorodov.ilia.myapplication.injections.component;


import com.samorodov.ilia.myapplication.injection.component.AppComponent;
import com.samorodov.ilia.myapplication.injection.dependencies.UrlModule;
import com.samorodov.ilia.myapplication.injections.InjectionsTest;
import com.samorodov.ilia.myapplication.injections.dependencies.SchedulersTestModule;
import com.samorodov.ilia.myapplication.injections.mock.MockApiModule;
import com.samorodov.ilia.myapplication.injections.mock.MockCommitsRepositoryModule;
import com.samorodov.ilia.myapplication.injections.module.CommitsRepositoryModule;
import com.samorodov.ilia.myapplication.interactor.GetCommitsInteractorTest;
import com.samorodov.ilia.myapplication.repository.CommitsRepositoryTest;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(dependencies = {SchedulersTestModule.class, UrlModule.class},
        modules = {CommitsRepositoryModule.class, MockApiModule.class})
public interface RepositoryTestComponent extends AppComponent {

    void inject(GetCommitsInteractorTest getCommitsInteractorTest);
    void inject(InjectionsTest injectionsTest);

    void inject(CommitsRepositoryTest commitsRepositoryTest);
}