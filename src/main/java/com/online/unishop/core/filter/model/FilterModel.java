package com.online.unishop.core.filter.model;

import com.online.unishop.core.filter.dto.FilterDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "filter")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class FilterModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "filter_name", nullable = false)
    private String name;

    public FilterDto toDto() {
        return new FilterDto(
                this.id,
                this.name
        );
    }
}
