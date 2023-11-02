package com.online.unishop.core.user.service;

import com.online.unishop.core.role.dto.RoleDto;
import com.online.unishop.core.role.model.RoleModel;
import com.online.unishop.core.role.model.RoleModelRepository;
import com.online.unishop.core.user.model.UsersModel;
import com.online.unishop.core.user.dto.UsersDto;
import com.online.unishop.core.user.model.UsersModelRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UsersServiceImplements implements UsersService{

    private final UsersModelRepository usersModelRepository;
    private final RoleModelRepository roleModelRepository;

    /*Без Lombok @RequiredArgsConstructor это выглядело бы так:
    public UsersServiceImplements(com.online.unishop.core.model.UsersModelRepository usersModelRepository) {
        UsersModelRepository = usersModelRepository;
    }*/

    @Override
    public void addNewUser(
            String login,
            String password,
            String fullName,
            String birthDate,
            String phoneNumber,
            String profileAvatar
           )
    {

        usersModelRepository.save(
                new UsersModel(
                        null,
                        login,
                        password,
                        fullName,
                        birthDate,
                        phoneNumber,
                        profileAvatar,
                        null
                )
        );
    }

    @Override
    public List<UsersDto> getAllUsers() {
        return usersModelRepository
                .findAll()
                .stream()
                .map(UsersModel::toDto)
                .toList();
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
    public void updateUser(Long id, String login, String password, String fullName, String birthDate, String phoneNumber, String profileAvatar, String roleName) {
        UsersModel updatedUserModel = usersModelRepository
                .findById(id)
                .orElseThrow();
        RoleModel updatedRoleModel = roleModelRepository
                .findByName(roleName);

        updatedUserModel.setLogin(login);
        updatedUserModel.setPassword(password);
        updatedUserModel.setFullName(fullName);
        updatedUserModel.setBirthDate(birthDate);
        updatedUserModel.setPhoneNumber(phoneNumber);
        updatedUserModel.setProfileAvatar(profileAvatar);
        updatedUserModel.setRoleModel(updatedRoleModel);

        usersModelRepository
                .save(
                        updatedUserModel);

    }

    @Override
    public void deleteUser(Long id) {
        usersModelRepository
                .deleteById(id);
    }
}
