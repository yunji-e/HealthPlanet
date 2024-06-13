package com.dongduk.HealthPlanet.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="participate")
@Getter @Setter
public class Participate {
    @Id
    private int postid;
    @Id
    private int id;
    private int state;
    
    public Participate() {}
    
    public Participate(int postid, int id, int state) {
        super();
        this.postid = postid;
        this.id = id;
        this.state = state;
    }

}
