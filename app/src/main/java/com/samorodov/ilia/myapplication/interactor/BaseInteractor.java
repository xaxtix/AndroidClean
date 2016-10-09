package com.samorodov.ilia.myapplication.interactor;

import com.trello.rxlifecycle.LifecycleTransformer;
import com.trello.rxlifecycle.android.FragmentEvent;
import com.trello.rxlifecycle.android.RxLifecycleAndroid;

import rx.Observable;
import rx.Subscriber;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import rx.subscriptions.Subscriptions;

public abstract class BaseInteractor<T> {

    private Subscription subscription = Subscriptions.empty();

    protected abstract Observable<T> buildUseCaseObservable();

    @SuppressWarnings("unchecked")
    public void execute(Subscriber<T> subscriber) {
        subscription = this.buildUseCaseObservable()
                .cache()
                .subscribe(subscriber);
    }

    public void unsubscribe() {
        if (!subscription.isUnsubscribed()) {
            subscription.unsubscribe();
        }
    }
}