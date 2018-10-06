package com.demo.m2configservergit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class M2ConfigServerGitApplication {

    public static void main(String[] args) {
        SpringApplication.run(M2ConfigServerGitApplication.class, args);
    }
}
