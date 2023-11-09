package com.online.unishop.useCase.tovar.add;

import com.online.unishop.core.catalog.dto.CatalogDto;
import com.online.unishop.core.catalog.model.CatalogModelRepository;
import com.online.unishop.core.catalog.service.CatalogService;
import com.online.unishop.core.filter.model.FilterModelRepository;
import com.online.unishop.core.filter.service.FilterService;
import com.online.unishop.core.tovar.dto.TovarDto;
import com.online.unishop.core.tovar.model.TovarModelRepository;
import com.online.unishop.core.tovar.service.TovarService;
import com.online.unishop.core.user.model.UsersModelRepository;
import com.online.unishop.core.user.service.UsersService;
import com.online.unishop.useCase.UseCaseAbstract;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class AddTovar extends UseCaseAbstract<AddTovarInput,Object> {

    private final TovarService tovarService;

    @Override
    protected Object doLogic(AddTovarInput addTovarInput) {

        if (addTovarInput.getName().isEmpty())
            throw new IllegalArgumentException("Tovar name is not be empty");

        if (addTovarInput.getDescription().isEmpty())
            throw new IllegalArgumentException("Tovar description is not be empty");

        if (addTovarInput.getPrice() > 0)
            throw new IllegalArgumentException("The price must be greater than 0");


        tovarService.addNewTovar(
                addTovarInput.getName(),
                addTovarInput.getDescription(),
                addTovarInput.getPrice(),
                addTovarInput.getCatalogIds(),
                addTovarInput.getFilterIds(),
                addTovarInput.getUserId()
        );
        return null;

    }
}
