package fr.formation.spring.spring.start.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

@Controller
@RequestMapping("/tasks")
public class TaskController {

    @GetMapping("/new")
    public String showTaskForm() {
        return "task-form";
    }

    @PostMapping("/save")
    public RedirectView saveTask(
            @RequestParam String description,
            RedirectAttributes redirectAttributes) {

        System.out.println("Sauvegarde de la tâche : " + description);
        boolean success = true;

        if (success) {
            // Message de succès
            String successMsg = "Tâche '" + description + "' ajoutée avec succès !";
            redirectAttributes.addFlashAttribute("successMessage", successMsg);
        }

        return new RedirectView("/tasks/list");
    }

    @GetMapping("/list")
    public String showTaskList(Model model) {
        return "task-list";
    }
}
