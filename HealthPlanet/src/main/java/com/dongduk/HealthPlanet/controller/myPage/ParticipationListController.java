package com.dongduk.HealthPlanet.controller.myPage;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.dongduk.HealthPlanet.domain.Post;
import com.dongduk.HealthPlanet.dao.jpa.JpaUserDao;

@Controller
public class ParticipationListController {
    
    @Autowired
    private JpaUserDao jpaUserDao;

    @RequestMapping("/myPage/participationList")    
    public String handleRequest(
            @RequestParam("id") int id,
            ModelMap model) throws Exception {
        List<Post> list = jpaUserDao.findParticipationList(id);    
        model.addAttribute("list", list);
        return "participationList"; 
    }

}
