package com.jpanylee.api.jpanylee.repository;

import com.jpanylee.api.jpanylee.domain.entity.TestEntity;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class TestRepository {
    @PersistenceContext
    private EntityManager em;

    public String save(TestEntity test) {
        em.persist(test);
        return test.getId();    //저장 후에는 id만 반환
    }

    public TestEntity find(String id) {
        return em.find(TestEntity.class, id);
    }

}
