package com.dongduk.HealthPlanet.domain;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.persistence.Transient;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="post")
@Getter @Setter
public class Post implements Serializable {
    @Id
    @SequenceGenerator(name="POST_SEQ_GENERATOR",
    sequenceName="POST_SEQUENCE", initialValue=100, allocationSize=10)
    @GeneratedValue(strategy=GenerationType.SEQUENCE,
    generator="POST_SEQ_GENERATOR")
    private int postid;
    private String title;
    private Date schedule;
    @Column(name="timezone")
    private String time;
    private String place;
    private int headcount;
    private int cost;
    private String body;
    @Column(name="viewCount")
    private int view;
    private int wish;
    private int state;
    @Temporal(TemporalType.DATE)
    private LocalDate posted;
    private int id;
    private int event;
    @Transient
    private String custid;
    @Transient
    private String sportname;
    @Transient
    private int applicant;
    
    public Post() {}

}
