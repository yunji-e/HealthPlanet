package com.dongduk.HealthPlanet.controller.meeting;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.dongduk.HealthPlanet.service.MeetingService;
import com.dongduk.HealthPlanet.domain.Post;

import java.util.List;

@Controller
public class MeetingController {

    @Autowired
    private MeetingService meetingService;

    @GetMapping("/searchMeetings")
    public ModelAndView searchMeetings(@RequestParam int event,
                                       @RequestParam String time,
                                       @RequestParam int headcount,
                                       @RequestParam int cost) {
        List<Post> meetings = meetingService.searchMeetings(event, time, headcount, cost);
        ModelAndView mav = new ModelAndView("searchResults");
        mav.addObject("meetings", meetings);
        return mav;
    }
}
