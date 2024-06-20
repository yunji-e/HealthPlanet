package com.dongduk.HealthPlanet.controller.myPage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.dongduk.HealthPlanet.dao.jpa.JpaUserDao;

@Controller
public class PostDeleteController {
    
    @Autowired
    private JpaUserDao jpaUserDao;

    @RequestMapping("/myPage/deletePost")    
    public String handleRequest(
            @RequestParam("id") int id,
            @RequestParam("postid") int postid) throws Exception {
        jpaUserDao.deletePost(postid);    
        return "redirect:/myPage/deletePost"; 
    }

}
