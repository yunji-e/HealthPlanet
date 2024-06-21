package com.dongduk.HealthPlanet.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="sportcategory")
@Getter @Setter
public class SportCategory {
    @Id
    private int sportid;
    private String sportname;
    private String description;
    
    public SportCategory() {}
    
    public SportCategory(int sportid, String sportname, String description) {
        super();
        this.sportid = sportid;
        this.sportname = sportname;
        this.description = description;
    }
    
}