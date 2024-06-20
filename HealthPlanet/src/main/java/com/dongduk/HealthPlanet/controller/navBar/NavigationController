package com.dongduk.HealthPlanet.controller.navBar;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class NavigationController {

    @GetMapping("/navBar")
    public String navBar(Model model) {
        boolean isLoggedIn = false;
        model.addAttribute("isLoggedIn", isLoggedIn);
        return "navBar"; 
    }
}
