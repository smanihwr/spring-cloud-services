package com.demo.m3taskintake.config;

import com.demo.m3taskintake.processor.TaskProcessor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TaskConfig {

    @Bean
    public TaskProcessor taskProcessor() {
        return new TaskProcessor();
    }
}
