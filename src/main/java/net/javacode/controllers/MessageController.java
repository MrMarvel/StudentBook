package net.javacode.controllers;

import net.javacode.domain.Message;
import net.javacode.domain.User;
import net.javacode.repo.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.Map;
import java.util.UUID;

@Controller
@RequestMapping(value = "messages")
public class MessageController {
    @Autowired
    private MessageRepository messageRepo;

    @Value("${upload.path}")
    private String uploadPath;

    @PostMapping
    public String addMes(
            @AuthenticationPrincipal User user,
            @RequestParam String text,
            @RequestParam String tag,
            @RequestParam("file") MultipartFile file,
            Model model) throws IOException {

        Message mes = Message.builder().text(text).tag(tag).author(user).build();
        if (file != null && !file.isEmpty()) {
            File uploadFolder = new File(uploadPath);
            if (!uploadFolder.exists()) uploadFolder.mkdir();
            File resultFile;
            String resultFileName;
            do {
                String uuidFileName = UUID.randomUUID().toString();
                resultFileName = uuidFileName+"."+file.getOriginalFilename();
                resultFile = new File(uploadPath+"/"+resultFileName);
            } while(resultFile.exists());
            file.transferTo(resultFile);
            mes.setFilename(resultFileName);
        }
        messageRepo.save(mes);
        Iterable<Message> messages = messageRepo.findAll();
        model.addAttribute("messages", messages);
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
