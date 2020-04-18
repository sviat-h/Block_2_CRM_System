package com.system.service.impl;

import com.system.model.entity.Account;
import com.system.model.entity.User;
import com.system.model.enums.Role;
import com.system.repository.AccountRepository;
import com.system.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class AccountServiceImpl implements AccountService {

    private final AccountRepository accountRepository;

    @Override
    public Account findAccountByUsername(String username) {
        return accountRepository.findAccountByUsername(username);
    }

    @Override
    public void save(Account account) {

        account.setRole(Role.USER);

        //TODO FIX BELOW
        account.setUser(new User("Sviatoslav", "Hrynyk", 21, "535494645", account));

        accountRepository.save(account);
    }
}
