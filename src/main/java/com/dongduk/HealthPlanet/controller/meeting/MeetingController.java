package com.dongduk.HealthPlanet.controller.meeting;

import com.dongduk.HealthPlanet.entities.Meeting;
import com.dongduk.HealthPlanet.repositories.MeetingRepository;

import jakarta.transaction.Transactional;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/meetings")
public class MeetingController {

    @Autowired
    private MeetingRepository meetingRepository;

    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        model.addAttribute("meeting", new Meeting());
        return "register-meeting";
    }

    @PostMapping("/register")
    @Transactional
    public String registerMeeting(@ModelAttribute Meeting meeting, Model model) {
        meetingRepository.save(meeting); 
        model.addAttribute("meeting", meeting);
        return "register-confirm";
    }

    
    @GetMapping("/register-finish")
    public String showRegisterFinishPage() {
        return "register-finish";
    }
    @GetMapping("/search")
    public String showSearchForm(Model model) {
        model.addAttribute("meeting", new Meeting());
        return "search-meeting";
    }

    @PostMapping("/search")
    public String searchMeetings(@ModelAttribute Meeting meeting, Model model) {
        String event = meeting.getEvent();
        List<Meeting> meetings = null;

        if (event != null) {
            meetings = meetingRepository.findByEvent(event);
        } else {
            meetings = Collections.emptyList(); // 빈 목록 반환
        }

        model.addAttribute("meetings", meetings);
        return "search-result";
    }


    @GetMapping("/search-result")
    public String showSearchResultPage() {
        return "search-result";
    }
}

