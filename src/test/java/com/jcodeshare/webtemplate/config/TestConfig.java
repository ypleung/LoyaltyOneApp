package com.jcodeshare.webtemplate.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.jcodeshare.webtemplate.data.service.UsersService;
import com.jcodeshare.webtemplate.data.service.UsersServiceImpl;

@Configuration
@ComponentScan(basePackages = { 
        "com.jcodeshare.webtemplate.data.service",
        "com.jcodeshare.webtemplate.data.dao"
        })
public class TestConfig {
    
    @Bean
    public UsersService getUsersService() {
        return (UsersService) new UsersServiceImpl();
    }
}