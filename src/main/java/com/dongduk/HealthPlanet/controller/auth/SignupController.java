package com.dongduk.HealthPlanet.controller.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
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
    public String handleSignup(
            @RequestParam("custid") String custid,
            @RequestParam("custpw") String custpw,
            @RequestParam("custname") String custname,
            @RequestParam("phone") String phone,
            ModelMap model) {

        if (userService.isUsernameTaken(custid)) {
            model.addAttribute("error", "Username is already taken.");
            return "signup";
        }

        User user = new User();
        user.setCustid(custid);
        user.setCustpw(custpw);
        user.setCustname(custname);
        user.setPhone(phone);

        userService.registerUser(user);
        return "redirect:/login";
    }
}

