package fr.formation.spring.spring.start.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@ConfigurationProperties(prefix = "notification.service")
public class NotificationProperties {
    private boolean enabled;
    // Mappage automatique de kebab-case vers camelCase
    private String defaultSender;
    private int retryAttempts;
    private List<String> supportedChannels = new ArrayList<>();

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public String getDefaultSender() {
        return defaultSender;
    }

    public void setDefaultSender(String defaultSender) {
        this.defaultSender = defaultSender;
    }

    public int getRetryAttempts() {
        return retryAttempts;
    }

    public void setRetryAttempts(int retryAttempts) {
        this.retryAttempts = retryAttempts;
    }

    public List<String> getSupportedChannels() {
        return supportedChannels;
    }

    public void setSupportedChannels(List<String> supportedChannels) {
        this.supportedChannels = supportedChannels;
    }
}
