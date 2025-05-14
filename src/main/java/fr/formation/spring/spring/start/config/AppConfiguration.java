package fr.formation.spring.spring.start.config;

import fr.formation.spring.spring.start.DataSourceConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfiguration {

    @Bean("customDataSource")
    public DataSourceConfig configure() {
       return new DataSourceConfig("jdbc://postgres:5432", "postgres", "password");
    }


}
