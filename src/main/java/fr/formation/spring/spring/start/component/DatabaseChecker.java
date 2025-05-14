package fr.formation.spring.spring.start.component;


import fr.formation.spring.spring.start.config.AppConfiguration;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

@Component
public class DatabaseChecker {

    private final AppConfiguration config;

    public DatabaseChecker(AppConfiguration config) {
        this.config = config;
    }

    @PostConstruct
    public void makeConnection () {
        this.config.configure().connect();
    }
}
