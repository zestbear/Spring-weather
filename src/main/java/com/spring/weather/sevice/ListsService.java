package com.spring.weather.service;

import com.spring.weather.domain.List.Lists;
import com.spring.weather.domain.List.ListsRepository;
import com.spring.weather.web.dto.ListsListResponseDto;
import com.spring.weather.web.dto.ListsResponseDto;
import com.spring.weather.web.dto.ListsSaveRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class ListsService {
    private final ListsRepository listsRepository;

    public String save(ListsSaveRequestDto requestDto) {
        return listsRepository.save(requestDto.toEntity()).getId();
    }

    public ListsResponseDto findById(String id) {
        Lists entity = listsRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. id=" + id));

        return new ListsResponseDto(entity);
    }

    public List<ListsListResponseDto> findAllDesc() {
        return listsRepository.findAll().stream()
                .map(ListsListResponseDto::new)
                .collect(Collectors.toList());
    }
}
