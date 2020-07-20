package net.javacode.controllers;

import net.javacode.models.User;
import net.javacode.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserController {

    @Autowired
    private UserRepository userRepo;

    @GetMapping("/users")
    public String getUsers(Model m) {
        Iterable<User> users = userRepo.findAll();
        m.addAttribute("users", users);
        return "user-list";
    }
}
