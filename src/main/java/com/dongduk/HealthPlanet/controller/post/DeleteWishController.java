package com.dongduk.HealthPlanet.controller.post;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.dongduk.HealthPlanet.dao.jpa.JpaPostDao;

@Controller
public class DeleteWishController {
    
    @Autowired
    private JpaPostDao jpaPostDao;

    @RequestMapping("/post/deleteWish")    
    public String handleRequest(
            @RequestParam("Id") int id,
            @RequestParam("postid") int postid,
            ModelMap model) throws Exception {
        jpaPostDao.deleteWish(id, postid);   
        return "redirect:/view"; 
    }

}
