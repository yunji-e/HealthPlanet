package com.dongduk.HealthPlanet.controller.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.dongduk.HealthPlanet.service.UserService;

import jakarta.servlet.http.HttpSession;

@Controller
public class LoginController {

    @Autowired
    private UserService userService;

    @GetMapping("/login")
    public String showLoginForm() {
        return "login";
    }

    @PostMapping("/login")
    public String handleLogin(
            @RequestParam("custid") String custid,
            @RequestParam("custpw") String custpw,
            ModelMap model,
            HttpSession session) {

        try {
            
            if (userService.authenticate(custid, custpw)) {
                int id = userService.findUser(custid, custpw).getId();
                session.setAttribute("username", custid);
                session.setAttribute("userid", id);
                return "redirect:/main";
            } else {
                model.addAttribute("error", "Invalid username or password.");
                return "login";
            }
        } catch (NumberFormatException e) {
            model.addAttribute("error", "Invalid user ID format.");
            return "login";
        }
    }

    @GetMapping("/logout")
    public String handleLogout(HttpSession session) {
        session.invalidate();
        return "redirect:/";
    }
}

