package com.samorodov.ilia.myapplication.presentation.base;


import android.content.Context;

import com.samorodov.ilia.myapplication.Application;
import com.samorodov.ilia.myapplication.injection.component.AppComponent;
import com.trello.rxlifecycle.android.FragmentEvent;

import javax.inject.Inject;

import rx.Observable;

public abstract class BasePresenter<View> {

    View view;

    public BasePresenter() {
    }

    public void onCreate(View view){
        this.view = view;
    }

    public View getView() {
        return view;
    }


}
