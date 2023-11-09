package com.online.unishop.core.filter.service;

import com.online.unishop.core.filter.dto.FilterDto;
import com.online.unishop.core.filter.model.FilterModel;

import java.util.List;

public interface FilterService {

    FilterDto addNewFilter(String name);

    FilterDto getFilterByName(String name);

    List<FilterDto> getAllFilters();

    FilterDto getFilterById(Long id);

    FilterModel getFilterModelById(Long id);

    void deleteFilter(Long id);

}
