package net.javacode.controllers;

import net.javacode.domain.Role;
import net.javacode.domain.User;
import net.javacode.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/user")
@PreAuthorize("hasAuthority('ADMIN')")
public class UserController {
    @Autowired
    private UserRepository userRepo;

    @GetMapping
    public String userList(Model model) {
        List<User> users = userRepo.findAll();
        model.addAttribute("users",users);
        return "userlist";
    }
    @GetMapping("{user}")
    public String userEditForm(@PathVariable(name = "user") Long id, Model model) {
        User user = userRepo.findById(id).orElse(null);
        model.addAttribute("user", user);
        model.addAttribute("roles", Role.values());
        return "userEdit";
    }
    @PostMapping
    public String setProfile(@RequestParam(name = "id") Long id,
                             @RequestParam String email,
                             @RequestParam String username,
                             @RequestParam String password,
                             @RequestParam Map<String, String> form,
                             Model m) {
        User user = userRepo.findById(id).orElse(null);
        if (user == null) return "error";
        Set<String> roles = Arrays.stream(Role.values()).map(Role::name).collect(Collectors.toSet());
        user.getRoles().clear();
        for (String key : form.keySet()) {
            if (roles.contains(key)) {
                Role role = Role.valueOf(key);
                user.getRoles().add(role);
            }
        }
        user.setActive(form.containsKey("active"));
        user.setUsername(email);
        user.setUsername(username);
        user.setPassword(password);
        userRepo.save(user);

        return "redirect:/user";
    }
}
