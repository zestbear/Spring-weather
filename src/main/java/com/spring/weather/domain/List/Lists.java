package com.spring.weather.domain.List;

import com.spring.weather.domain.BaseTimeEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@Getter
@Entity
public class Lists extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 500, nullable = false)
    private String email;

    // nullable = false
    @Column(columnDefinition = "TEXT", nullable = true)
    private String location;

    // nullable = false
    @Column(length = 500, nullable = true)
    private String weather;

    @Builder
    public Lists(String email, String location, String weather) {
        this.email = email;
        this.location = location;
        this.weather = weather;
    }
}
