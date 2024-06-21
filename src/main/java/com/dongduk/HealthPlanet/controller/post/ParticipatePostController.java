package com.dongduk.HealthPlanet.controller.post;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.dongduk.HealthPlanet.dao.jpa.JpaPostDao;

import jakarta.servlet.http.HttpSession;

@Controller
public class ParticipatePostController {
    
    @Autowired
    private JpaPostDao jpaPostDao;

    @RequestMapping("/post/participate")    
    public String handleRequest(
            @RequestParam("postid") int postid,
            HttpSession session
            ) throws Exception {
        Object id = session.getAttribute("userid");
        if(id != null) {
            jpaPostDao.participatePost((int)id, postid); //해당 부분 이상한거같음
            return "redirect:/view";
        } else {
            return "login";            
        }
    }

}
