package com.samorodov.ilia.myapplication.presentation.commtis;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.samorodov.ilia.myapplication.R;
import com.samorodov.ilia.myapplication.model.Commit;

import java.util.List;

public class CommitsAdapter extends BaseAdapter {

    final List<Commit> commits;

    final Context context;


    public CommitsAdapter(List<Commit> commits, Context context) {
        this.commits = commits;
        this.context = context;
    }

    @Override
    public int getCount() {
        return commits.size();
    }

    @Override
    public Object getItem(int i) {
        return i;
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View commitView = LayoutInflater.from(context).inflate(R.layout.v_commit, viewGroup, false);
        ((TextView) commitView.findViewById(R.id.name)).setText(commits.get(i).getAuthor());
        ((TextView) commitView.findViewById(R.id.message)).setText(commits.get(i).getMessage());

        return commitView;
    }
}