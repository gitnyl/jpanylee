package com.jpanylee.api.jpanylee.repository;

import com.jpanylee.api.jpanylee.domain.entity.TestEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MngAdmRepository extends JpaRepository<TestEntity, Integer> {

}