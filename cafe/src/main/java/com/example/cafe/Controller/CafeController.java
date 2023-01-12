package com.example.cafe.Controller;

import com.example.cafe.DTO.Cafe;
import com.example.cafe.DTO.UserDto;
import com.example.cafe.Entity.CafeEntity;
import com.example.cafe.Service.*;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.io.File;
import java.io.IOException;

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

    /*카페 등록 페이지*/
    @GetMapping("/gocinput")
    public String gocinput(){
        return "/cafe/cafeinput";
    }

    CafeService cafeService;

    @PostMapping("/cinput")
    @ResponseStatus(HttpStatus.CREATED)
    public String cafeinput(@ModelAttribute("Cafe") @Valid Cafe cafe,
                            BindingResult rs,
                            MultipartHttpServletRequest msr) throws IOException {

        MultipartFile mf = msr.getFile("cphoto1");
        MultipartFile mf2= msr.getFile("cphoto2");
        MultipartFile mf3 = msr.getFile("cphoto3");
        String path ="C:/springboot/projectcafe-master/cafe/src/main/resources/static/image";
        String pic = mf.getOriginalFilename();
        String pic2 = mf2.getOriginalFilename();
        String pic3 = mf3.getOriginalFilename();
        String uploadpath = path + pic;
        mf.transferTo(new File(uploadpath));
        cafe.setCphoto1(pic);
        cafe.setCphoto2(pic2);
        cafe.setCphoto3(pic3);
        CafeEntity cafeEntity = cafe.toCafeEntity();

        cafeService.cafesave(cafeEntity);

        return "redirect:gocinput";
    }

}
