package com.spring.weather.web;

import com.spring.weather.sevice.ListsService;
import com.spring.weather.web.dto.ListsSaveRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class ApiController {
    private final ListsService listsService;

    @PostMapping("/api/v1/posts")
    public Long save(@RequestBody ListsSaveRequestDto requestDto) {
        return listsService.save(requestDto);
    }
}
