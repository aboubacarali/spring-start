package fr.formation.spring.spring.start.controller;


import fr.formation.spring.spring.start.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {

    @GetMapping("/user-details")
    public String showUserDetails (Model model) {
        User user = new User(1L, "jdupont", "j.dupont@gmail.com", true);
        model.addAttribute("user", user);
        return "user-details";

    }

}
