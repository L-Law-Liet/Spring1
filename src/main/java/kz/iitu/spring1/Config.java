package kz.iitu.spring1;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan("kz.iitu.spring1")
@PropertySource("application.properties")
public class Config {
}
