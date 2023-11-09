package com.online.unishop.core.catalog.service;


import com.online.unishop.core.catalog.dto.CatalogDto;

import java.util.List;

public interface CatalogService {

    CatalogDto addNewCatalog(String name);

    List<CatalogDto> getAllCatalogByIds(List<Long> ids);

    CatalogDto getCatalogById(Long id);
    CatalogDto getCatalogByName(String name);

    List<CatalogDto> getAllCatalogs();

    void updateCatalog(Long id, String name);
    void deleteCatalog(Long id);

}
