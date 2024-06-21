package com.dongduk.HealthPlanet.dao.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.dongduk.HealthPlanet.domain.Post;

import java.util.List;

@Repository
public interface PostRepository extends JpaRepository<Post, Integer> {

    @Query("SELECT p FROM Post p WHERE p.event = :event AND p.time = :time AND p.headcount = :headcount AND p.cost = :cost")
    List<Post> findMeetings(@Param("event") int event, 
                            @Param("time") String time, 
                            @Param("headcount") int headcount, 
                            @Param("cost") int cost);
    
}

