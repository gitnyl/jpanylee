package com.jpanylee.api.jpanylee.repository;

import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class MngAdmCustomRepositoryImpl implements MngAdmCustomRepository {
    private final JPAQueryFactory factory;

}
