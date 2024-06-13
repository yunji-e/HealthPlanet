package com.dongduk.HealthPlanet.controller.myPage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.dongduk.HealthPlanet.model.Post;
import com.dongduk.HealthPlanet.model.dao.jpa.JpaUserDao;

@Controller
public class postUpdateViewController {
    
    @Autowired
    private JpaUserDao jpaUserDao;

    @RequestMapping("/myPage/postUpdateView")    
    public String handleRequest(
            @RequestParam("postid") int postid,
            ModelMap model) throws Exception {
        Post post = jpaUserDao.findUpdatePost(postid);    
        model.addAttribute("post", post);
        return "updateMyPost"; 
    }
    
}
