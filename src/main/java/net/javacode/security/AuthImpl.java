package net.javacode.security;

import net.javacode.models.User;
import net.javacode.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;

public class AuthImpl implements AuthenticationProvider {
    @Autowired
    private UserRepository userRepo;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String name = authentication.getName();
        return null;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return false;
    }
}
