package com.system.service.impl;

import com.system.model.entity.User;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl {
    public User findUserByUsername(String s) {
        return new User();
    }
}
