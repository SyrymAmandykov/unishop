package com.online.unishop.web.user_profile;

import com.online.unishop.core.role.Role;
import com.online.unishop.core.user.service.UsersService;
import com.online.unishop.useCase.user.delete.DeleteUser;
import com.online.unishop.useCase.user.delete.DeleteUserInput;
import com.online.unishop.useCase.user.update.UpdateUser;
import com.online.unishop.useCase.user.update.UpdateUserInput;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/unishop")
@RequiredArgsConstructor
public class UserProfileController {

    private final UsersService usersService;
    private final UpdateUser updateUser;
    private final DeleteUser deleteUser;

    @GetMapping("/profile/{userId}")
    public String getUserProfile(
            @PathVariable("userId") Long userId,
            Model model
    ){
        model.addAttribute("User_profile", usersService.getUserById(userId));
        return "profile";
    }

    @PostMapping("/profile/{userId}/update")
    public String updateUser(
            @PathVariable("userId") Long userId,
            @RequestParam("user_login_profile") String updateLogin,
            @RequestParam("user_password_profile") String updatePassword,
            @RequestParam("user_fullName_profile") String updateFullName,
            @RequestParam("user_birthDate_profile") String updateBirthDate,
            @RequestParam("user_phoneNumber_profile") String updatePhoneNumber,
            @RequestParam("user_role_profile") Role updateRole
    ){
            updateUser.handle(new UpdateUserInput(userId,updateLogin,updatePassword,updateFullName,updateBirthDate,updatePhoneNumber,null,updateRole));
            return "redirect:/profile" + userId;
    }

    @PostMapping("/profile/{userId}/delete")
    public String deleteUser(
            HttpSession httpSession,
            @PathVariable("userId") Long userId
    ){
        httpSession.removeAttribute("deleteAccount");
        deleteUser.handle(new DeleteUserInput(userId));
        return "redirect:/auth/login";
    }
}
