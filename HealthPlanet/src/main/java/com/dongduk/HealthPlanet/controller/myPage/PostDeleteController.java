package com.dongduk.HealthPlanet.controller.myPage;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dongduk.HealthPlanet.controller.Controller;
import com.dongduk.HealthPlanet.service.UserManager;

public class PostDeleteController implements Controller {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {          
        
        UserManager manager = UserManager.getInstance();
        int postId = Integer.parseInt(request.getParameter("postid"));
        
        int result = manager.deletePost(postId);    
        if (result == 1)
            return "redirect:/myPage/delete";
        else
            return "/user/myPost.jsp";               
    }
}
