package com.online.unishop.useCase.commentary.add;

import com.online.unishop.core.tovar.dto.TovarDto;
import com.online.unishop.core.user.dto.UsersDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class AddCommentaryInput {

    private String title;
    private String text;
    private TovarDto tovarDto;
    private UsersDto usersDto;
}
