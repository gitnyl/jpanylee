package com.jpanylee.jpanylee.controller;

import com.jpanylee.jpanylee.domain.entity.TestEntity;
import com.jpanylee.jpanylee.repository.TestRepository;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;

@SpringBootTest
@RunWith(SpringRunner.class)
class TestControllerTestEntity {

    @Autowired
    TestRepository testRepository;

    @Test
    @Transactional
    @Rollback(false)
    public void testTest() throws Exception {
        //given
        TestEntity test = new TestEntity();


    }
}