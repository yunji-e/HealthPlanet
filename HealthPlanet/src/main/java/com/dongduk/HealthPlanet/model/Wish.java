package com.dongduk.HealthPlanet.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="wish")
@Getter @Setter 
public class Wish {
    @Id
    private int id;
    @Id
    private int postid;
    
    public Wish(int id, int postid) {
        super();
        this.id = id;
        this.postid = postid;
    }
    
}
