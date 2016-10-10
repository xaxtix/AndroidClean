package com.samorodov.ilia.myapplication.presentation.base;

import android.app.AlertDialog;
import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.samorodov.ilia.myapplication.Application;
import com.samorodov.ilia.myapplication.exception.DefaultErrorBundle;
import com.samorodov.ilia.myapplication.exception.ErrorBundle;
import com.samorodov.ilia.myapplication.injection.component.AppComponent;
import com.samorodov.ilia.myapplication.presentation.ActivityCallback;
import com.trello.rxlifecycle.LifecycleProvider;
import com.trello.rxlifecycle.components.RxFragment;

import javax.inject.Inject;

import butterknife.ButterKnife;

public abstract class BaseFragment extends Fragment {

    @LayoutRes
    protected abstract int getLayoutResource();

    protected abstract void inject();

    @Nullable
    protected abstract BasePresenter getPresenter();

    ActivityCallback activityCallback;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        inject();
        activityCallback = (ActivityCallback) getActivity();
    }

    @Override
    public void onStop() {
        super.onStop();
        if (getPresenter() != null) {
            getPresenter().onStop();
        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(getLayoutResource(),container,false);
        ButterKnife.bind(this,view);

        return view;
    }

    public AppComponent getInjector(){
        return ((Application) getActivity().getApplicationContext()).getInjector();
    }

    public void showError(ErrorBundle e){
        new AlertDialog.Builder(getActivity())
                .setTitle(e.getErrorTitle())
                .setMessage(e.getMessage())
                .show();
    }

    public ActivityCallback getActivityCallback() {
        return activityCallback;
    }
}
