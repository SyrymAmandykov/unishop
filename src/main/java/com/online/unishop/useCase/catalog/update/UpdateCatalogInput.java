package com.online.unishop.useCase.catalog.update;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class UpdateCatalogInput {
    private Long id;
    private String name;
}
