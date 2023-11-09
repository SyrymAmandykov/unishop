package com.online.unishop.core.filter.model;

import com.online.unishop.core.filter.dto.FilterDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FilterModelRepository extends JpaRepository<FilterModel, Long> {

    FilterModel findByName(String name);
}
