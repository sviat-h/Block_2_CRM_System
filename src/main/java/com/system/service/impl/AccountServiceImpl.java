package com.system.service.impl;

import com.system.model.entity.Account;
import com.system.repository.AccountRepository;
import com.system.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService {

    private final AccountRepository accountRepository;

    @Override
    public Account findAccountByUsername(String username) {
        return accountRepository.findAccountByUsername(username);
    }

    @Override
    public void save(Account account) {
        accountRepository.save(account);
    }
}
