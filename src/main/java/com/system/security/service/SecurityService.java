package com.system.security.service;

import com.system.model.entities.Account;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public interface SecurityService {

    ResponseEntity<?> autoLogin(Account account) throws Exception;
}
