package com.samorodov.ilia.myapplication.interactor;

import android.support.annotation.Nullable;

import rx.Subscriber;

public class SubscriberAdapter<T> extends Subscriber<T> {

    @Nullable
    OnErrorListener errorListener;

    @Nullable
    OnNextListener<T> nextListener;

    public SubscriberAdapter(@Nullable OnErrorListener errorListener,
                             @Nullable OnNextListener<T> nextListener){
        this.errorListener = errorListener;
        this.nextListener = nextListener;
    }

    @Override
    public void onCompleted() {

    }

    @Override
    public void onError(Throwable e) {
        if (errorListener != null) {
            errorListener.onError(e);
        }
    }

    @Override
    public void onNext(T t) {
        if (nextListener != null) {
            nextListener.onNext(t);
        }
    }

    public interface OnErrorListener {
        void onError(Throwable e);
    }

    public interface OnNextListener<T> {
        void onNext(T t);
    }
}
