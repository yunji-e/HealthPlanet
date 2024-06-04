package com.dongduk.HealthPlanet.model;

public class SportsCategory {
    private int sportid;
    private String sportname;
    private String description;
    
    public SportsCategory() {}
    
    public SportsCategory(int sportid, String sportname, String description) {
        super();
        this.sportid = sportid;
        this.sportname = sportname;
        this.description = description;
    }
    
    public int getSportid() {
        return sportid;
    }
    public void setSportid(int sportid) {
        this.sportid = sportid;
    }
    public String getSportname() {
        return sportname;
    }
    public void setSportname(String sportname) {
        this.sportname = sportname;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
}
