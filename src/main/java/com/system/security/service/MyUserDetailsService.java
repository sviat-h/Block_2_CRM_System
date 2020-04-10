package com.system.security.service;


import com.system.model.enums.Role;
import com.system.service.impl.AccountServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;

@Service
@RequiredArgsConstructor
public class MyUserDetailsService implements UserDetailsService {

    private final AccountServiceImpl accountService;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        return new User(s, accountService.findUserByUsername(s).getPassword(),
                getGrantedAuthorities(accountService.findUserByUsername(s)));
    }

    private Collection<GrantedAuthority> getGrantedAuthorities(com.system.model.entity.Account account) {

        Collection<GrantedAuthority> grantedAuthorities = new ArrayList<>();

        if (account.getRole().equals(Role.ADMIN)) {
            grantedAuthorities.add(new SimpleGrantedAuthority("ADMIN"));
        } else {
            grantedAuthorities.add(new SimpleGrantedAuthority("USER"));
        }

        return grantedAuthorities;
    }
}