package fr.formation.spring.spring.start.service;

import org.springframework.stereotype.Service;

@Service("smsNotifier")
public class SmsNotificationSender implements NotificationSender {
    /**
     * @param recipient
     * @param message
     */
    @Override
    public void send(String recipient, String message) {
        System.out.println("Sending email to " + recipient + ": " + message);

    }
}
