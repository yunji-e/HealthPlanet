package com.dongduk.HealthPlanet.controller.myPage;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dongduk.HealthPlanet.controller.Controller;
import com.dongduk.HealthPlanet.domain.Post;
import com.dongduk.HealthPlanet.service.UserManager;

public class WishListController implements Controller {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {          

        UserManager manager = UserManager.getInstance();
        int userId = Integer.parseInt(request.getParameter("id"));

        List<Post> wishList = manager.findWishList(userId);    
        request.setAttribute("wishList", wishList);  

        return "/user/wishList.jsp";                
    }
}
