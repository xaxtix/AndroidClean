package com.samorodov.ilia.myapplication.presentation.base;


import android.os.Bundle;

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
