package com.samorodov.ilia.myapplication.injections.component;

import com.samorodov.ilia.myapplication.injection.component.AppComponent;
import com.samorodov.ilia.myapplication.injection.dependencies.UrlModule;
import com.samorodov.ilia.myapplication.injections.InjectionsTest;
import com.samorodov.ilia.myapplication.injections.dependencies.CommitsRepositoryTestModule;
import com.samorodov.ilia.myapplication.injections.dependencies.SchedulersTestModule;
import com.samorodov.ilia.myapplication.interactor.GetCommitsInteractorTest;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(dependencies = {SchedulersTestModule.class, UrlModule.class},
        modules = {CommitsRepositoryTestModule.class})
public interface TestComponent extends AppComponent {

    void inject(GetCommitsInteractorTest getCommitsInteractorTest);
    void inject(InjectionsTest injectionsTest);
}
