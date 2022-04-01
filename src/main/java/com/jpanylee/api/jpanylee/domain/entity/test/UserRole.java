package com.jpanylee.api.jpanylee.domain.entity.test;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum UserRole {
    TEAM_HR("HumanResources"),
    TEAM_RND("R&D-Lab"),
    TEAM_PLAN("Planning"),
    TEAM_GA("GeneralAffairs"),
    TEAM_PR("PublicRelations"),
    TEAM_CS("CustomerSatisfaction");

    private final String value;
}