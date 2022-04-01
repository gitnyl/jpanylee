package com.jpanylee.api.jpanylee.repository.test;

import com.jpanylee.api.jpanylee.domain.entity.test.TestTeam;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class TestTeamRepoTest {
    @Autowired
    TestTeamRepo testTeamRepo;

    @Test
    @Transactional
    @Rollback(false)
    public void testTeam() {
        TestTeam testTeam = new TestTeam(
                null, "인사팀", null, null
        );
        testTeamRepo.save(testTeam);

        TestTeam findTestTeam = testTeamRepo.findByTeamTitle(testTeam.getTeamTitle());

        assertEquals(findTestTeam.getTeamIdx(), testTeam.getTeamIdx());
        assertEquals(findTestTeam.getTeamTitle(), testTeam.getTeamTitle());
        assertEquals(findTestTeam, testTeam);
    }
}