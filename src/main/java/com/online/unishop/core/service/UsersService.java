package com.online.unishop.core.service;

import com.online.unishop.core.dto.UsersDto;
import org.apache.catalina.User;

import java.util.List;

public interface UsersService {

    //preview: addNewUser, getAllUsers, getUserById, getUserByLoginAndPassword, updateUser , deleteUser

    void addNewUser(String login,String password,String fullName,String birthDate,String phoneNumber, Role role);
    List<UsersDto> getAllUsers();
    UsersDto getUserById(Long id);
    UsersDto getUserByLoginAndPassword(String login,String password);
    void updateUser(Long id,String login,String password,String fullName,String birthDate,String phoneNumber,String profileAvatar,Role role);
    void deleteUser(Long id);
}
