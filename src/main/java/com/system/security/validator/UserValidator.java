package com.system.security.validator;

import com.system.model.entities.Account;
import com.system.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
@RequiredArgsConstructor
public class UserValidator implements Validator {

    private final AccountService accountService;

    @Override
    public boolean supports(Class<?> aClass) {
        return Account.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        Account account = (Account) o;

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "username", "Required");
        if (account.getUsername().length() < 8 || account.getUsername().length() > 32) {
            errors.rejectValue("username", "Size.userForm.username");
        }

        if (accountService.findAccountByUsername(account.getUsername()) != null) {
            errors.rejectValue("username", "Duplicate.userForm.username");
        }

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "Required");
        if (account.getPassword().length() < 8 || account.getPassword().length() > 32) {
            errors.rejectValue("password", "Size.userForm.password");
        }

        if (!account.getConfirmPassword().equals(account.getPassword())) {
            errors.rejectValue("confirmPassword", "Different.userForm.password");
        }

        if (!account.getEmail().contains("@") || !account.getEmail().contains(".")) {
            errors.rejectValue("email", "Content.userForm.email");
        }

        if (account.getUser().getFirstName().length() < 4 || account.getUser().getFirstName().length() > 32) {
            errors.rejectValue("firstName", "Size.userForm.name");
        }

        if (account.getUser().getLastName().length() < 4 || account.getUser().getLastName().length() > 32) {
            errors.rejectValue("lastName", "Size.userForm.name");
        }

        if (account.getUser().getAge() <= 0) {
            errors.rejectValue("age", "Content.userForm.age");
        }

        if (!account.getUser().getPhone().contains("+") || !account.getUser().getPhone().substring(1).matches("-?\\d+(\\.\\d+)?")) {
            errors.rejectValue("phone", "Content.userForm.phone");
        }
    }
}
