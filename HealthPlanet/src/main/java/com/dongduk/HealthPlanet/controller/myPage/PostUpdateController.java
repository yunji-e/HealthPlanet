package com.dongduk.HealthPlanet.controller.myPage;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dongduk.HealthPlanet.controller.Controller;
import com.dongduk.HealthPlanet.service.UserManager;

public class PostUpdateController implements Controller {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {          
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        
        UserManager manager = UserManager.getInstance();
        int postId = Integer.parseInt(request.getParameter("postId"));
        String title = request.getParameter("title");
        Date schedule = format.parse(request.getParameter("schedule"));
        String time = request.getParameter("time");
        String place = request.getParameter("place");
        int headcount = Integer.parseInt(request.getParameter("headcount"));
        int cost = Integer.parseInt(request.getParameter("cost"));
        String body = request.getParameter("body");
        String sportname = request.getParameter("sportname");
        
        int result = manager.updatePost(postId, title, schedule, time, place, headcount, cost, body, sportname);    
        if (result == 1)
            return "redirect:/myPage/update";
        else
            return "/user/myPost.jsp";
    }
}
