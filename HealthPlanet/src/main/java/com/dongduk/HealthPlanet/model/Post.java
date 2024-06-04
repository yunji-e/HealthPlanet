package com.dongduk.HealthPlanet.model;

import java.util.Date;

public class Post {
    private int postid;
    private String title;
    private Date schedule;
    private String time;
    private String place;
    private int headcount;
    private int cost;
    private String body;
    private int view;
    private int wish;
    private int state;
    private String custid;
    private int event;
    private String sportname;
    private int applicant;
    
    public Post() {}

    public Post(int postid, String title, Date schedule, String time, String custid) {
        super();
        this.postid = postid;
        this.title = title;
        this.schedule = schedule;
        this.time = time;
        this.custid = custid;
    }
    
    public Post(int postid, String title, Date schedule, int state, String custid) {
        super();
        this.postid = postid;
        this.title = title;
        this.schedule = schedule;
        this.state = state;
        this.custid = custid;
    }
    
    public Post(int postid, String title, Date schedule, String time, String place, int headcount, int cost,
            String body, int event) {
        super();
        this.postid = postid;
        this.title = title;
        this.schedule = schedule;
        this.time = time;
        this.place = place;
        this.headcount = headcount;
        this.cost = cost;
        this.body = body;
        this.event = event;
    }

    public Post(int postid, String title, Date schedule, String time, String place, int headcount, int cost,
            String body, String custid, int event) {
        super();
        this.postid = postid;
        this.title = title;
        this.schedule = schedule;
        this.time = time;
        this.place = place;
        this.headcount = headcount;
        this.cost = cost;
        this.body = body;
        this.custid = custid;
        this.event = event;
    }

    public Post(int postid, String title, Date schedule, String place, int headcount, int cost, String body, int view,
            int wish, int state, String custid, int event) {
        super();
        this.postid = postid;
        this.title = title;
        this.schedule = schedule;
        this.place = place;
        this.headcount = headcount;
        this.cost = cost;
        this.body = body;
        this.view = view;
        this.wish = wish;
        this.state = state;
        this.custid = custid;
        this.event = event;
    }

    public int getPostid() {
        return postid;
    }

    public void setPostid(int postid) {
        this.postid = postid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getSchedule() {
        return schedule;
    }

    public void setSchedule(Date schedule) {
        this.schedule = schedule;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public int getHeadcount() {
        return headcount;
    }

    public void setHeadcount(int headcount) {
        this.headcount = headcount;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public int getView() {
        return view;
    }

    public void setView(int view) {
        this.view = view;
    }

    public int getWish() {
        return wish;
    }

    public void setWish(int wish) {
        this.wish = wish;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public String getCustid() {
        return custid;
    }

    public void setCustid(String custid) {
        this.custid = custid;
    }

    public int getEvent() {
        return event;
    }

    public void setEvent(int event) {
        this.event = event;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getSportname() {
        return sportname;
    }

    public void setSportname(String sportname) {
        this.sportname = sportname;
    }

    public int getApplicant() {
        return applicant;
    }

    public void setApplicant(int applicant) {
        this.applicant = applicant;
    }
    
}
