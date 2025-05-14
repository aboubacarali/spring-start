package fr.formation.spring.spring.start;

public class DataSourceConfig {
    private final String url;
    private final String username;
    private final String password;

    public DataSourceConfig(String url, String username, String password) {
        this.url = url;
        this.username = username;
        this.password = password;
    }

    public void connect () {
        System.out.println("Connecting to " + url + "with username " + username + " and password " + password);
    }
}
