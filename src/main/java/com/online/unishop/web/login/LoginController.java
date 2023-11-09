package com.online.unishop.web.login;

import com.online.unishop.useCase.user.login.LoginInput;
import com.online.unishop.useCase.user.login.LoginUser;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/auth/login")
@RequiredArgsConstructor
public class LoginController {

    private final LoginUser loginUser;

    @GetMapping
    public String getLoginPage() {
        return "Login_page";
    }

    @PostMapping
    public String login(
            @RequestParam("user_login") String login,
            @RequestParam("user_password") String password,
            HttpSession httpSession
    ){

    Long userid = loginUser.handle(
            new LoginInput(
                    login,
                    password
            )
    );

    if (userid == null){
        return "redirect:/auth/login?credentials_invalid=true";
    }
        httpSession.setAttribute("current_user",userid);
    return "redirect:/tovary";
    }

}
