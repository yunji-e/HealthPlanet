package com.dongduk.HealthPlanet.controller.post;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.dongduk.HealthPlanet.domain.Post;
import com.dongduk.HealthPlanet.domain.User;
import com.dongduk.HealthPlanet.domain.Wish;
import com.dongduk.HealthPlanet.repositories.WishRepository;

import jakarta.servlet.http.HttpSession;

import com.dongduk.HealthPlanet.dao.jpa.JpaPostDao;
import com.dongduk.HealthPlanet.dao.jpa.UserRepository;

@Controller
public class PostController {
    
    @Autowired
    private UserRepository userRepository;
    
    @Autowired
    private WishRepository wishRepository;
    
    @Autowired
    private JpaPostDao jpaPostDao;

    @RequestMapping({"/post/view/{postid}", "/search/post/{postid}"})    
    public String handleRequest(
            @PathVariable("postid") int postid,
            HttpSession session,
            ModelMap model) throws Exception {
        Post post = jpaPostDao.findPost(postid); 
        model.addAttribute("post", post);
        
        String custid = (String) session.getAttribute("username");
        User user = userRepository.findByCustid(custid);
        if (user != null) {
            model.addAttribute("user", user);
        }
        
        Wish wish = wishRepository.findByIdAndPostid(user.getId(), postid);
        if (wish != null) {
            model.addAttribute("wish", wish);
        }
        
        System.out.println("post.id(게시글 쓴 사람) = "+post.getId());
        System.out.println("user.id(로그인 한 사람) = "+user.getId());
        
        return "meetingView"; 
    }

}
