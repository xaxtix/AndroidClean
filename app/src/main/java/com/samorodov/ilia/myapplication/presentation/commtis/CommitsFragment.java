package com.samorodov.ilia.myapplication.presentation.commtis;

import android.content.res.Configuration;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.samorodov.ilia.myapplication.R;
import com.samorodov.ilia.myapplication.api.ApiInterface;
import com.samorodov.ilia.myapplication.model.Commit;
import com.samorodov.ilia.myapplication.model.dto.CommitDTO;
import com.samorodov.ilia.myapplication.presentation.base.BaseFragment;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import rx.Subscriber;

public class CommitsFragment extends BaseFragment implements CommitsView {

    @Inject
    CommitsPresenter mCommitsPresenter;

    @BindView(R.id.list_view)
    ListView mListView;

    @Override
    protected int getLayoutResource() {
        return R.layout.f_commits;
    }

    @Override
    protected void inject() {
        getInjector().inject(this);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mCommitsPresenter.onCreate(this);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mCommitsPresenter.onStart();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
         if(isRemoving() || getActivity().isFinishing()) {
             mCommitsPresenter.onDestroy();
         }
    }

    @Override
    public void setRetainInstance(boolean retain) {
        super.setRetainInstance(retain);
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
    }

    @Override
    public void showError(Throwable e) {
        super.showError(e);
    }

    @Override
    public void setCommits(final List<Commit> commits) {
        mListView.setAdapter(new CommitsAdapter(commits, getActivity()));
    }

}
