package fr.formation.spring.spring.start.component;

import fr.formation.spring.spring.start.service.GreetingService;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

@Component
public class AppRunner {

    private final GreetingService greetingService;

    public AppRunner(GreetingService greetingService) {
        this.greetingService = greetingService;
    }

    @PostConstruct
    public void init() {
        System.out.println(greetingService.greet("Spring Boot"));
    }
}
