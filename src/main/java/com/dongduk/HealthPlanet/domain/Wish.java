package com.dongduk.HealthPlanet.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="wish")
@IdClass(WishId.class) // 복합 기본 키 클래스 지정
@Getter @Setter 
public class Wish {
    @Id
    private int id;
    @Id
    private int postid;
    
    public Wish() {}
    public Wish(int id, int postid) {
        super();
        this.id = id;
        this.postid = postid;
    }
    
}
