package com.online.unishop.core.commentary.model;

import com.online.unishop.core.commentary.dto.CommentDto;
import com.online.unishop.core.tovar.model.TovarModel;
import com.online.unishop.core.user.model.UsersModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.stream.Collectors;

@Entity
@Table(name = "commentary")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CommentaryModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "commentary_title",nullable = false)
    private String title;

    @Column(name = "commentary_text",nullable = false)
    private String text;


    @ManyToOne(fetch = FetchType.EAGER)
    private TovarModel tovarModel;

    @ManyToOne(fetch = FetchType.EAGER)
    private UsersModel usersModel;


    public CommentDto toDto(){
        return new CommentDto(
                this.id,
                this.title,
                this.text,
                this.tovarModel
                        .toDto(),
                this.usersModel
                        .toDto()
        );
    }

}
