package com.dongduk.HealthPlanet.controller.post;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dongduk.HealthPlanet.dao.jpa.JpaPostDao;
import com.dongduk.HealthPlanet.domain.Post;

@Controller
public class PostController {
    
    @Autowired
    private JpaPostDao jpaPostDao;

    @RequestMapping({"/post/view/{postid}", "/search/post/{postid}"})    
    public String handleRequest(
            @PathVariable("postid") int postid,
            ModelMap model) throws Exception {
        Post post = jpaPostDao.findPost(postid);    
        jpaPostDao.postViewCountUp(postid);
        model.addAttribute("post", post);
        return "post"; 
    }

}
