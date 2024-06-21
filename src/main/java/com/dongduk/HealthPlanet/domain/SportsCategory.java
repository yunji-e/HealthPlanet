package com.dongduk.HealthPlanet.domain;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="sportscategory")
@Getter @Setter
public class SportsCategory implements Serializable {
    @Id
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
    
}