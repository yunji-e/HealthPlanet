package com.dongduk.HealthPlanet.controller.search;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.dongduk.HealthPlanet.domain.Post;
import com.dongduk.HealthPlanet.service.MeetingService;

import java.util.List;

@Controller
public class SearchController {

    @Autowired
    private MeetingService meetingService;

    @GetMapping("/meetings/search")
    public String showSearchForm() {
        return "meetingSearch";
    }

    @GetMapping("/meetings/results")
    public String searchMeetings(
            @RequestParam("meetingEvent") int meetingEvent,
            @RequestParam("meetingTime") String meetingTime,
            @RequestParam("headCount") int headCount,
            @RequestParam("price") int price,
            Model model) {
        
        List<Post> meetings = meetingService.searchMeetings(meetingEvent, meetingTime, headCount, price);
        model.addAttribute("meetings", meetings);
        return "meetingResults"; // 검색 결과를 보여줄 뷰의 이름을 수정
    }
}


