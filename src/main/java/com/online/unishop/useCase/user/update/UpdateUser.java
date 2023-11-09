package com.online.unishop.useCase.user.update;

import com.online.unishop.core.user.service.UsersService;
import com.online.unishop.useCase.UseCaseAbstract;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UpdateUser extends UseCaseAbstract<UpdateUserInput, Object> {

    private final UsersService usersService;

    @Override
    protected Object doLogic(UpdateUserInput updateUserInput) {

        if (updateUserInput.getId() == null)
            throw new IllegalArgumentException("User id is empty");

        if (usersService.getUserById(updateUserInput.getId()) == null)
            throw new IllegalArgumentException("User with id is not found");

        if (updateUserInput.getFullName().isEmpty())
            throw new IllegalArgumentException("Each of us should have a first name and last name");


        usersService.updateUser(
                updateUserInput.getId(),
                updateUserInput.getLogin(),
                updateUserInput.getPassword(),
                updateUserInput.getFullName(),
                updateUserInput.getBirthDate(),
                updateUserInput.getPhoneNumber(),
                updateUserInput.getProfileAvatar(),
                updateUserInput.getRole()
        );

        return null;
    }
}
