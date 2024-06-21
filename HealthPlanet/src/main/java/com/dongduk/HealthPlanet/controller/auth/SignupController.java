package com.dongduk.HealthPlanet.controller.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.dongduk.HealthPlanet.domain.User;
import com.dongduk.HealthPlanet.service.UserService;

@Controller
public class SignupController {

    @Autowired
    private UserService userService;

    @GetMapping("/signup")
    public String showSignupForm() {
        return "signup";
    }

    @PostMapping("/signup")
    public String signup(@RequestParam("custid") String custid,
                         @RequestParam("custpw") String custpw,
                         @RequestParam("custname") String custname,
                         @RequestParam("phone") String phone,
                         Model model) {
        // custid 중복 체크는 더 이상 필요하지 않음
        User user = new User(custid, custpw, custname, phone);
        userService.registerUser(user);

        return "redirect:/"; // 회원가입 성공 시 메인으로 리다이렉트
    }
}
