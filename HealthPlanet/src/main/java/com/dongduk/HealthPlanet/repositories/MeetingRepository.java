package com.dongduk.HealthPlanet.repository.meeting;

import com.example.demo.entities.Meeting;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MeetingRepository extends JpaRepository<Meeting, Long> {
}

