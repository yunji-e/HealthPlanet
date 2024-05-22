package com.dongduk.HealthPlanet.controller.myPage;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dongduk.HealthPlanet.controller.Controller;
import com.dongduk.HealthPlanet.model.Post;
import com.dongduk.HealthPlanet.model.service.UserManager;

public class myPostListController implements Controller {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {          
        
        UserManager manager = UserManager.getInstance();
        int userId = Integer.parseInt(request.getParameter("id"));
        
        List<Post> myPostList = manager.findMyPostList(userId);    
        request.setAttribute("myPostList", myPostList);  
        
        return "/user/myPostList.jsp";                
    }
}
