package com.online.unishop.useCase.tovar.add;

import com.online.unishop.core.catalog.dto.CatalogDto;
import com.online.unishop.core.filter.dto.FilterDto;
import com.online.unishop.core.user.dto.UsersDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class AddTovarInput {

    private String name;
    private String description;
    private Double price;
    private List<Long> catalogIds;
    private Long filterIds;
    private Long userId;
}
