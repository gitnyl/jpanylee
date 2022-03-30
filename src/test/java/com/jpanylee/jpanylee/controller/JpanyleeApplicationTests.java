package com.jpanylee.jpanylee.controller;

import com.jpanylee.jpanylee.domain.entity.TestEntity;
import com.jpanylee.jpanylee.repository.TestRepository;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
@Rollback(true)
@Slf4j
public class JpanyleeApplicationTests {

    @Autowired
    private TestRepository testRepository;

    @Test
    private void readTest() {
        TestEntity testEntity = testRepository.findByIdx(2);

        log.info(testEntity.getName());
    }

}
