package com.dongduk.HealthPlanet.controller.myPage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.dongduk.HealthPlanet.domain.Post;
import com.dongduk.HealthPlanet.dao.jpa.JpaUserDao;

@Controller
public class PostUpdateController {
    
    @Autowired
    private JpaUserDao jpaUserDao;
    
    // 수정하기 버튼 눌러서 수정페이지로 이동
    @GetMapping("/myPage/updatePost")    
    public String handleRequest(
            @RequestParam("postid") int postid,
            ModelMap model) throws Exception {
        Post post = jpaUserDao.findUpdatePost(postid);    
        model.addAttribute("post", post);
        return "updateMyPost"; 
    }
    
    // 수정페이지에서 수정완료 버튼 눌렀을 때
    @PostMapping("/myPage/updatePost")    
    public String handleRequest(
            @RequestParam("postid") int postid,
            @ModelAttribute("post") Post post) throws Exception {
        jpaUserDao.UpdatePost(post);   
        return "redirect:/myPage/updatePost";
    }

}
