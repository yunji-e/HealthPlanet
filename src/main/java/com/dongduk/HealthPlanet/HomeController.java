package com.dongduk.HealthPlanet;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.dongduk.HealthPlanet.dao.jpa.JpaPostPreviewDao;
import com.dongduk.HealthPlanet.dao.jpa.PostRepository;
import com.dongduk.HealthPlanet.domain.Post;

@Controller
public class HomeController {

    @Autowired
    private JpaPostPreviewDao postPreviewDao;
    @Autowired
    private PostRepository postDao; 

    @GetMapping({"/", "/main"})
    public String home(Model model) throws Exception {
        //findPopularPreviewList(String sort):
        //view, wish로 popular를 측정할 수 있는 method이나,
        //구현 과정에서 간소화시켜 wish값을 고정으로 넘기도록 해두었습니다.
        List<Post> popularList = postPreviewDao.findPopularPreviewList("wish", 10);
        List<Post> postList = postDao.findAll();
        model.addAttribute("popularList", popularList);
        model.addAttribute("list", postList);
        return "main"; // main.html 뷰를 반환합니다.
    }
}

