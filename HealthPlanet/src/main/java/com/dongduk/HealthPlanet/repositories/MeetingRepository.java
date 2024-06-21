package com.dongduk.HealthPlanet.repositories;

import com.dongduk.HealthPlanet.entities.*;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MeetingRepository extends JpaRepository<Meeting, Long> {
}

