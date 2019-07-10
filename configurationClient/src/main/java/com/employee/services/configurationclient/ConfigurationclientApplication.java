package com.employee.services.configurationclient;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableDiscoveryClient
@EnableAutoConfiguration
public class ConfigurationclientApplication {

    public static void main(String[] args) {
        SpringApplication.run(ConfigurationclientApplication.class, args);
    }
}

@RefreshScope
@RestController
class MessageRestController {

    @Value("${name:default}")
    private String name;

    @Value("${env:default}")
    private String env;

    @RequestMapping("/name")
    String getName() {
        return this.name;
    }

    @RequestMapping("/env")
    String getEnv() {
        return this.env;
    }
}