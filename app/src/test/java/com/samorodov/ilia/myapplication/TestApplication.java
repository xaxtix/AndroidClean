package com.samorodov.ilia.myapplication;

import com.samorodov.ilia.myapplication.injection.component.AppComponent;
import com.samorodov.ilia.myapplication.injections.component.DaggerTestComponent;

public class TestApplication extends Application {

    @Override
    public AppComponent BuildInjector() {
        return DaggerTestComponent.builder()
                .build();
    }
}
