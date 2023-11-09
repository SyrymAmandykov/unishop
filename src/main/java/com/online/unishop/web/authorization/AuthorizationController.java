package com.online.unishop.web.authorization;

import com.online.unishop.core.user.service.UsersService;
import com.online.unishop.useCase.user.add.AddUser;
import com.online.unishop.useCase.user.add.AddUserInput;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import static com.online.unishop.core.role.Role.USER;

@Controller
@RequestMapping("/auth/registration")
@RequiredArgsConstructor
public class AuthorizationController {

    private final AddUser addUser;

    @GetMapping
    public String getRegisterPage() {
        return "register_page";
    }

    @PostMapping
    public String addUsers(
            @RequestParam("user_login") String login,
            @RequestParam("user_password") String password,
            @RequestParam("user_fullName") String fullName,
            @RequestParam("user_birthDate") String birthDate,
            @RequestParam("user_phoneNumber") String phoneNumber

    ) {
        addUser.handle(new AddUserInput(
                login,
                password,
                fullName,
                birthDate,
                phoneNumber,
                null));

        return "redirect:/login";
    }
}
