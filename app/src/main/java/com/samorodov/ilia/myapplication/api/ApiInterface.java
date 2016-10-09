package com.samorodov.ilia.myapplication.api;

import com.samorodov.ilia.myapplication.model.dto.CommitDTO;

import java.util.List;

import retrofit2.http.GET;
import rx.Observable;

public interface ApiInterface {

    @GET("/repos/xaxtix/azarchenkovpidr/commits")
    Observable<List<CommitDTO>> getCommits();

}
