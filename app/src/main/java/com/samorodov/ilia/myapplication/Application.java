package com.samorodov.ilia.myapplication;

import com.samorodov.ilia.myapplication.injection.component.AppComponent;
import com.samorodov.ilia.myapplication.injection.component.DaggerAppComponent;
import com.samorodov.ilia.myapplication.injection.module.ApiModule;
import com.samorodov.ilia.myapplication.injection.dependencies.ApplicationModule;
import com.squareup.leakcanary.LeakCanary;

public class Application extends android.app.Application {

    AppComponent mInjector;

    @Override
    public void onCreate() {
        super.onCreate();

        if (LeakCanary.isInAnalyzerProcess(this)) {
            // This process is dedicated to LeakCanary for heap analysis.
            // You should not init your app in this process.
            return;
        }
        LeakCanary.install(this);

        mInjector = DaggerAppComponent.builder()
                .apiModule(new ApiModule())
                .applicationModule(new ApplicationModule(this))
                .build();
    }

    public AppComponent getInjector() {
        return mInjector;
    }
}
