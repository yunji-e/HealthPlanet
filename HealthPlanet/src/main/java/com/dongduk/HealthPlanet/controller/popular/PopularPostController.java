package com.dongduk.HealthPlanet.controller.popular;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.dongduk.HealthPlanet.dao.jpa.JpaPostPreviewDao;
import com.dongduk.HealthPlanet.domain.Post;

@Controller
public class PopularPostController {

    @Autowired
    private JpaPostPreviewDao jpaPostPreviewDao;
    
    @RequestMapping({"/popular/list"})
    public String handleRequest(
            @RequestParam("sort") String sort,
            Model model) throws Exception {
        List<Post> popularList = jpaPostPreviewDao.findPopularPreviewList(sort, 100);
        model.addAttribute(popularList);
        return "list";
    }   
 
    @RequestMapping({"/popular/preview"})
    public String handleRequest2(
            @RequestParam("sort") String sort,
            Model model) throws Exception {
        List<Post> popularPreviewList = jpaPostPreviewDao.findPopularPreviewList(sort, 10);
        model.addAttribute(popularPreviewList);
        return "preview";
    }
}