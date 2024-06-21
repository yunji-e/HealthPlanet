package com.dongduk.HealthPlanet.repositories;

import com.dongduk.HealthPlanet.entities.*;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MeetingRepository extends JpaRepository<Meeting, Long> {
    List<Meeting> findByEvent(String event);
}

