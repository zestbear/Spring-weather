package com.spring.weather.web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@RequiredArgsConstructor
@Controller
public class indexController {

    @GetMapping("/")
    public String index() {
        return "weather";
    }

    @GetMapping("/main")
    public String main() {
        return "weather-main";
    }

    @GetMapping("/weather/{id}")
    public String show() {
        return "weather-show";
    }
}
