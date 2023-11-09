package com.online.unishop.useCase.user.login;

import com.online.unishop.core.user.dto.UsersDto;
import com.online.unishop.core.user.service.UsersService;
import com.online.unishop.useCase.UseCaseAbstract;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class LoginUser extends UseCaseAbstract<LoginInput, Long> {

    private final UsersService usersService;

    @Override
    protected Long doLogic(LoginInput loginInput) {

        UsersDto user = usersService.getUserByLoginAndPassword(
                loginInput.getLogin(),
                loginInput.getPassword()
        );

        return user == null ? null : user.getId();
    }
}
