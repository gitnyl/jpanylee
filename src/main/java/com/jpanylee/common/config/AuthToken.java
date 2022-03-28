package com.jpanylee.common.config;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;

import java.util.List;

public class AuthToken extends UsernamePasswordAuthenticationToken {
    private static final long serialVersionUID = 1L;

    public AuthToken(String id, String pw, List<GrantedAuthority> authList) {
        super(id, pw, authList);
    }
}
