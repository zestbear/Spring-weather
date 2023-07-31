package com.spring.weather.web.dto;

import com.spring.weather.domain.List.Lists;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class ListsListResponseDto {
    private String id;
    private String email;
    private String location;
    private String weather;
    private LocalDateTime createdDate;

    public ListsListResponseDto(Lists entity) {
        this.id = entity.getId();
        this.email = entity.getEmail();
        this.location = entity.getLocation();
        this.weather = entity.getWeather();
        this.createdDate = entity.getCreatedDate();
    }
}
