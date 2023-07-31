package com.spring.weather.web.dto;

import com.spring.weather.domain.List.Lists;

public class ListsResponseDto {

    private String id;
    private String email;
    private String location;
    private String weather;

    public ListsResponseDto(Lists entity) {
        this.id = entity.getId();
        this.email = entity.getEmail();
        this.location= entity.getLocation();
        this.weather= entity.getWeather();
    }

    public String getId() {
        return id;
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
