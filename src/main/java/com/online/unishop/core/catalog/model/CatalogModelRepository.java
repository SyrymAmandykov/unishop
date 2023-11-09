package com.online.unishop.core.catalog.model;

import com.online.unishop.core.catalog.dto.CatalogDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CatalogModelRepository extends JpaRepository<CatalogModel, Long> {

    List<CatalogModel> findAllByIdIn(List<Long> ids);
    CatalogModel findCatalogByName(String name);
}
