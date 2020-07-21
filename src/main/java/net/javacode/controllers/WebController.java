package net.javacode.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Map;

@Controller
public class WebController {
    private static long userCounter = 0;

    @GetMapping("/")
    public String greeting(Map<String, Object> model) {
        userCounter++;
        model.put("name", "Serega_3010");
        model.put("counter", userCounter);
        return "index";
    }

    Integer i;



}
