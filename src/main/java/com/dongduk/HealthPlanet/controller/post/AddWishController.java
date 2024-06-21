package com.dongduk.HealthPlanet.controller.post;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.dongduk.HealthPlanet.dao.jpa.JpaPostDao;
import com.dongduk.HealthPlanet.dao.jpa.UserRepository;
import com.dongduk.HealthPlanet.domain.Post;
import com.dongduk.HealthPlanet.domain.User;
import com.dongduk.HealthPlanet.domain.Wish;
import com.dongduk.HealthPlanet.repositories.WishRepository;

import jakarta.servlet.http.HttpSession;

@Controller
public class AddWishController {
    
    @Autowired
    private UserRepository userRepository;
    
    @Autowired
    private WishRepository wishRepository;
    
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
            
            Optional<User> user = userRepository.findById((int)id);
            model.addAttribute("user", user.get());
            
            Wish wish = wishRepository.findByIdAndPostid((int)id, postid);
            model.addAttribute("wish", wish);
            
            Post post = jpaPostDao.findPost(postid);
            model.addAttribute("post", post);
           
            return "meetingView";
        } else {
            return "login";
        }
         
    }

}
