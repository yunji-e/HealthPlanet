package com.example.demo.entities;

import jakarta.persistence.*;

@Entity
public class Meeting {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "TITLE")
    private String name;

    @Column(name = "SCHEDULE")
    private String meetingDate;

    @Column(name = "TIMEZONE")
    private String meetingTime;

    @Column(name = "EVENT")
    private String meetingEvent;

    @Column(name = "PLACE")
    private String meetingCity;

    @Column(name = "COUNTY")
    private String meetingCounty;

    @Column(name = "HEADCOUNT")
    private String headCount;

    @Column(name = "COST")
    private String price;

    @Column(name = "BODY")
    private String description;

    public Meeting() {
    }

    public Meeting(String name, String meetingDate, String meetingTime, String meetingEvent, String meetingCity, String meetingCounty, String headCount, String price, String description) {
        this.name = name;
        this.meetingDate = meetingDate;
        this.meetingTime = meetingTime;
        this.meetingEvent = meetingEvent;
        this.meetingCity = meetingCity;
        this.meetingCounty = meetingCounty;
        this.headCount = headCount;
        this.price = price;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMeetingDate() {
        return meetingDate;
    }

    public void setMeetingDate(String meetingDate) {
        this.meetingDate = meetingDate;
    }

    public String getMeetingTime() {
        return meetingTime;
    }

    public void setMeetingTime(String meetingTime) {
        this.meetingTime = meetingTime;
    }

    public String getMeetingEvent() {
        return meetingEvent;
    }

    public void setMeetingEvent(String meetingEvent) {
        this.meetingEvent = meetingEvent;
    }

    public String getMeetingCity() {
        return meetingCity;
    }

    public void setMeetingCity(String meetingCity) {
        this.meetingCity = meetingCity;
    }

    public String getMeetingCounty() {
        return meetingCounty;
    }

    public void setMeetingCounty(String meetingCounty) {
        this.meetingCounty = meetingCounty;
    }

    public String getHeadCount() {
        return headCount;
    }

    public void setHeadCount(String headCount) {
        this.headCount = headCount;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
