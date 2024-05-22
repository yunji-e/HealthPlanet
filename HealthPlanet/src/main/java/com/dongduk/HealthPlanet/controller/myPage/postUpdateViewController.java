package com.dongduk.HealthPlanet.controller.myPage;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dongduk.HealthPlanet.controller.Controller;
import com.dongduk.HealthPlanet.model.Post;
import com.dongduk.HealthPlanet.model.service.UserManager;

public class postUpdateViewController implements Controller {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {          
        
        UserManager manager = UserManager.getInstance();
        int postId = Integer.parseInt(request.getParameter("postId"));
        
        Post myPost = manager.findUpdatePost(postId);    
        request.setAttribute("myPost", myPost);  
        
        return "/user/updateMyPost.jsp";                
    }
}