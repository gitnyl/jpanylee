package com.jpanylee.common.config;

import lombok.SneakyThrows;
import lombok.extern.java.Log;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Component
@Log
public class AuthProvider implements AuthenticationProvider {

    @SneakyThrows
    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String userId = authentication.getPrincipal().toString();
        String userPw = authentication.getCredentials().toString();
        return authentication(userId, userPw);
    }
    private Authentication authentication(String userId, String password) throws SQLException {
        List<GrantedAuthority> authList = new ArrayList<>();

        return new AuthToken(userId, password, authList);
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return (UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication));
    }
}
