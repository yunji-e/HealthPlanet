package com.dongduk.HealthPlanet.controller.post;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.dongduk.HealthPlanet.dao.jpa.JpaPostDao;

@Controller
public class ParticipatePostController {
    
    @Autowired
    private JpaPostDao jpaPostDao;

    @RequestMapping("/post/participate")    
    public String handleRequest(
            @RequestParam("id") int id,
            @RequestParam("postid") int postid) throws Exception {
        jpaPostDao.participatePost(id, postid);    
        return "redirect:/view"; 
    }

}
