package com.samorodov.ilia.myapplication.presentation.commtis;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.samorodov.ilia.myapplication.R;
import com.samorodov.ilia.myapplication.model.Commit;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class CommitsAdapter extends RecyclerView.Adapter<CommitsAdapter.ViewHolder> {

    @Nullable
    final List<Commit> commits;

    final Context context;


    public CommitsAdapter(@Nullable List<Commit> commits, Context context) {
        this.commits = commits;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(context).inflate(R.layout.v_commit,parent,false));
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        assert commits != null;
        Commit commit = commits.get(position);

        holder.name.setText(commit.getAuthor());
        holder.message.setText(commit.getMessage());

    }

    @Override
    public int getItemCount() {
        return commits == null ? 0 : commits.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.name)
        TextView name;

        @BindView(R.id.message)
        TextView message;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }


}