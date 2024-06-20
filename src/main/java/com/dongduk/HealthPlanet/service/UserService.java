package com.dongduk.HealthPlanet.service;

import com.dongduk.HealthPlanet.domain.User;
import com.dongduk.HealthPlanet.dao.jpa.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public void registerUser(User user) {
        userRepository.save(user);
    }

    public boolean authenticate(String custid, String custpw) {
        User user = userRepository.findByCustid(custid);
        return user != null && user.getCustpw().equals(custpw);
    }
}

