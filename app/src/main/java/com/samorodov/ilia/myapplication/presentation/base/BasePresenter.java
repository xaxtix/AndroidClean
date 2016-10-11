package com.samorodov.ilia.myapplication.presentation.base;


import android.content.Context;
import android.os.Bundle;

import com.samorodov.ilia.myapplication.Application;
import com.samorodov.ilia.myapplication.injection.component.AppComponent;
import com.samorodov.ilia.myapplication.model.Commit;
import com.samorodov.ilia.myapplication.presentation.commtis.CommitsPresenter;
import com.trello.rxlifecycle.android.FragmentEvent;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import rx.Observable;
import rx.Subscription;
import rx.subscriptions.CompositeSubscription;

public abstract class BasePresenter<View> {

    View view;

    protected CompositeSubscription compositeSubscription;

    public View getView() {
        return view;
    }

    protected void addSubscription(Subscription subscription) {
        compositeSubscription.add(subscription);
    }

    public void onCreate(View view) {
        compositeSubscription = new CompositeSubscription();
        this.view = view;
    }

    public void onStart() {

    }

    public void onStop() {
        compositeSubscription.clear();
    }

    public void onCreateView(Bundle savedInstanceState) {
    }

    public void onSaveInstanceState(Bundle outState) {
    }


}
