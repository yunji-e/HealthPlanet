package com.dongduk.HealthPlanet.dao.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dongduk.HealthPlanet.domain.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    User findByCustid(String custid);
}
