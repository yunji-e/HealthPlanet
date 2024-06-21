package com.dongduk.HealthPlanet.controller.post;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.dongduk.HealthPlanet.dao.jpa.JpaPostDao;
import com.dongduk.HealthPlanet.domain.Post;

import jakarta.servlet.http.HttpSession;

@Controller
public class AddWishController {
    
    @Autowired
    private JpaPostDao jpaPostDao;

    @RequestMapping("/post/addWish")    
    public String handleRequest(
            @RequestParam("postid") int postid,
            HttpSession session,
            Model model) throws Exception {
        Object id = session.getAttribute("userid");
        if(id != null) {
            jpaPostDao.addWish((int)id, postid);
            Post post = jpaPostDao.findPost(postid);
            model.addAttribute("post", post);
            
           
            return "post";
        } else {
            return "login";
        }
         
    }

}
