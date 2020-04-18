package com.system.service;

import com.system.model.entity.Account;
import org.springframework.stereotype.Service;

@Service
public interface AccountService {
    Account findAccountByUsername(String username);

    void save(Account account);
}
