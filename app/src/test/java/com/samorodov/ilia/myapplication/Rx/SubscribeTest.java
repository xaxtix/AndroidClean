package com.samorodov.ilia.myapplication.Rx;

import org.junit.Test;

import rx.Observable;
import rx.Subscriber;
import rx.Subscription;
import rx.schedulers.Schedulers;

import static junit.framework.Assert.assertEquals;


public class SubscribeTest {

    @Test
    public void sub() {


        final Thread cur = Thread.currentThread();


        Observable<String> observable = Observable.create(new Observable.OnSubscribe<String>() {
            @Override
            public void call(Subscriber<? super String> subscriber) {

                System.out.println("processed");

                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                subscriber.onNext("Hello Wrold");
                subscriber.onCompleted();

            }
        }).cache();

        final String[] str = new String[1];

        Subscriber subscriber = new Subscriber<String>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(String s) {
                System.out.print(s);
                str[0] = s;
                cur.notify();
            }
        };

        Subscription subscription = observable.observeOn(Schedulers.newThread())
                .subscribe(subscriber);

        subscription.unsubscribe();

        observable.observeOn(Schedulers.newThread())
                .subscribe(new Subscriber<String>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(String s) {
                        System.out.print(s);
                        str[0] = s;
                        cur.notify();
                    }
                });

        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }




        assertEquals(str[0], "Hello Wrold");

    }
}
