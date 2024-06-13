package com.dongduk.HealthPlanet.controller.post;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.dongduk.HealthPlanet.model.dao.jpa.JpaPostDao;

@Controller
public class cancelPostController {
    
    @Autowired
    private JpaPostDao jpaPostDao;

    @RequestMapping("post/cancelPost")    
    public String handleRequest(
            @RequestParam("id") int id,
            @RequestParam("postid") int postid,
            ModelMap model) throws Exception {
        jpaPostDao.cancelPost(id, postid);    
        return "redirect:/view"; 
    }
   
}
