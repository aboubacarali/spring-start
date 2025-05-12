package fr.formation.spring.spring.start.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Arrays;
import java.util.List;

@Controller
public class ListController {

    @GetMapping("/items")
    public String showItems(Model model) {
        List<String> items = Arrays.asList("Pomme", "Banane", "Orange", "Fraise");
        model.addAttribute("itemList", items);
        return "items-view"; // Nom du template HTML
    }
}