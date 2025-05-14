package fr.formation.spring.spring.start.service;

import fr.formation.spring.spring.start.config.NotificationProperties;

public class NotificationService {
    private NotificationProperties properties;

    public NotificationService(NotificationProperties properties) {
        this.properties = properties;
    }


}
