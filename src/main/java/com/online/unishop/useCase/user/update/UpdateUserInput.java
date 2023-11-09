package com.online.unishop.useCase.user.update;

import com.online.unishop.core.role.Role;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class UpdateUserInput {
    private Long id;
    private String login;
    private String password;
    private String fullName;
    private String birthDate;
    private String phoneNumber;
    private String profileAvatar;
    private Role role;
}
