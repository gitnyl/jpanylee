package com.jpanylee.api.jpanylee.repository.test;

import com.jpanylee.api.jpanylee.domain.entity.test.TestMember;
import com.jpanylee.api.jpanylee.domain.entity.test.UserRole;
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
class TestMemberRepoTest {
    @Autowired
    TestMemberRepo testMemberRepo;

    @Test
    @Transactional
    @Rollback(false)
    public void testMember() {
        TestMember testMember = new TestMember(
                null, "jskim", "1234", "김지수", "인사팀", null,  UserRole.TEAM_RND
        );

        testMemberRepo.save(testMember);

        TestMember findTestMember = testMemberRepo.findByMemberId(testMember.getMemberId());

        assertEquals(findTestMember.getMemberId(), testMember.getMemberId());
        assertEquals(findTestMember.getMemberName(), testMember.getMemberName());
        assertEquals(findTestMember.getRole(), testMember.getRole());
        assertEquals(findTestMember, testMember);
    }
}