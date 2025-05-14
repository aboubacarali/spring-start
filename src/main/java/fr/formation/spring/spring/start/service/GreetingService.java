package fr.formation.spring.spring.start.service;

import org.springframework.stereotype.Service;

@Service
public class GreetingService implements GreetingServiceInterface {
    /**
     * @param name
     * @return
     */
    @Override
    public String greet(String name) {
        return "Hello, " + name + "!";
    }
}
