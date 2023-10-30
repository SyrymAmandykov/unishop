package com.online.unishop.web.authorization;

import com.online.unishop.core.user.service.UsersService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/auth/registration")
@RequiredArgsConstructor
public class AuthorizationController {

    private final UsersService usersService;

    @GetMapping
    public String getregisterPage(){
        return "register_page";
    }

    @PostMapping
    public String addNewUser(
            @RequestParam("user_login") String login,
            @RequestParam("user_password") String password,
            @RequestParam("user_fullName") String fullName,
            @RequestParam("user_birthDate") String birthDate,
            @RequestParam("user_phoneNumber") String phoneNumber
            //RequestParam("user_role") RoleDto roleDto
    ) {

//        usersService.addNewUser(login,password,fullName,birthDate,phoneNumber,null,1l);
//        return "redirect:/login";
            return null;
    }
}
