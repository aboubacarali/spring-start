package fr.formation.spring.spring.start.startup;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

@Component
public class TestRunner {
    @PostConstruct
    public void startup () {
        System.out.println("Starting test");

    }
}
