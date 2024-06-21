package com.dongduk.HealthPlanet.controller.post;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.dongduk.HealthPlanet.dao.jpa.JpaPostDao;
import com.dongduk.HealthPlanet.dao.jpa.PostRepository;

import jakarta.servlet.http.HttpSession;

@Controller
public class AddWishController {
    
    @Autowired
    private JpaPostDao jpaPostDao;

    @RequestMapping("/post/addWish")    
    public String handleRequest(
            @RequestParam("postid") int postid,
            HttpSession session,
            ModelMap model) throws Exception {
        Object id = session.getAttribute("userid");
        if(id != null) {
            jpaPostDao.addWish((int)id, postid); //해당 부분 error
            return "redirect:/view";
        } else {
            return "login";
        }
         
    }

}
