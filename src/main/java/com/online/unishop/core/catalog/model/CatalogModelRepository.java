package com.online.unishop.core.catalog.model;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CatalogModelRepository extends JpaRepository<CatalogModel,Long> {
}
