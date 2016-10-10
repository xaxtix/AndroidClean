package com.samorodov.ilia.myapplication.presentation.base;


import android.content.Context;

import com.samorodov.ilia.myapplication.Application;
import com.samorodov.ilia.myapplication.injection.component.AppComponent;
import com.trello.rxlifecycle.android.FragmentEvent;

import javax.inject.Inject;

import rx.Observable;
import rx.Subscription;
import rx.subscriptions.CompositeSubscription;

public abstract class BasePresenter<View> {

    View view;

    protected CompositeSubscription compositeSubscription;

    public BasePresenter() {
    }

    public void onCreate(View view){
        compositeSubscription = new CompositeSubscription();
        this.view = view;
    }

    public View getView() {
        return view;
    }

    protected void addSubscription(Subscription subscription) {
        compositeSubscription.add(subscription);
    }

    public void onStop() {
        compositeSubscription.clear();
    }


}
