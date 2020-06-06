package com.system.service;

import com.system.model.entities.Account;
import org.springframework.stereotype.Service;

@Service
public interface AccountService {
    Account findAccountByUsername(String username);

    void save(Account account);

    Account findAccountById(Integer id);

    void updateAccountById(Integer id, Account account);
}
