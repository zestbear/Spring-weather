package com.spring.weather.domain.User;

import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String location;

    @Column(nullable = false)
    private String weather;

    @Builder
    public User(String location, String weather) {
        this.location = location;
        this.weather = weather;
    }

    public User update(String location, String weather) {
        this.location = location;
        this.weather = weather;

        return this;
    }

    public Long getId() {
        return id;
    }

    public String getLocation() {
        return location;
    }

    public String getWeather() {
        return weather;
    }
}
