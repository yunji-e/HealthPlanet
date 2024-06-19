package com.dongduk.HealthPlanet.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dongduk.HealthPlanet.dao.jpa.PostRepository;
import com.dongduk.HealthPlanet.domain.Post;

import java.util.List;

@Service
public class MeetingService {

    @Autowired
    private PostRepository postRepository;

    public List<Post> searchMeetings(String meetingEvent, String meetingCity, String meetingCounty, String meetingTime, String headCount, String price) {
        return postRepository.findMeetings(meetingEvent, meetingCity, meetingCounty, meetingTime, headCount, price);
    }
}
