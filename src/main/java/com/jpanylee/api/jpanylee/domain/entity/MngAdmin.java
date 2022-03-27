package com.jpanylee.api.jpanylee.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.Instant;

@Entity
@Table(name = "mng_admin")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MngAdmin {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idx", nullable = false)
    private Integer id;

    @Column(name = "id", length = 45)
    private String id2;

    @Column(name = "password")
    private String password;

    @Column(name = "level")
    private Integer level;

    @Column(name = "reg_date")
    private Instant regDate;

    @Column(name = "user_name", nullable = false, length = 50)
    private String userName;

    @Column(name = "user_phone", nullable = false)
    private String userPhone;

    @Column(name = "user_email", length = 100)
    private String userEmail;

    @Column(name = "enc_key", length = 10)
    private String encKey;

    @Column(name = "last_upd_date", nullable = false)
    private Instant lastUpdDate;

    @Column(name = "last_upd_idx")
    private Integer lastUpdIdx;

    @Column(name = "reg_idx", nullable = false)
    private Integer regIdx;

    @Column(name = "last_action_time")
    private Instant lastActionTime;

}