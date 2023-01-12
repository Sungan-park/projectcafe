package com.example.cafe.Controller;

import com.example.cafe.DTO.UserDto;
import com.example.cafe.Service.*;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@Controller
@AllArgsConstructor
public class CafeController {

    private final UserService userService;
    /*main*/
    @GetMapping({ "/", "/main" })
    public String home() {
        return "main";
    }
    /*회원가입*/
    @GetMapping("/signUp")
    public String signUp(Model model) {
        model.addAttribute("userDto", new UserDto());
        return "/join_login/signUp";
    }
    @PostMapping("/signUp")
    public String signUp(@ModelAttribute("userDto") UserDto userDto) {
        userService.insert(userDto);
        return "redirect:/join_login/login";
    }


   /*로그인*/
   @GetMapping("/login")
    public String login(HttpServletRequest request){

        return "/join_login/login";
    }

}
