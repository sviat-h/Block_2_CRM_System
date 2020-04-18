package com.system.security.controller;

import com.system.model.entity.Account;
import com.system.security.service.SecurityService;
import com.system.security.validator.UserValidator;
import com.system.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class RegistrationController {

    private final AccountService accountService;

    private final SecurityService securityService;

    private final UserValidator userValidator;

    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public String registration(Model model) {
        model.addAttribute("userForm", new Account());

        return "registration";
    }

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public String registration(@RequestBody Account account, BindingResult bindingResult, Model model) {
        userValidator.validate(account, bindingResult);

        if (bindingResult.hasErrors()) {
            return "Error";
        }

        accountService.save(account);

        //TODO FIX AUTO LOGIN
        securityService.autoLogin(account.getUsername(), account.getConfirmPassword());


        return "Success";
    }
}
