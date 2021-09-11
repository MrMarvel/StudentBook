package net.javacode.controllers;

import net.javacode.domain.Attachment;
import net.javacode.domain.User;
import net.javacode.repo.AttachmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/materials")
public class MaterialsController {
    @Autowired
    private AttachmentRepository attachmentRepo;
    @Value("${attachments.path}")
    private String uploadPath;

    @GetMapping
    public String get(@AuthenticationPrincipal User user,
                      Model model) {
        model.addAttribute("user", user);
        List<Attachment> attachments = attachmentRepo.findByOwner(user);
        attachments = attachments.stream().filter(att -> {
            File file = new File(uploadPath + "/" + att.getFileName());
            if (!file.exists()) {
                attachmentRepo.delete(att);
                return false;
            }
            return true;
        }).collect(Collectors.toList());
        model.addAttribute("attachments", attachments);
        return "materials";
    }

    @PostMapping("/upload")
    public String upload(@AuthenticationPrincipal User user,
                         @RequestParam("files") List<MultipartFile> files) throws IOException {
        File uploadFolder = new File(uploadPath);
        if (!uploadFolder.exists()) uploadFolder.mkdir();
        for (MultipartFile file : files) {
            Attachment attachment = Attachment.builder().owner(user).build();
            File resultFile;
            String resultFileName;
            do {
                String uuidFileName = UUID.randomUUID().toString();
                resultFileName = uuidFileName + "." + file.getOriginalFilename();
                resultFile = new File(uploadPath + "/" + resultFileName);
            } while (resultFile.exists());
            file.transferTo(resultFile);
            attachment.setFileName(resultFileName);
            attachmentRepo.save(attachment);
        }
        return "redirect:/materials";
    }
    @GetMapping("/test")
    public String test(@AuthenticationPrincipal User user) {
        return "test";
    }

    @GetMapping("/delete")
    public String delete(@AuthenticationPrincipal User user,
                         @RequestParam("material_to_delete") Long id,
                         Model model) {
        Attachment material = null;
        Optional<Attachment> oa = attachmentRepo.findById(id);
        if (oa.isPresent()) material = oa.get();
        if (material != null) {
            if (material.getOwner().getId() == user.getId()) {
                attachmentRepo.delete(material);
            }
        }
        return "redirect:/materials";
    }
}
