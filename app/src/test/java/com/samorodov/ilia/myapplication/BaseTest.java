package com.samorodov.ilia.myapplication;

import com.samorodov.ilia.myapplication.Application;
import com.samorodov.ilia.myapplication.injection.component.AppComponent;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricGradleTestRunner;
import org.robolectric.annotation.Config;

@RunWith(RobolectricGradleTestRunner.class)
@Config(application = Application.class,
        constants = BuildConfig.class,
        sdk = 21)
@Ignore
public class BaseTest {

    public AppComponent injector;
    @Before
    public void setUp() throws Exception {
        injector =  Application.getInjector();
    }

}
