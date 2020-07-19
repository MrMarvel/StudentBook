package net.javacode.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WebController {

    @GetMapping("/")
    public String greeting(Model model) {
        model.addAttribute("name", "Serega_3010");
        return "index";
    }

}
