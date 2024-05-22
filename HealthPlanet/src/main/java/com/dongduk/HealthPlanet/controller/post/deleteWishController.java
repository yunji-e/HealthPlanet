package com.dongduk.HealthPlanet.controller.post;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dongduk.HealthPlanet.controller.Controller;
import com.dongduk.HealthPlanet.model.service.PostManager;

public class deleteWishController implements Controller {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {          
        
        PostManager manager = PostManager.getInstance();
        int userId = Integer.parseInt(request.getParameter("id"));
        int postId = Integer.parseInt(request.getParameter("postid"));
        
        manager.deleteWish(userId, postId);    
        return "redirect:/post/view";
    }
}