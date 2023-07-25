package com.spring.weather.sevice;

import com.spring.weather.domain.List.Lists;
import com.spring.weather.domain.List.ListsRepository;
import com.spring.weather.web.dto.ListsListResponseDto;
import com.spring.weather.web.dto.ListsResponseDto;
import com.spring.weather.web.dto.ListsSaveRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class ListsService {
    private final ListsRepository listsRepository;

    @Transactional
    public Long save(ListsSaveRequestDto requestDto) {
        return listsRepository.save(requestDto.toEntity()).getId();
    }

    public ListsResponseDto findById(Long id) {
        Lists entity = listsRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. id=" + id));

        return new ListsResponseDto(entity);
    }

    @org.springframework.transaction.annotation.Transactional(readOnly = true)
    public List<ListsListResponseDto> findAllDesc() {
        return listsRepository.findAllDesc().stream()
                .map(ListsListResponseDto::new)
                .collect(Collectors.toList());
    }

    @org.springframework.transaction.annotation.Transactional
    public void delete(Long id) {
        Lists posts = listsRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 검색기록이 없습니다. id=" + id));

        listsRepository.delete(posts);
    }

}
