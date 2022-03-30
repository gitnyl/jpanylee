package com.jpanylee.jpanylee.domain.entity;

import lombok.*;

import javax.persistence.*;
import java.time.Instant;
import java.time.LocalDate;

@Entity
@Table(name = "tb_test")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TestEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idx", nullable = false)
    private Integer idx;

    @Column(name = "id", length = 45)
    private String id;

    @Column(name = "password", length = 100)
    private String password;

    @Column(name = "name", nullable = false, length = 50)
    private String name;

    @Column(name = "phone", nullable = false, length = 20)
    private String phone;

    @Column(name = "email", length = 100)
    private String email;

    @Column(name = "rgdt")
    private LocalDate rgdt;

    @Column(name = "updt", nullable = false)
    private LocalDate updt;

    @Column(name = "rgidx", nullable = false)
    private Integer rgidx;

    @Column(name = "upidx")
    private Integer upidx;
}