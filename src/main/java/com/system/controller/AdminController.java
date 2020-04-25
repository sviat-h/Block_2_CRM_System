package com.system.controller;

import com.system.model.entity.Account;
import com.system.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/admin")
public class AdminController {

    private final AccountService accountService;

    @GetMapping(value = "/account/{id}")
    public Account getAccount(@PathVariable Integer id) {
        return accountService.findAccountById(id);
    }
}
