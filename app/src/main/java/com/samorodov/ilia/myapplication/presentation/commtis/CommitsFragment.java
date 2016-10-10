package com.samorodov.ilia.myapplication.presentation.commtis;

import android.app.Fragment;
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
import com.samorodov.ilia.myapplication.exception.DefaultErrorBundle;
import com.samorodov.ilia.myapplication.exception.ErrorBundle;
import com.samorodov.ilia.myapplication.model.Commit;
import com.samorodov.ilia.myapplication.model.Repository;
import com.samorodov.ilia.myapplication.model.dto.CommitDTO;
import com.samorodov.ilia.myapplication.presentation.base.BaseFragment;
import com.samorodov.ilia.myapplication.presentation.base.BasePresenter;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import rx.Subscriber;

public class CommitsFragment extends BaseFragment implements CommitsView {

    private static final String BUNDLE_REPO_KEY = "BUNDLE_REPO_KEY";

    @Inject
    CommitsPresenter mCommitsPresenter;

    @BindView(R.id.list_view)
    ListView mListView;

    public static CommitsFragment newInstance(Repository repo) {
        CommitsFragment fragment = new CommitsFragment();

        Bundle bundle = new Bundle();
        bundle.putSerializable(BUNDLE_REPO_KEY,repo);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public Repository getRepoVO() {
        return (Repository) getArguments().getSerializable(BUNDLE_REPO_KEY);
    }

    @Override
    protected int getLayoutResource() {
        return R.layout.f_commits;
    }

    @Override
    protected void inject() {
        getInjector().inject(this);
    }

    @Nullable
    @Override
    protected BasePresenter getPresenter() {
        return mCommitsPresenter;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mCommitsPresenter.onCreate(this);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = super.onCreateView(inflater, container, savedInstanceState);
        mCommitsPresenter.onCreateView(savedInstanceState);
        return view;
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        mCommitsPresenter.onSaveInstanceState(outState);
    }

    @Override
    public void showError(ErrorBundle e) {
        super.showError(e);
    }


    @Override
    public void setCommits(final List<Commit> commits) {
        mListView.setAdapter(new CommitsAdapter(commits, getActivity()));
    }


}
