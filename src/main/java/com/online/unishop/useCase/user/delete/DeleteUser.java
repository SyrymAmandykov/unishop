package com.online.unishop.useCase.user.delete;

import com.online.unishop.core.user.service.UsersService;
import com.online.unishop.useCase.UseCaseAbstract;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DeleteUser extends UseCaseAbstract<DeleteUserInput, Object> {

    private final UsersService usersService;

    @Override
    protected Object doLogic(DeleteUserInput deleteUserInput) {

        if (deleteUserInput.getUserId() == null)
            throw new IllegalArgumentException("Invalid user id");

        usersService.deleteUserById(deleteUserInput.getUserId());

        return null;

    }
}
