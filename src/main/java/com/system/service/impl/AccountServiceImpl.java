package com.system.service.impl;

import com.system.model.entity.Account;
import com.system.repository.AccountRepository;
import com.system.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;


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

    @Override
    public Account findAccountById(Integer id) {
        return Optional.ofNullable(accountRepository.findAccountById(id))
                .orElseThrow(() -> new IllegalArgumentException("User not found."));
    }

    @Override
    public void updateAccountById(Integer id, Account account) {

        accountRepository.updateAccountById(id, account.getUsername(), account.getEmail(), account.getRole());
    }
}
