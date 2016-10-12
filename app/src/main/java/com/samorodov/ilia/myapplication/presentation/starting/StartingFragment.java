package com.samorodov.ilia.myapplication.presentation.starting;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;

import com.samorodov.ilia.myapplication.R;
import com.samorodov.ilia.myapplication.model.vo.Repo;
import com.samorodov.ilia.myapplication.presentation.base.BaseFragment;
import com.samorodov.ilia.myapplication.presentation.base.BasePresenter;

import javax.inject.Inject;

import butterknife.BindView;

public class StartingFragment extends BaseFragment implements StartingView{

    @BindView(R.id.owner_et)
    EditText mOwnerEditText;

    @BindView(R.id.repo_et)
    EditText mRepoEditText;

    @BindView(R.id.next)
    Button mNextButton;

    @Inject
    StartingPresenter mPresenter;

    @Override
    protected int getLayoutResource() {
        return R.layout.f_starting;
    }

    @Override
    protected void inject() {
        getInjector().inject(this);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPresenter.onCreate(this);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mNextButton.setOnClickListener(v -> {
            String owner = mOwnerEditText.getText().toString();
            String repo = mRepoEditText.getText().toString();
            mPresenter.onNextClick(owner,repo);
        });

        mRepoEditText.setOnEditorActionListener((v, actionId, event) -> {
            if (actionId == EditorInfo.IME_ACTION_DONE ||
                    actionId == EditorInfo.IME_ACTION_NEXT ||
                    actionId == EditorInfo.IME_ACTION_GO ||
                    (event != null && event.getKeyCode() == KeyEvent.KEYCODE_ENTER)) {
                mNextButton.callOnClick();
                return true;
            } else {
                return false;
            }
        });
    }

    @Nullable
    @Override
    protected BasePresenter getPresenter() {
        return mPresenter;
    }

    @Override
    public void startCommitsFragment(Repo repo) {
        getActivityCallback().startCommitsFragment(repo);
    }
}
