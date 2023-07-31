package com.spring.weather.web;

import com.spring.weather.web.dto.ListsResponseDto;
import com.spring.weather.web.dto.ListsSaveRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/lists")
public class ListsController {
    private final com.spring.weather.service.ListsService listsService;

    @PostMapping
    public String save(@RequestBody ListsSaveRequestDto requestDto) {
        return listsService.save(requestDto);
    }

    @GetMapping("/{id}")
    public ListsResponseDto findById(@PathVariable String id) {
        return listsService.findById(id);
    }
}
