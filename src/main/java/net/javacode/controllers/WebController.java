package net.javacode.controllers;

import net.javacode.domain.User;
import net.javacode.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Map;

@Controller
public class WebController {
    @Autowired
    private UserRepository userRepo;

    private static long userCounter = 0;

    @GetMapping("/")
    public String greeting(@AuthenticationPrincipal User user, Map<String, Object> model) {
        userCounter++;
        model.put("name", "Serega_3010");
        model.put("counter", userCounter);
        model.put("user", user);
        return "index";
    }
    @GetMapping("/users")
    public String getUsers(Map<String, Object> model) {
        Iterable<User> users = userRepo.findAll();
        model.put("users", users);
        return "user-list";
    }

    Integer i;



}
