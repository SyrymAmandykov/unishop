package com.online.unishop.core.tovar.model;

import com.online.unishop.core.catalog.model.CatalogModel;
import com.online.unishop.core.commentary.model.CommentaryModel;
import com.online.unishop.core.filter.model.FilterModel;
import com.online.unishop.core.tovar.dto.TovarDto;
import com.online.unishop.core.user.model.UsersModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.stream.Collectors;

@Entity
@Table(name = "tovar")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class TovarModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "tovar_name", nullable = false)
    private String name;

    @Column(name = "tovar_description", nullable = false)
    private String description;

    @Column(name = "tovar_price", nullable = false)
    private Double price;

    /* Ниже уже связки таблиц*/

    @ManyToMany(fetch = FetchType.EAGER)
    private List<CatalogModel> catalogModel;

    @ManyToOne(fetch = FetchType.EAGER)
    private FilterModel filterModel;

    @ManyToOne(fetch = FetchType.EAGER)
    private UsersModel usersModel;

    @OneToMany(fetch = FetchType.LAZY)
    private List<CommentaryModel> commentaryModel;


    public TovarDto toDto() {
        return new TovarDto(
                this.id,
                this.name,
                this.description,
                this.price,
                this.catalogModel
                        .stream()
                        .map(CatalogModel::toDto)
                        .collect(Collectors.toList()),
                this.filterModel
                        .toDto(),
                this.usersModel
                        .toDto(),
                this.commentaryModel
                        .stream()
                        .map(CommentaryModel::toDto)
                        .collect(Collectors.toList())
        );
    }
}
