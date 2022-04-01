package com.jpanylee.api.jpanylee.repository.test;

import com.jpanylee.api.jpanylee.domain.entity.test.TestMember;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TestMemberRepo extends JpaRepository<TestMember, Integer> {
    TestMember findByMemberId(String memberId);
}
