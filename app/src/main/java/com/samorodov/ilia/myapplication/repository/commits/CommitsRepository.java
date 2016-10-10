package com.samorodov.ilia.myapplication.repository.commits;

import com.samorodov.ilia.myapplication.model.Commit;

import java.util.List;

import rx.Observable;

/**
 * Created by xaxtix on 07.10.16.
 */
public interface CommitsRepository {

    Observable<List<Commit>> getCommits(String owner,String repo);
}
