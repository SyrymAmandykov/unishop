package com.online.unishop.core.user.model;

import com.online.unishop.core.role.dto.RoleDto;
import com.online.unishop.core.role.model.RoleModel;
import com.online.unishop.core.user.dto.UsersDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "users")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UsersModel{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "user_login", nullable = false)
    private String login;

    @Column(name = "user_password", nullable = false)
    private String password;

    @Column(name = "user_fullName", nullable = false)
    private String fullName;

    @Column(name = "user_birthDate", nullable = false)
    private String birthDate;

    @Column(name = "user_phoneNumber")
    private String phoneNumber;

    @Column(name = "user_profileAvatar")
    private String profileAvatar;

    @ManyToOne(fetch = FetchType.EAGER)
    private RoleModel roleModel;

    public UsersDto toDto(){
        return new UsersDto(
                this.id,
                this.login,
                this.password,
                this.fullName,
                this.birthDate,
                this.phoneNumber,
                this.profileAvatar,
                this.roleModel
                        .toDto()
        );
    }
}
