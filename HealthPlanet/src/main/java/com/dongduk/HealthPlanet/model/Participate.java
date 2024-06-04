package com.dongduk.HealthPlanet.model;

public class Participate {
    private int postid;
    private int id;
    private int state;
    
    public Participate() {}
    
    public Participate(int postid, int id, int state) {
        super();
        this.postid = postid;
        this.id = id;
        this.state = state;
    }

    public int getPostid() {
        return postid;
    }

    public void setPostid(int postid) {
        this.postid = postid;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }
    
    
}
