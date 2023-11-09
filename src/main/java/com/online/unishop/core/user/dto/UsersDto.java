package com.online.unishop.core.user.dto;

import com.online.unishop.core.role.Role;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UsersDto implements Serializable {
    private Long id;
    private String login;
    private String password;
    private String fullName;
    private String birthDate;
    private String phoneNumber;
    private String profileAvatar;
    private Role role;
}
