package net.javacode.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WebController {
    private static long userCounter = 0;

    @GetMapping("/")
    public String greeting(Model model) {
        userCounter++;
        model.addAttribute("name", "Serega_3010");
        model.addAttribute("counter", userCounter);
        return "index";
    }

}
