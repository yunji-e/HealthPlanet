package com.dongduk.HealthPlanet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.dongduk.HealthPlanet.dao.jpa.JpaPostPreviewDao;
import com.dongduk.HealthPlanet.domain.Post;
import java.util.List;

@Controller
public class HomeController {

    @Autowired
    private JpaPostPreviewDao postPreviewDao;

    @GetMapping({"/", "/main"})
    public String home(Model model) throws Exception {
        List<Post> popularList = postPreviewDao.findPopularPreviewList("wish", 10);
        model.addAttribute("popularList", popularList);
        return "main"; // main.html 뷰를 반환합니다.
    }
}

