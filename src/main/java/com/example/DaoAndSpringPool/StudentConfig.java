package com.example.DaoAndSpringPool;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan(basePackages = "com.example.DaoAndSpringPool")
@PropertySource("classpath:app.properties")
public class StudentConfig {


}
