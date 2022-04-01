package com.jpanylee.api.jpanylee.repository.test;

import com.jpanylee.api.jpanylee.domain.entity.test.TestTeam;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TestTeamRepo extends JpaRepository<TestTeam, Integer> {
    TestTeam findByTeamTitle(String teamTitle);
}
