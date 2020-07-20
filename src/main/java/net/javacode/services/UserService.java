package net.javacode.services;

import net.javacode.domain.Role;
import net.javacode.domain.User;
import net.javacode.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.ArrayList;
import java.util.List;

public class UserService implements UserDetailsService {
    @Autowired
    private UserRepository userRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        List<Role> list = new ArrayList<>();
        list.add(Role.USER);
        userRepo.findByUsername()
        return new User(username, "password", list, true, true, true, true);
    }
}