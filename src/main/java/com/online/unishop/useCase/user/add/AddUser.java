package com.online.unishop.useCase.user.add;

import com.online.unishop.core.user.service.UsersService;
import com.online.unishop.useCase.UseCaseAbstract;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class AddUser extends UseCaseAbstract<AddUserInput, Object> {

    /* protected abstract OUTPUT doLogic(INPUT input); - все что ниже будет записываться нужно приводить к этому типу */

    private final UsersService usersService;

    @Override
    protected Object doLogic(AddUserInput addUserInput) {
        if (addUserInput.getFullName().isEmpty())
            throw new IllegalArgumentException("User fullName must be is empty");

        if (addUserInput.getFullName().contains("+-/*1234567890!@#$%^&*(_"))
            throw new IllegalArgumentException("User fullName must not contain characters");

        if (addUserInput.getPhoneNumber().isEmpty())
            throw new IllegalArgumentException("User phoneNumber must be is empty");

        if (addUserInput.getPhoneNumber().contains("absdefghigklmnopqrstvwxyz"))
            throw new IllegalArgumentException("User phoneNumber must contain only numbers");

        usersService.addNewUser(

                addUserInput.getLogin(),
                addUserInput.getPassword(),
                addUserInput.getFullName(),
                addUserInput.getBirthDate(),
                addUserInput.getPhoneNumber(),
                addUserInput.getProfileAvatar()
        );
        return null;
    }


}
