package com.online.unishop.core.tovar.dto;

import com.online.unishop.core.catalog.dto.CatalogDto;
import com.online.unishop.core.filter.dto.FilterDto;
import com.online.unishop.core.user.dto.UsersDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class TovarDto implements Serializable {

    private Long id;
    private String name;
    private String description;
    private Double price;
    private List<CatalogDto> catalog;
    private FilterDto filterDto;
    private UsersDto usersDto;
}
