package com.samorodov.ilia.myapplication.presentation;

import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.samorodov.ilia.myapplication.R;
import com.samorodov.ilia.myapplication.presentation.commtis.CommitsFragment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        android.app.Fragment fragment = getFragmentManager().findFragmentById(R.id.content);
        if (fragment == null) {
            getFragmentManager().beginTransaction()
                    .replace(R.id.content, new CommitsFragment())
                    .commit();
        }
    }
}
