package com.spring.weather.domain.List;

import com.spring.weather.domain.BaseTimeEntity;
import jdk.vm.ci.meta.Local;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Field;

import java.time.LocalDateTime;

@NoArgsConstructor
@Getter
@Document(collection = "lists")
public class Lists extends BaseTimeEntity {

    @Id
    private String id;
    private String email;
    private String location;
    private String weather;

    @Builder
    public Lists(String email, String location, String weather) {

        this.email = email;
        this.location = location;
        this.weather = weather;
    }
}
