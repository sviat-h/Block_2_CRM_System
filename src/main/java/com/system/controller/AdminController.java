package com.system.controller;

import com.system.model.entities.Account;
import com.system.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/admin")
public class AdminController {

    private final AccountService accountService;

    @GetMapping(value = "/getAccount/{id}")
    public Account getAccount(@PathVariable Integer id) {

        return accountService.findAccountById(id);
    }

    @PutMapping(value = "/updateAccount/{id}")
    public Account updateAccount(@PathVariable Integer id, @RequestBody Account account) {

        accountService.updateAccountById(id, account);
        return accountService.findAccountById(id);
    }
}
