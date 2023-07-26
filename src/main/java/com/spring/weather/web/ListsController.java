package com.spring.weather.web;

import com.spring.weather.sevice.ListsService;
import com.spring.weather.web.dto.ListsListResponseDto;
import com.spring.weather.web.dto.ListsResponseDto;
import com.spring.weather.web.dto.ListsSaveRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/lists")
public class ListsController {
    private final ListsService listsService;

    @PostMapping
    public Long save(@RequestBody ListsSaveRequestDto requestDto) {
        return listsService.save(requestDto);
    }

    @GetMapping("/{id}")
    public ListsResponseDto findById(@PathVariable Long id) {
        return listsService.findById(id);
    }
}
