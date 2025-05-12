package fr.formation.spring.spring.start.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HomeController {

    @GetMapping("/")
    @ResponseBody
    public String index() {
        return "<h1>Hello World</h1>";
    }

    @GetMapping("/hello")
    public String hello(@RequestParam String name, Model model) {
        model.addAttribute("name", name);
        return "hello";
    }

    @GetMapping("/hello/{name}")
    @ResponseBody
    public String helloPathVariable (@PathVariable String name) {
        return "<h1>Hello " + name + "</h1>";
    }
}
