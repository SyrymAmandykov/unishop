package com.online.unishop.useCase.catalog.delete;

import com.online.unishop.core.catalog.service.CatalogService;
import com.online.unishop.useCase.UseCaseAbstract;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DeleteCatalog extends UseCaseAbstract<DeleteCatalogInput,Object> {
    private final CatalogService catalogService;

    @Override
    protected Object doLogic(DeleteCatalogInput deleteCatalogInput) {
        if (deleteCatalogInput.getId() == null)
            throw new IllegalArgumentException("Invalid catalog id");

        catalogService.deleteCatalog(deleteCatalogInput.getId());

        return null;
    }
}
