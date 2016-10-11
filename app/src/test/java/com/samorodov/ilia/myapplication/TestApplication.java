package com.samorodov.ilia.myapplication;

import com.samorodov.ilia.myapplication.injection.component.AppComponent;
import com.samorodov.ilia.myapplication.injection.component.DaggerAppComponent;

public class TestApplication extends Application {

    @Override
    public AppComponent BuildInjector() {
        return DaggerAppComponent.builder().build();
    }
}
