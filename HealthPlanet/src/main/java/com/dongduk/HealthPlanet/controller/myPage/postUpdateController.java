package com.dongduk.HealthPlanet.controller.myPage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.dongduk.HealthPlanet.model.Post;
import com.dongduk.HealthPlanet.model.dao.jpa.JpaUserDao;

@Controller
public class postUpdateController {
    
    @Autowired
    private JpaUserDao jpaUserDao;

    @RequestMapping("/myPage/updatePost")    
    public String handleRequest(
            @RequestParam("postid") int postid,
            @ModelAttribute("post") Post post) throws Exception {
        jpaUserDao.UpdatePost(post);   
        return "redirect:/myPage/update";
    }
    
}
