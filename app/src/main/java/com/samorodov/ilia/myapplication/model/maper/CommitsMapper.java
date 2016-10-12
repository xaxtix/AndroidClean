package com.samorodov.ilia.myapplication.model.maper;

import com.samorodov.ilia.myapplication.model.vo.Commit;
import com.samorodov.ilia.myapplication.model.dto.CommitDTO;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import rx.functions.Func1;

public class CommitsMapper implements Func1<List<CommitDTO>, List<Commit>> {

    @Inject
    public CommitsMapper() {
    }

    @Override
    public List<Commit> call(List<CommitDTO> commitDTOs) {
        List<Commit> commits = new ArrayList<>(commitDTOs.size());

        for (CommitDTO commitDTO : commitDTOs) {
            commits.add(new Commit(commitDTO.getCommit().getAuthor().getName()
                    , commitDTO.getCommit().getMessage()));
        }

        return commits;
    }

}
