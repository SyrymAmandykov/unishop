package com.online.unishop.core.user.service;

import com.online.unishop.core.role.dto.RoleDto;
import com.online.unishop.core.role.model.RoleModel;
import com.online.unishop.core.user.model.UsersModel;
import com.online.unishop.core.user.dto.UsersDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UsersServiceImplements implements UsersService{

    private final com.online.unishop.core.user.model.UsersModelRepository usersModelRepository;

    /*Без Lombok @RequiredArgsConstructor это выглядело бы так:
    public UsersServiceImplements(com.online.unishop.core.model.UsersModelRepository usersModelRepository) {
        UsersModelRepository = usersModelRepository;
    }*/

    @Override
    public void addNewUser(String login, String password, String fullName, String birthDate, String phoneNumber, String profileAvatar, RoleDto roleDto) {
        usersModelRepository.save(
                new UsersModel(
                        null,
                        login,
                        password,
                        fullName,
                        birthDate,
                        phoneNumber,
                        profileAvatar,
                        new RoleModel()
                )
        );
    }

    @Override
    public List<UsersDto> getAllUsers() {
        return usersModelRepository
                .findAll()
                .stream()
                .map(UsersModel::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public UsersDto getUserById(Long id) {
        return usersModelRepository
                .findById(id)
                .orElseThrow()
                .toDto();
    }

    @Override
    public UsersDto getUserByLoginAndPassword(String login, String password) {
        return usersModelRepository
                .findFirstByLoginAndPassword(login,password)
                .toDto();
    }

    @Override
    public void updateUser(Long id, String login, String password, String fullName, String birthDate, String phoneNumber, String profileAvatar, RoleDto roleDto) {
        UsersModel userModel = usersModelRepository
                .findById(id)
                .orElseThrow();

        userModel.setLogin(login);
        userModel.setPassword(password);
        userModel.setFullName(fullName);
        userModel.setBirthDate(birthDate);
        userModel.setPhoneNumber(phoneNumber);
        userModel.setProfileAvatar(profileAvatar);
        userModel.setRoleModel(new RoleModel());

        usersModelRepository
                .save(userModel);

    }

    @Override
    public void deleteUser(Long id) {
        usersModelRepository
                .deleteById(id);
    }
}
