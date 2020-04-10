package com.system.service.impl;

import com.system.model.entity.Account;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl {
    public Account findUserByUsername(String s) {
        return new Account();
    }
}
