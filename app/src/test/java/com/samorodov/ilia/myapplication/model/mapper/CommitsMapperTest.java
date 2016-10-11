package com.samorodov.ilia.myapplication.model.mapper;

import com.samorodov.ilia.myapplication.model.BaseModelTest;
import com.samorodov.ilia.myapplication.model.Commit;
import com.samorodov.ilia.myapplication.model.dto.CommitDTO;
import com.samorodov.ilia.myapplication.model.maper.CommitsMapper;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class CommitsMapperTest extends BaseModelTest<List<CommitDTO>> {

    @Override
    protected String getFileName() {
        return "json/Commits.json";
    }

    @Test
    public void mappingTest() {
        CommitsMapper mapper = new CommitsMapper();

        List<Commit> commits = mapper.call(getModel());

        assertEquals(commits.get(0).getMessage(),"Удалил .idea, projectBackupFiles");
        assertEquals(commits.get(1).getAuthor(),"Илья Самородов");
        assertEquals(commits.get(2).getAuthor(),"Илья Самородов");
        assertEquals(commits.get(1).getMessage(),"Обновил .gitignore");
        assertEquals(commits.get(2).getMessage(),"Добавил retroLambda plugin, SubscriberAdapter. Отформатировал код");
    }
}
