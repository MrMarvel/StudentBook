package net.javacode.controllers;

import net.javacode.domain.Message;
import net.javacode.domain.User;
import net.javacode.repo.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Controller
@RequestMapping(value = "messages")
public class MessageController {
    @Autowired
    private MessageRepository messageRepo;

    @PostMapping
    public String addMes(
            @AuthenticationPrincipal User user,
            @RequestParam String text,
            @RequestParam String tag,
            Map<String, Object> model) {
        Message mes = Message.builder().text(text).tag(tag).author(user).build();
        messageRepo.save(mes);
        Iterable<Message> messages = messageRepo.findAll();
        model.put("messages", messages);
        return "redirect:/messages";
    }
    @GetMapping
    public String mes(@RequestParam(required = false, defaultValue = "") String filter, Map<String, Object> model) {
        Iterable<Message> messages;
        if (!filter.equals("")) messages = messageRepo.findByTag(filter);
        else messages = messageRepo.findAll();
        model.put("messages", messages);
        model.put("filter", filter);
        return "messages";
    }
}
