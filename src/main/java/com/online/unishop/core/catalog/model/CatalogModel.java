package com.online.unishop.core.catalog.model;

import com.online.unishop.core.catalog.dto.CatalogDto;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "catalog")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CatalogModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "catalog_name",nullable = false)
    private String name;

    public CatalogDto toDto(){
        return new CatalogDto(
            this.id,
            this.name
        );
    }
}
