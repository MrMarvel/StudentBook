package net.javacode.controllers;

import net.javacode.domain.Role;
import net.javacode.domain.User;
import net.javacode.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Collections;
import java.util.Map;

@Controller
@RequestMapping("register")
public class RegistrationController {
    @Autowired
    private UserRepository userRepo;


    @GetMapping
    public String index() {
        return "registration";
    }

    @PostMapping
    public String register(User user, Map<String, Object> model) {
        if (user == null) {
            model.put("error", "Неправильный формат почты или пароля.");
            return "registration";
        }
        User userFromDB = userRepo.findByUsername(user.getUsername());
        if (userFromDB != null) {
            model.put("error", "Эта почта уже зарегестрирована!");
            return "registration";
        }
        user.setActive(true);
        user.setAccountNonExpired(true);
        user.setAccountNonLocked(true);
        user.setCredentialsNonExpired(true);
        user.setRoles(Collections.singleton(Role.USER));
        userRepo.save(user);
        return "redirect:/login";
    }
}
