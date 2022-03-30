package com.jpanylee.jpanylee.repository;

import com.jpanylee.jpanylee.domain.entity.TestEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TestRepository extends JpaRepository<TestEntity, Integer> {
    TestEntity findByIdx(Integer idx);
}
