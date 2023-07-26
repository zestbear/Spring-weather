package com.spring.weather.web;

import com.spring.weather.sevice.ListsService;
import com.spring.weather.web.dto.ListsListResponseDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
public class ShowController {
    private final ListsService listsService;

    public ShowController(ListsService listsService) {
        this.listsService = listsService;
    }

    @GetMapping("/api/weatherInfos")
    public List<ListsListResponseDto> getAllPosts() {
        return listsService.findAllDesc();
    }

}