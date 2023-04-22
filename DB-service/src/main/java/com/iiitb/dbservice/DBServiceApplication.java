package com.iiitb.dbservice;

import com.iiitb.userservice.UserServiceApplication;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class DBServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(DBServiceApplication.class, args);
    }
}
