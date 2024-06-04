package com.dongduk.HealthPlanet.domain;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Post {
    @Id
    private int postid;
    
    private String title;
    private LocalDate schedule;
    private String place;
    private int headcount;
    private int cost;
    private String body;
    
    private int view;
    private int wish;
    private int state;
    
    //Customer PK
    private int id;
    
    //SportsCategory PK
    private int event;
}
