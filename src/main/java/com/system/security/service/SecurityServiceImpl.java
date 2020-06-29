package com.system.security.service;

import com.system.model.entities.Account;
import com.system.security.util.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.stereotype.Service;

import static com.system.security.filters.JwtRequestFilter.getResponseEntity;

@Service
@RequiredArgsConstructor
public class SecurityServiceImpl implements SecurityService {

    private final AuthenticationManager authenticationManager;

    private final MyUserDetailsService userDetailsService;

    private final JwtUtil jwtTokenUtil;

    public ResponseEntity<?> autoLogin(Account account) throws Exception {
        return getResponseEntity(account, authenticationManager, userDetailsService, jwtTokenUtil);
    }
}
