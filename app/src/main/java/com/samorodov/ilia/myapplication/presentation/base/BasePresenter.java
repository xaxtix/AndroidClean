package com.samorodov.ilia.myapplication.presentation.base;


import android.os.Bundle;
import android.support.annotation.Nullable;

import rx.Subscription;
import rx.subscriptions.CompositeSubscription;

public abstract class BasePresenter<View> {

    View view;

    protected CompositeSubscription compositeSubscription = new CompositeSubscription();

    public CompositeSubscription getSubscriptions() {
        return compositeSubscription;
    }

    public View getView() {
        return view;
    }

    public void addSubscription(@Nullable Subscription subscription) {
        if (subscription != null)
            compositeSubscription.add(subscription);
    }

    public void onCreate(View view) {
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
