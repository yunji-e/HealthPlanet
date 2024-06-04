package com.dongduk.HealthPlanet.controller.myPage;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dongduk.HealthPlanet.controller.Controller;
import com.dongduk.HealthPlanet.model.Post;
import com.dongduk.HealthPlanet.model.service.UserManager;

public class myPostController implements Controller {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {          
        
        UserManager manager = UserManager.getInstance();
        int userId = Integer.parseInt(request.getParameter("id"));
        int postId = Integer.parseInt(request.getParameter("postid"));
        
        Post myPost = manager.findMyPost(userId, postId);    
        request.setAttribute("myPost", myPost);  
        
        return "/user/myPost.jsp";                
    }
}
