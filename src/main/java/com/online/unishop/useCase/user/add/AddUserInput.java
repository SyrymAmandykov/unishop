package com.online.unishop.useCase.user.add;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class AddUserInput {

    /* здесь мы говорим какие данные нужны для юзкейса */
    private String login;
    private String password;
    private String fullName;
    private String birthDate;
    private String phoneNumber;
    private String profileAvatar;
}
