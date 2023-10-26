package com.online.unishop.core.dto;

import jakarta.persistence.Column;
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
    private String commentary;
    private Role role;
}
