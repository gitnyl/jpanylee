package com.jpanylee.api.jpanylee.domain.entity.test;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TestTeam {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer teamIdx;

    @Column(length = 30)
    @NotEmpty
    private String teamTitle;

    @Column(updatable = false)
    @CreatedDate
    private LocalDateTime teamRgdt;

    @Column(updatable = true)
    @LastModifiedDate
    private LocalDateTime teamUpdt;

    @PrePersist
    public void teamRgdt() {
        this.teamRgdt = LocalDateTime.now();
    }
}