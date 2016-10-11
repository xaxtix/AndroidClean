package com.samorodov.ilia.myapplication;

import com.samorodov.ilia.myapplication.injection.component.AppComponent;
import com.samorodov.ilia.myapplication.injection.component.DaggerAppComponent;
import com.samorodov.ilia.myapplication.injections.component.DaggerTestComponent;
import com.samorodov.ilia.myapplication.injections.dependencies.CommitsRepositoryTestModule;

public class TestApplication extends Application {

    @Override
    public AppComponent BuildInjector() {
        return DaggerTestComponent.builder()
                .commitsRepositoryTestModule(new CommitsRepositoryTestModule())
                .build();
    }
}
