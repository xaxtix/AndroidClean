package com.samorodov.ilia.myapplication.injections;

import com.samorodov.ilia.myapplication.BaseTest;
import com.samorodov.ilia.myapplication.injection.dependencies.UrlModule;

import org.junit.Test;

import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Provides;
import rx.Scheduler;
import rx.android.schedulers.AndroidSchedulers;

import static com.samorodov.ilia.myapplication.injection.dependencies.UrlModule.PROD;
import static com.samorodov.ilia.myapplication.injection.dependencies.UrlModule.TEST;
import static com.samorodov.ilia.myapplication.injections.dependencies.SchedulersTestModule.*;
import static junit.framework.Assert.assertEquals;

public class InjectionsTest extends BaseTest {

    @Inject
    @Named(PROD)
    String prodUrl;

    @Inject
    @Named(TEST)
    String testUrl;

    @Inject
    @Named(JOB)
    Scheduler job;

    @Inject
    @Named(UI)
    Scheduler main;

    @Override
    public void setUp() throws Exception {
        super.setUp();

        injector.inject(this);
    }

    @Test
    public void urlModuleTest() {
        assertEquals("https://api.github.com", prodUrl);
        assertEquals("https://api.test.github.com", testUrl);
    }

    @Test
    public void schedulersTest() {
        assertEquals(main,AndroidSchedulers.mainThread());
        assertEquals(main,AndroidSchedulers.mainThread());
    }
}
