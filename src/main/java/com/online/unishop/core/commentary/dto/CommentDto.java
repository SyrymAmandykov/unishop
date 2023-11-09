package com.online.unishop.core.commentary.dto;

import com.online.unishop.core.tovar.dto.TovarDto;
import com.online.unishop.core.user.dto.UsersDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CommentDto implements Serializable {

    private Long id;
    private String title;
    private String text;
    private TovarDto tovarDto;
    private UsersDto usersDto;
}
