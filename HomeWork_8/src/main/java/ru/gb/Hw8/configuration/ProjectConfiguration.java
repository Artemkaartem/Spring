package ru.gb.Hw8.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import ru.gb.Hw8.aspects.LoggingAspect;


@Configuration
@ComponentScan(basePackages = "ru.gb")
@EnableAspectJAutoProxy
public class ProjectConfiguration {

    @Bean
    public LoggingAspect aspect() {
        return new LoggingAspect();
    }
}