package com.dongduk.HealthPlanet.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dongduk.HealthPlanet.domain.Wish;
import com.dongduk.HealthPlanet.domain.WishId;


public interface WishRepository extends JpaRepository<Wish, WishId>{
    
    Wish findByIdAndPostid(int id, int postid);
    
}
