package com.jpanylee.api.jpanylee.domain.entity.test;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class TestMember {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer memberIdx;

    @Column(length = 30)
    @NotEmpty
    private String memberId;

    @Column(length = 30)
    @NotEmpty
    private String memberPwd;

    @Column(length = 30)
    @NotEmpty
    private String memberName;

    @Column(length = 30)
    @NotEmpty
    private String memberTeam;

    @Column(updatable = false)
    @CreatedDate
    private LocalDateTime memberRgdt;

    @Column
    @Enumerated(EnumType.STRING)    //Enum 타입 관리
    private UserRole role;

    @PrePersist
    public void memberRgdt() {
        this.memberRgdt = LocalDateTime.now();
    }
}