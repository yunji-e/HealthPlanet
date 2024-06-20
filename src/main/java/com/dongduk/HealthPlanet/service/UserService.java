package com.dongduk.HealthPlanet.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dongduk.HealthPlanet.dao.jpa.UserRepository;
import com.dongduk.HealthPlanet.domain.User;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public boolean authenticate(String custid, String custpw) {
        User user = userRepository.findByCustid(custid);
        return user != null && user.getCustpw().equals(custpw);
    }

    public boolean isUsernameTaken(String custid) {
        User user = userRepository.findByCustid(custid);
        return user != null;
    }

    public void registerUser(User user) {
        userRepository.save(user);
    }
}
