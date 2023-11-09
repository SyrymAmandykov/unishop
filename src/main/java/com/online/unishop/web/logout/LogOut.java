package com.online.unishop.web.logout;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/auth/login")
@RequiredArgsConstructor
public class LogOut {

    @PostMapping("logOut")
    public String logOut(HttpSession httpSession){
        httpSession.removeAttribute("logOut");
        return "redirect:/auth/login";
    }
}
