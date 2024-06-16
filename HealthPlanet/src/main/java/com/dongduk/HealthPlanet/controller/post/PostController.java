package com.dongduk.HealthPlanet.controller.post;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.dongduk.HealthPlanet.domain.Post;
import com.dongduk.HealthPlanet.dao.jpa.JpaPostDao;

@Controller
public class PostController {
    
    @Autowired
    private JpaPostDao jpaPostDao;

    @RequestMapping({"/post/view", "/search/post"})    
    public String handleRequest(
            @RequestParam("postid") int postid,
            ModelMap model) throws Exception {
        Post post = jpaPostDao.findPost(postid);    
        model.addAttribute("post", post);
        return "meetingView"; 
    }

}
