package com.samorodov.ilia.myapplication.presentation.commtis;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;

import com.samorodov.ilia.myapplication.R;
import com.samorodov.ilia.myapplication.exception.ErrorBundle;
import com.samorodov.ilia.myapplication.model.vo.Commit;
import com.samorodov.ilia.myapplication.model.vo.Repo;
import com.samorodov.ilia.myapplication.presentation.base.BaseFragment;
import com.samorodov.ilia.myapplication.presentation.base.BasePresenter;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;

public class CommitsFragment extends BaseFragment implements CommitsView {

    private static final String BUNDLE_REPO_KEY = "BUNDLE_REPO_KEY";

    @Inject
    CommitsPresenter mCommitsPresenter;

    @BindView(R.id.recycler_view)
    RecyclerView mRecycler;

    @BindView(R.id.progressBar)
    ProgressBar mProgressBar;

    public static CommitsFragment newInstance(Repo repo) {
        CommitsFragment fragment = new CommitsFragment();

        Bundle bundle = new Bundle();
        bundle.putSerializable(BUNDLE_REPO_KEY, repo);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public Repo getRepoVO() {
        return (Repo) getArguments().getSerializable(BUNDLE_REPO_KEY);
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

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mRecycler.setLayoutManager(new LinearLayoutManager(getActivity()));
    }

    @Override
    public void showError(ErrorBundle e) {
        super.showError(e);
    }

    @Override
    public void showProgress() {
        mProgressBar.setVisibility(View.VISIBLE);
        mRecycler.setVisibility(View.GONE);
    }


    @Override
    public void setCommits(final List<Commit> commits) {
        mProgressBar.setVisibility(View.GONE);
        mRecycler.setVisibility(View.VISIBLE);

        mRecycler.setAdapter(new CommitsAdapter(commits, getActivity()));
    }

}
