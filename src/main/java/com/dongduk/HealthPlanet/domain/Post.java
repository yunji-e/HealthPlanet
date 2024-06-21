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
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
    @SequenceGenerator(name="POST_SEQ_GENERATOR",
    sequenceName="POST_SEQUENCE", initialValue=100, allocationSize=10)
    @GeneratedValue(strategy=GenerationType.SEQUENCE,
    generator="POST_SEQ_GENERATOR")
    private int postid;
    private String title;
//    private Date schedule;
    private String schedule;
    @Column(name="timezone")
    private String time;
    private String city;
    private String region;
    private int headcount;
    private String cost;
    private String body;
    @Column(name="viewcount")
    private int view;
    private int wish;
    private int state;
//    @Temporal(TemporalType.DATE)
//    private LocalDate posted;
    private int id;
    private String event;
    @Transient
    private String custid;
//    @Transient
//    private String sportname;
    @Transient
    private long applicant;
    
    public Post() {}

    public Post(int postid, String title, String schedule, int state, String custid) {
        super();
        this.postid = postid;
        this.title = title;
        this.schedule = schedule;
        this.state = state;
        this.custid = custid;
    }

}
