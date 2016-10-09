package com.samorodov.ilia.myapplication.injection.component;

import com.samorodov.ilia.myapplication.injection.dependencies.ApplicationModule;
import com.samorodov.ilia.myapplication.injection.dependencies.SchedulersModule;
import com.samorodov.ilia.myapplication.injection.dependencies.UrlModule;
import com.samorodov.ilia.myapplication.injection.module.ApiModule;
import com.samorodov.ilia.myapplication.injection.module.InterceptorModule;
import com.samorodov.ilia.myapplication.presentation.base.BaseFragment;
import com.samorodov.ilia.myapplication.presentation.commtis.CommitsFragment;
import com.samorodov.ilia.myapplication.presentation.commtis.CommitsPresenter;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {ApiModule.class},
        dependencies = {
                ApplicationModule.class,
                UrlModule.class,
                SchedulersModule.class,
                InterceptorModule.class})

public interface AppComponent {
    void inject(CommitsFragment fragment);
}
