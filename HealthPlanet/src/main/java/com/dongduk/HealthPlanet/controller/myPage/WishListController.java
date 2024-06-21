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
public class WishListController {
    
    @Autowired
    private JpaUserDao jpaUserDao;

    @RequestMapping("/myPage/wishList")    
    public String handleRequest(
            @RequestParam("userId") int id,
            ModelMap model) throws Exception {
        List<Post> list = jpaUserDao.findWishList(id);
        System.out.println("aaaaa"+list);
        
        // 리스트가 null이거나 비어 있는 경우 처리
        if (list == null || list.isEmpty()) {
            System.out.println("bbbbb"+list);
            model.addAttribute("message", "찜한 모임이 없습니다.");
        } else {
            System.out.println("ccccc"+list);
            model.addAttribute("list", list);
        }
        return "wishList"; 
    }

}
