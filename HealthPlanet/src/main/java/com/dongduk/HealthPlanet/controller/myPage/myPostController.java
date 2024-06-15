package com.dongduk.HealthPlanet.controller.myPage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.dongduk.HealthPlanet.model.Post;
import com.dongduk.HealthPlanet.model.dao.jpa.JpaUserDao;

@Controller
public class myPostController {
    
    @Autowired
    private JpaUserDao jpaUserDao;

    @RequestMapping("/myPage/myPost")    
    public String handleRequest(
            @RequestParam("id") int id,
            @RequestParam("postid") int postid,
            ModelMap model) throws Exception {
        Post post = jpaUserDao.findMyPost(id, postid);    
        model.addAttribute("post", post);
        return "meetingView"; 
    }
                      
}
