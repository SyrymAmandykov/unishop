package com.online.unishop.useCase.catalog.add;

import com.online.unishop.core.catalog.dto.CatalogDto;
import com.online.unishop.core.catalog.service.CatalogService;
import com.online.unishop.useCase.UseCaseAbstract;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import javax.xml.catalog.Catalog;

@Component
@RequiredArgsConstructor
public class AddCatalog extends UseCaseAbstract<AddCatalogInput,Object> {

    private final CatalogService catalogService;

    @Override
    protected Object doLogic(AddCatalogInput addCatalogInput) {
        if (addCatalogInput.getName().isEmpty())
            throw new IllegalArgumentException("Catalog name must be empty");


        CatalogDto catalogDto = getOrCreateNewCatalog(addCatalogInput.getName()); // TODO: 04.11.2023 Правильно ли здесь все ?! 
        return null;
    }

    private CatalogDto getOrCreateNewCatalog(String name){
        CatalogDto catalogDto = catalogService.getCatalogByName(name); // попробуй найти по имени в бд

        //если name из бд придет пустым то обратись в сервис и создай новый каталог
        // а если он найдет то верни просто его
        return catalogDto == null ? catalogService.addNewCatalog(name) : catalogDto;
    }
}
