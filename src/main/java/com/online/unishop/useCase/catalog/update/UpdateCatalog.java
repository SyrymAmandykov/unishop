package com.online.unishop.useCase.catalog.update;

import com.online.unishop.core.catalog.service.CatalogService;
import com.online.unishop.useCase.UseCaseAbstract;
import com.online.unishop.useCase.catalog.add.AddCatalogInput;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UpdateCatalog extends UseCaseAbstract<UpdateCatalogInput,Object> {

    private final CatalogService catalogService;

    @Override
    protected Object doLogic(UpdateCatalogInput updateCatalogInput) {
        if (updateCatalogInput.getName().isEmpty())
            throw new IllegalArgumentException("Catalog name must be empty");

        catalogService.updateCatalog(
                updateCatalogInput.getId(),
                updateCatalogInput.getName()
        );
        return null;
    }
}
