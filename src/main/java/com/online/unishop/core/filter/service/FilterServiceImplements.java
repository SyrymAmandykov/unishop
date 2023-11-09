package com.online.unishop.core.filter.service;

import com.online.unishop.core.filter.dto.FilterDto;
import com.online.unishop.core.filter.model.FilterModel;
import com.online.unishop.core.filter.model.FilterModelRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class FilterServiceImplements implements FilterService {

    private final FilterModelRepository filterModelRepository;

    @Override
    public FilterDto addNewFilter(String name) {
        return filterModelRepository
                .save(
                        new FilterModel(
                                null,
                                name)
                ).toDto();
    }

    @Override
    public FilterDto getFilterByName(String name){
        return filterModelRepository.findByName(name)
                .toDto();
    }

    @Override
    public List<FilterDto> getAllFilters() {
        return filterModelRepository
                .findAll()
                .stream()
                .map(FilterModel::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public FilterDto getFilterById(Long id) {
        return filterModelRepository
                .findById(id)
                .orElseThrow()
                .toDto();
    }

    @Override
    public FilterModel getFilterModelById(Long id) {
        return filterModelRepository
                .findById(id)
                .orElseThrow();
    }

    @Override
    public void deleteFilter(Long id) {
        filterModelRepository
                .deleteById(id);
    }
}
