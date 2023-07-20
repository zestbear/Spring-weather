package com.spring.weather.web.dto;

import com.spring.weather.domain.List.Lists;
import lombok.Builder;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class ListsSaveRequestDto {

    private String email;
    private String location;
    private String weather;

    @Builder
    public ListsSaveRequestDto(String email, String location, String weather) {
        this.email = email;
        this.location = location;
        this.weather = weather;
    }

    public Lists toEntity() {
        return Lists.builder()
                .email(email)
                .location(location)
                .weather(weather)
                .build();
    }


    public String getEmail() {
        return email;
    }

    public String getLocation() {
        return location;
    }

    public String getWeather() {
        return weather;
    }
}
