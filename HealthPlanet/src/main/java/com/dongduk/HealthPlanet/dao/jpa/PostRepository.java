package com.dongduk.HealthPlanet.dao.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dongduk.HealthPlanet.domain.Post;

import java.util.List;

@Repository
public interface PostRepository extends JpaRepository<Post, Integer> {
    List<Post> findMeetings(String meetingEvent, String meetingCity, String meetingCounty, String meetingTime, String headCount, String price);
}
