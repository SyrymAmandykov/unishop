package com.online.unishop.useCase.tovar.update;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;


@AllArgsConstructor
@NoArgsConstructor
@Getter
public class UpdateTovarInput {
    private Long id;
    private String updatedName;
    private String updatedDescription;
    private Double updatedPrice;
    private List<Long> catalogIds;
    private Long filterIds;

}
