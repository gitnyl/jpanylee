package com.jpanylee.jpanylee.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.Instant;

@Entity
@Table(name = "tb_test")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TestEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idx", nullable = false)
    private Integer id;

    @Column(name = "id", length = 45)
    private String id2;

    @Column(name = "password", length = 100)
    private String password;

    @Column(name = "name", nullable = false, length = 50)
    private String name;

    @Column(name = "phone", nullable = false, length = 20)
    private String phone;

    @Column(name = "email", length = 100)
    private String email;

    @Column(name = "rgdt")
    private Instant rgdt;

    @Column(name = "updt", nullable = false)
    private Instant updt;

    @Column(name = "rgidx", nullable = false)
    private Integer rgidx;

    @Column(name = "upidx")
    private Integer upidx;
}