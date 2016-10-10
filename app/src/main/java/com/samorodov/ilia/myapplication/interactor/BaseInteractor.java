package com.samorodov.ilia.myapplication.interactor;

import com.trello.rxlifecycle.LifecycleTransformer;
import com.trello.rxlifecycle.android.FragmentEvent;
import com.trello.rxlifecycle.android.RxLifecycleAndroid;

import rx.Observable;
import rx.Subscriber;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func1;
import rx.schedulers.Schedulers;
import rx.subscriptions.Subscriptions;

public abstract class BaseInteractor<T> {

    protected abstract Observable<T> buildUseCaseObservable();

    @SuppressWarnings("unchecked")
    public Subscription execute(Subscriber<T> subscriber) {
        return this.buildUseCaseObservable()
                .subscribe(subscriber);
    }

}