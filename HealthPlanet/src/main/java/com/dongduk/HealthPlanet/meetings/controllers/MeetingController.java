package com.example.demo.controllers;

import com.example.demo.entities.Meeting;
import com.example.demo.repositories.MeetingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/meetings")
public class MeetingController {

    private final MeetingRepository meetingRepository;

    @Autowired
    public MeetingController(MeetingRepository meetingRepository) {
        this.meetingRepository = meetingRepository;
    }

    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        model.addAttribute("meeting", new Meeting());
        return "register-meeting";
    }

    @PostMapping("/register")
    public String registerMeeting(@ModelAttribute Meeting meeting, Model model) {
        meetingRepository.save(meeting);
        model.addAttribute("meeting", meeting);
        return "register-confirm";
    }
    
    @GetMapping("/register-finish")
    public String showRegisterFinishPage() {
        return "register-finish";
    }
}
