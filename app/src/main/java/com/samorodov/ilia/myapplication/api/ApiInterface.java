package com.samorodov.ilia.myapplication.api;

import com.samorodov.ilia.myapplication.model.dto.CommitDTO;

import java.util.List;

import retrofit2.http.GET;
import retrofit2.http.Path;
import rx.Observable;

public interface ApiInterface {

    @GET("/repos/{owner}/{repo}/commits")
    Observable<List<CommitDTO>> getCommits(@Path("owner") String owner, @Path("repo") String repo);

}
