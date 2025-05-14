package fr.formation.spring.spring.start.component;

import fr.formation.spring.spring.start.service.SmsNotificationSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class OrderProcessor {

    private final SmsNotificationSender smsNotificationSender;

    @Autowired
    public OrderProcessor(@Qualifier("smsNotifier") SmsNotificationSender smsNotificationSender) {
        this.smsNotificationSender = smsNotificationSender;
    }

    public void processOrder(String orderId) {
        smsNotificationSender.send("Admin", "Order" + orderId + "processed successfully");
    }
}
