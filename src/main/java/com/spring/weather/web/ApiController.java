package com.spring.weather.web;

import com.spring.weather.sevice.ListsService;
import com.spring.weather.web.dto.ListsResponseDto;
import com.spring.weather.web.dto.ListsSaveRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class ApiController {
    private final ListsService listsService;

    @PostMapping("/api/v1/lists")
    public Long save(@RequestBody ListsSaveRequestDto requestDto) {
        return listsService.save(requestDto);
    }

    @GetMapping("/api/v1/lists/{id}")
    public ListsResponseDto findById(@PathVariable Long id) {
        return listsService.findById(id);
    }
}
