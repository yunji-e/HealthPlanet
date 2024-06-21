package com.dongduk.HealthPlanet.entities;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Meeting {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ID; //모임 id
    private String title; //제목
    private String schedule; //날짜
    private String time; //시간대
    private String event; //종목
    private String city; //도시
    private String region; //도시(군,구)
    private String headCount; //인원
    private String cost;//비용
    private String body;//본문

    public Meeting() {
    }

    public Meeting(String title, String schedule, String time, String event,
                   String city, String region, String headCount, String cost, String body) {
        this.title = title;
        this.schedule = schedule;
        this.time = time;
        this.event = event;
        this.city = city;
        this.region = region;
        this.headCount = headCount;
        this.cost = cost;
        this.body = body;
    }


    public Long getID() {
        return ID;
    }

    public void setID(Long iD) {
        ID = iD;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSchedule() {
        return schedule;
    }

    public void setSchedule(String schedule) {
        this.schedule = schedule;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getEvent() {
        return event;
    }

    public void setEvent(String event) {
        this.event = event;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getHeadCount() {
        return headCount;
    }

    public void setHeadCount(String headCount) {
        this.headCount = headCount;
    }

    public String getCost() {
        return cost;
    }

    public void setCost(String cost) {
        this.cost = cost;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }
}
   
