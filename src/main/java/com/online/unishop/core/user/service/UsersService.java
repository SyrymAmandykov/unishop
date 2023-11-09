package com.online.unishop.core.user.service;

import com.online.unishop.core.role.Role;
import com.online.unishop.core.user.dto.UsersDto;

import java.util.List;

public interface UsersService {

    //preview: addNewUser, getAllUsers, getUserById, getUserByLoginAndPassword, updateUser , deleteUser

    /*Autorization*/
    void addNewUser(String login, String password, String fullName, String birthDate, String phoneNumber, String profileAvatar);

    List<UsersDto> getAllUsers();

    /*Для отображеня данных профиля*/
    UsersDto getUserById(Long id);

    void updateUser(Long id, String login, String password, String fullName, String birthDate, String phoneNumber, String profileAvatar, Role role);

    void deleteUserById(Long id);

    /*Login*/
    UsersDto getUserByLoginAndPassword(String login, String password);

}
