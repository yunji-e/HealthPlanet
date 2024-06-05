package com.dongduk.HealthPlanet.domain;

import java.io.Serializable;
import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class PostPreview implements Serializable {
    @Id
    private int postId;
    private String title;
    private LocalDate schedule;
    private String custId;
    
    public PostPreview() {}
    
    public PostPreview(int postId, String title, LocalDate schedule, String custId) {
        super();
        this.postId = postId;
        this.title = title;
        this.schedule = schedule;
        
        this.custId = custId;
    }

    /*getter and setter*/
    public int getPostId() {
        return postId;
    }

    public void setPostId(int postId) {
        this.postId = postId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public LocalDate getSchedule() {
        return schedule;
    }

    public void setSchedule(LocalDate schedule) {
        this.schedule = schedule;
    }

    public String getCustId() {
        return custId;
    }

    public void setCustId(String custId) {
        this.custId = custId;
    }
        
}
