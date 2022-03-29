package com.jpanylee.api.jpanylee.model.response;

import lombok.Data;

import java.io.Serializable;
import java.time.Instant;

@Data
public class RespMngAdmin implements Serializable {
    private final Integer id;
    private final String id2;
    private final String password;
    private final Integer level;
    private final Instant regDate;
    private final String userName;
    private final String userPhone;
    private final String userEmail;
    private final String encKey;
    private final Instant lastUpdDate;
    private final Integer lastUpdIdx;
    private final Integer regIdx;
    private final Instant lastActionTime;
}
