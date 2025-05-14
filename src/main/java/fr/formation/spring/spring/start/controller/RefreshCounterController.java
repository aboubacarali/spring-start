package fr.formation.spring.spring.start.controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RefreshCounterController {

    @GetMapping("/counter-refresh")
    public String countRefreshes(HttpSession session, Model model) {
        final String REFRESH_COUNT_ATTR = "refreshCount";

        Integer count = (Integer) session.getAttribute(REFRESH_COUNT_ATTR);

        if (count == null) {
            count = 1;
        } else {
            count++;
        }

        session.setAttribute(REFRESH_COUNT_ATTR, count);

        model.addAttribute("refreshNumber", count);

        return "counter-refresh";
    }
}
