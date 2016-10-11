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
import com.samorodov.ilia.myapplication.R;
import com.samorodov.ilia.myapplication.exception.ErrorBundle;
import com.samorodov.ilia.myapplication.injection.component.AppComponent;
import com.samorodov.ilia.myapplication.presentation.ActivityCallback;

import java.lang.ref.WeakReference;

import butterknife.ButterKnife;

public abstract class BaseFragment extends Fragment {

    private final static String BUNDLE_ERROR_KEY = "BUNDLE_ERROR_KEY";

    @LayoutRes
    protected abstract int getLayoutResource();

    protected abstract void inject();

    @Nullable
    protected abstract BasePresenter getPresenter();

    @Nullable
    ErrorBundle mErrorBundle;

    ActivityCallback activityCallback;

    private WeakReference<AlertDialog> mDialogRefence;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        inject();
        activityCallback = (ActivityCallback) getActivity();
    }

    @Override
    public void onStart() {
        super.onStart();
        if(getPresenter() != null){
            getPresenter().onStart();
        }
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
        View view = inflater.inflate(getLayoutResource(), container, false);
        ButterKnife.bind(this, view);

        if (savedInstanceState != null && savedInstanceState.containsKey(BUNDLE_ERROR_KEY)) {
            mErrorBundle = (ErrorBundle) savedInstanceState.getSerializable(BUNDLE_ERROR_KEY);
            showError(mErrorBundle);
        }

        if (getPresenter() != null)
            getPresenter().onCreateView(savedInstanceState);

        return view;
    }


    public AppComponent getInjector() {
        return ((Application) getActivity().getApplicationContext()).getInjector();
    }


    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        if (mDialogRefence != null && mDialogRefence.get() != null) {
            outState.putSerializable(BUNDLE_ERROR_KEY, mErrorBundle);
        }

        if (getPresenter() != null) {
            getPresenter().onSaveInstanceState(outState);
        }
    }

    public void showError(ErrorBundle e) {
        mErrorBundle = e;

        AlertDialog dialog = new AlertDialog.Builder(getActivity())
                .setTitle(e.getErrorTitle())
                .setMessage(e.getMessage())
                .setPositiveButton(R.string.ok, (dialog1, which) -> getActivityCallback().back())
                .show();

        mDialogRefence = new WeakReference<>(dialog);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (mDialogRefence != null && mDialogRefence.get() != null) {
            mDialogRefence.get().dismiss();
        }
    }

    public ActivityCallback getActivityCallback() {
        return activityCallback;
    }
}
