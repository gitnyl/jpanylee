package com.jpanylee.jpanylee.controller;

import com.jpanylee.api.jpanylee.domain.entity.TestEntity;
import com.jpanylee.api.jpanylee.repository.TestRepository;
import org.assertj.core.api.Assertions;
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
        test.setName("nylee");
        //when
        String savedId = testRepository.save(test);
        TestEntity findTest = testRepository.find(savedId);
        //then
        Assertions.assertThat(findTest.getId()).isEqualTo(savedId);
        Assertions.assertThat(findTest.getName()).isEqualTo(test.getName());
    }

}