package com.samorodov.ilia.myapplication.presentation;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.samorodov.ilia.myapplication.R;
import com.samorodov.ilia.myapplication.model.vo.Repo;
import com.samorodov.ilia.myapplication.presentation.commtis.CommitsFragment;
import com.samorodov.ilia.myapplication.presentation.starting.StartingFragment;

public class MainActivity extends AppCompatActivity implements ActivityCallback {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Fragment fragment = getFragmentManager().findFragmentById(R.id.content);
        if (fragment == null) {
            getFragmentManager().beginTransaction()
                    .replace(R.id.content, new StartingFragment())
                    .commit();
        }
    }

    @Override
    public void startCommitsFragment(Repo repo) {
        addNewFragment(CommitsFragment.newInstance(repo));
    }

    @Override
    public void back() {
        onBackPressed();
    }

    public void addNewFragment(Fragment fragment) {
        getFragmentManager().beginTransaction()
                .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                .replace(R.id.content, fragment)
                .addToBackStack(null)
                .commit();
    }
}
