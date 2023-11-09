package com.online.unishop.core.tovar.model;

import com.online.unishop.core.catalog.model.CatalogModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TovarModelRepository extends JpaRepository<TovarModel, Long> {

    List<TovarModel> findAllByCatalogModel(List<CatalogModel> catalogModel);
}
