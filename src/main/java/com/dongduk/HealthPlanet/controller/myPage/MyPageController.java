package com.dongduk.HealthPlanet.controller.myPage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import com.dongduk.HealthPlanet.dao.jpa.UserRepository;
import com.dongduk.HealthPlanet.domain.User;

import jakarta.servlet.http.HttpSession;

@Controller
public class MyPageController {
    @Autowired
    private UserRepository userRepository;
    
    @GetMapping("/myPage")
    public String home(
            HttpSession session,
            ModelMap model) {
        String custid = (String) session.getAttribute("username");
        User user = userRepository.findByCustid(custid);
        if (user != null) {
            model.addAttribute("user", user);
        }
        return "myPage"; // 이는 templates/myPage.html을 의미함
    }
}
