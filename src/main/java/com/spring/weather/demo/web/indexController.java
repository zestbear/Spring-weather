package com.spring.weather.demo.web;

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

    @GetMapping("/weather/main")
    public String main() {
        return "weather-main";
    }

}
