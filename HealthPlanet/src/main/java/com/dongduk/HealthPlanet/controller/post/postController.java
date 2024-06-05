package com.dongduk.HealthPlanet.controller.post;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dongduk.HealthPlanet.controller.Controller;
import com.dongduk.HealthPlanet.domain.Post;
import com.dongduk.HealthPlanet.service.PostManager;

public class postController implements Controller {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {          
        
        PostManager manager = PostManager.getInstance();
        int postId = Integer.parseInt(request.getParameter("postid"));
        
        Post post = manager.findPost(postId);    
        request.setAttribute("post", post);  
        
        return "/post/view.jsp";                
    }
}
