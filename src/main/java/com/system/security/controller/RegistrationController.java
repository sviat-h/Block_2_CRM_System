package com.system.security.controller;

import com.system.model.entities.Account;
import com.system.model.entities.User;
import com.system.model.enums.Role;
import com.system.security.service.PassEncoder;
import com.system.security.service.SecurityService;
import com.system.security.validator.UserValidator;
import com.system.service.impl.AccountServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;

@RestController
@RequiredArgsConstructor
public class RegistrationController {

    private final AccountServiceImpl accountService;

    private final SecurityService securityService;

    private final UserValidator userValidator;

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public ResponseEntity<?> registration(@RequestBody Account account, BindingResult bindingResult) throws Exception {

        userValidator.validate(account, bindingResult);

        if (bindingResult.hasErrors()) {
            throw new IllegalArgumentException(Objects.requireNonNull(bindingResult.getFieldError()).getField());
        }

        account.setPassword(PassEncoder.hashPassword(account.getPassword()));
        account.setRole(Role.USER);
        account.setUser(new User(account.getUser().getFirstName(), account.getUser().getLastName(), account.getUser().getAge(), account.getUser().getPhone(), account));
        accountService.save(account);

        return securityService.autoLogin(account);
    }
}
