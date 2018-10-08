package com.demo.m3tasksink;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.task.launcher.annotation.EnableTaskLauncher;

@SpringBootApplication
@EnableTaskLauncher
public class M3TaskSinkApplication {

    public static void main(String[] args) {
        SpringApplication.run(M3TaskSinkApplication.class, args);
    }
}
