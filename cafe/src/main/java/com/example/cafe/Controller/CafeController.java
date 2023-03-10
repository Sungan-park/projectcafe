package com.example.cafe.Controller;

import com.example.cafe.DTO.Cafe;
import com.example.cafe.DTO.Review;
import com.example.cafe.DTO.UserDto;
import com.example.cafe.Entity.CafeEntity;
import com.example.cafe.Entity.ReviewEntity;
import com.example.cafe.Service.*;
import com.example.cafe.model.User;
import lombok.AllArgsConstructor;

import org.springframework.boot.Banner;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
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

    CafeService cafeService;
    private final UserServiceIMP userService;
    ReviewService reviewService;
    /*main*/
    @GetMapping({"/", "/main"})
    public String home() {

        return "main";
    }

    /*main_search*/
    @GetMapping("/search")
    public String search(Model model,
                         @PageableDefault(page = 0, size = 10, sort = "id", direction = Sort.Direction.DESC) Pageable pageable,
                         String keyword) {
        Page<CafeEntity> list = null;

        if (keyword == null) {
            // 검색 단어가 없으면 기존 화면을 보여준다.
            list = cafeService.cafelist(pageable);
        } else {

            // 검색 단어가 들어오면 검색 단어에 맞게 나온다. 쿼리스트링으로 들어가는 키워드를 찾아냄
            list = cafeService.cafeSearchList(keyword, pageable);
        }


        //페이지블럭 처리
        //1을 더해주는 이유는 pageable은 0부터라 1을 처리하려면 1을 더해서 시작해주어야 한다.
        int nowPage = list.getPageable().getPageNumber() + 1;
        //-1값이 들어가는 것을 막기 위해서 max값으로 두 개의 값을 넣고 더 큰 값을 넣어주게 된다.
        int startPage = Math.max(nowPage - 4, 1);
        int endPage = Math.min(nowPage + +9, list.getTotalPages());


        model.addAttribute("list", list);
        model.addAttribute("nowPage", nowPage);
        model.addAttribute("startPage", startPage);
        model.addAttribute("endPage", endPage);

        return "/cafe/cafesearchlist";
    }

    /*main_typelist*/
    @GetMapping("/typelist")
    public String typelist(Model model, @PageableDefault(page = 0, size = 10, sort = "id", direction = Sort.Direction.DESC) Pageable pageable,
                           String ctype) {
        Page<CafeEntity> list = null;

        if (ctype.equals("사진맛집")) {
            list = cafeService.typelist(ctype, pageable);
        } else if (ctype.equals("베이커리맛집")) {
            list = cafeService.typelist(ctype, pageable);
        } else if (ctype.equals("뷰맛집")) {
            list = cafeService.typelist(ctype, pageable);
        } else {
            list = cafeService.typelist(ctype, pageable);
        }

        /*Page<CafeEntity> list = cafeService.typelist(ctype, pageable);*/
        int nowPage = list.getPageable().getPageNumber() + 1;
        int startPage = Math.max(nowPage - 4, 1);
        int endPage = Math.min(nowPage + +5, list.getTotalPages());


        model.addAttribute("list", list);
        model.addAttribute("nowPage", nowPage);
        model.addAttribute("startPage", startPage);
        model.addAttribute("endPage", endPage);
        return "/cafe/cafeout";
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
    public String login(HttpServletRequest request) {

        return "/join_login/login";
    }

    /*카페 등록 페이지*/
    @GetMapping("/gocinput")
    public String gocinput() {
        return "/cafe/cafeinput";
    }

    @PostMapping("/cinput")
    @ResponseStatus(HttpStatus.CREATED)
    public String cafeinput(@ModelAttribute("Cafe") @Valid Cafe cafe,
                            BindingResult rs,
                            MultipartHttpServletRequest msr) throws IOException {

        MultipartFile mf = msr.getFile("cphoto1");
        MultipartFile mf2 = msr.getFile("cphoto2");
        MultipartFile mf3 = msr.getFile("cphoto3");
        String path = "C:/springboot/projectcafe/cafe/src/main/resources/static/image/";
        String pic = mf.getOriginalFilename();
        String pic2 = mf2.getOriginalFilename();
        String pic3 = mf3.getOriginalFilename();
        String uploadpath = path + pic;
        String uploadpath2 = path + pic2;
        String uploadpath3 = path + pic3;
        mf.transferTo(new File(uploadpath));
        mf2.transferTo(new File(uploadpath2));
        mf3.transferTo(new File(uploadpath3));

        cafe.setCphoto1(pic);
        cafe.setCphoto2(pic2);
        cafe.setCphoto3(pic3);
        CafeEntity cafeEntity = cafe.toCafeEntity();

        cafeService.cafesave(cafeEntity);

        return "main";
    }

    /*카페출력*/
    @GetMapping("/out")
    public String out(Model model, @PageableDefault(page = 0, size = 10, sort = "id", direction = Sort.Direction.DESC) Pageable pageable) {
        Page<CafeEntity> list = cafeService.cafelist(pageable);
        int nowPage = list.getPageable().getPageNumber() + 1;
        int startPage = Math.max(nowPage - 4, 1);
        int endPage = Math.min(nowPage + +5, list.getTotalPages());


        model.addAttribute("list", list);
        model.addAttribute("nowPage", nowPage);
        model.addAttribute("startPage", startPage);
        model.addAttribute("endPage", endPage);

        return "/cafe/cafeout";
    }

    /*카페상세페이지&리뷰*/
    @GetMapping("/cafedetail")
    public String cafeDetail(Model model, Long id, @PageableDefault(page = 0, size = 10, sort = "id", direction = Sort.Direction.DESC) Pageable pageable) {
        model.addAttribute("cafe", cafeService.cafedetail(id));
        Page<ReviewEntity> list = reviewService.reviewlist(pageable);
        int nowPage = list.getPageable().getPageNumber() + 1;
        int startPage = Math.max(nowPage - 4, 1);
        int endPage = Math.min(nowPage + +5, list.getTotalPages());

        model.addAttribute("list", list);
        model.addAttribute("nowPage", nowPage);
        model.addAttribute("startPage", startPage);
        model.addAttribute("endPage", endPage);
        return "/cafe/cafedetail";
    }

    /*리뷰작성*/
    @PostMapping("/review")
    @ResponseStatus(HttpStatus.CREATED)
    public String review(@ModelAttribute("Review") @Valid Review review,
                         BindingResult rs,
                         MultipartHttpServletRequest msr) throws IOException{
        MultipartFile mf = msr.getFile("rphoto");
        String path = "C:/springboot/projectcafe/cafe/src/main/resources/static/image/";
        String pic = mf.getOriginalFilename();
        String uploadpath = path + pic;
        mf.transferTo(new File(uploadpath));
        review.setRphoto(pic);
        ReviewEntity reviewEntity = review.toReviewEntity();
        reviewService.reviewsave(reviewEntity);
        return "redirect:/main";
    }


    /*내정보*/
    @GetMapping("/mypage")
    public String mypage() {

        return "/mypage";
    }

    @GetMapping("/mymodify")
    public String mymodify(Model model) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String name = auth.getName(); //get logged in username
        model.addAttribute("id", name);

        return "/mymodify";
    }


}
