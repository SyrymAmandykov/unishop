package com.online.unishop.useCase.filter.add;

import com.online.unishop.core.catalog.dto.CatalogDto;
import com.online.unishop.core.filter.dto.FilterDto;
import com.online.unishop.core.filter.service.FilterService;
import com.online.unishop.useCase.UseCaseAbstract;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class AddFilter extends UseCaseAbstract<AddFilterInput,Object> {

    private final FilterService filterService;

    @Override
    protected Object doLogic(AddFilterInput addFilterInput) {

        if (addFilterInput.getName().isEmpty())
            throw new IllegalArgumentException("Filter name is not be empty");

        FilterDto newFilter = getOrCreateNewFilter(addFilterInput.getName());
        return null;
    }

    private FilterDto getOrCreateNewFilter(String name){
         FilterDto filter = filterService.getFilterByName(name);

        return filter == null ? filterService.addNewFilter(name) : filter;
    }
}
