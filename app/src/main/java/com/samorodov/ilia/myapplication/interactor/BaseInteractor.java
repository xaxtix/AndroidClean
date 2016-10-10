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

public abstract class BaseInteractor<Request,Response> {

    protected abstract Observable<Response> buildUseCaseObservable(Request request);

    @SuppressWarnings("unchecked")
    public Subscription execute(Request request,Subscriber<Response> subscriber) {
        return this.buildUseCaseObservable(request)
                .subscribe(subscriber);
    }

}