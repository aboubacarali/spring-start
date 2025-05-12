package fr.formation.spring.spring.start.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MessageController {

    @GetMapping("/message")
    public String showMessage (Model model) {
        model.addAttribute("message", "Welcome to Spring Boot, the most amazing framework !");
        return "message-view";
    }
}
