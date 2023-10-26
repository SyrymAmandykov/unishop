package com.online.unishop.core.service;

import com.online.unishop.core.dto.UsersDto;
import com.online.unishop.core.model.UsersModel;
import com.online.unishop.core.model.UsersModelRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UsersServiceImplements implements UsersService{

    private final UsersModelRepository UsersModelRepository;

    /*Без Lombok @RequiredArgsConstructor это выглядело бы так:
    public UsersServiceImplements(com.online.unishop.core.model.UsersModelRepository usersModelRepository) {
        UsersModelRepository = usersModelRepository;
    }*/

    @Override
    public void addNewUser(String login, String password, String fullName, String birthDate, String phoneNumber, Role role) {
        UsersModelRepository.save(
                new UsersModel(
                        null,
                        login,
                        password,
                        fullName,
                        birthDate,
                        phoneNumber,
                        role
                )
        );
    }

    @Override
    public List<UsersDto> getAllUsers() {
        return null;
    }

    @Override
    public UsersDto getUserById(Long id) {
        return null;
    }

    @Override
    public UsersDto getUserByLoginAndPassword(String login, String password) {
        return null;
    }

    @Override
    public void updateUser(Long id, String login, String password, String fullName, String birthDate, String phoneNumber, String profileAvatar, Role role) {

    }

    @Override
    public void deleteUser(Long id) {

    }
}
