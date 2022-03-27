package com.jpanylee.jpanylee.repository;

import com.jpanylee.jpanylee.domain.entity.TestEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TestRepository extends JpaRepository<TestEntity, Integer>, TestCustomRepository {

}