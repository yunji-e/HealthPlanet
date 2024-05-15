package com.dongduk.HealthPlanet.model;

public class Wish {
    private int id;
    private int postid;
    
    public Wish(int id, int postid) {
        super();
        this.id = id;
        this.postid = postid;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public int getPostid() {
        return postid;
    }
    public void setPostid(int postid) {
        this.postid = postid;
    }
    
}
