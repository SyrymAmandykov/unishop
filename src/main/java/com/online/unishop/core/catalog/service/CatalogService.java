package com.online.unishop.core.catalog.service;


import com.online.unishop.core.catalog.dto.CatalogDto;
import com.online.unishop.core.catalog.model.CatalogModel;

import java.util.List;

public interface CatalogService {

    void addNewCatalog(String name);
    List<CatalogDto> getAllCatalog();
    CatalogDto getCatalogById(Long id);
    void updateCatalog(Long id,String name);

}
