package com.demo.m3task;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.task.configuration.EnableTask;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableTask
public class M3TaskApplication {

    public static void main(String[] args) {
        SpringApplication.run(M3TaskApplication.class, args);
    }

    @Bean
    public TollProcessingTask tollProcessingTask() {
        return new TollProcessingTask();
    }

    public class TollProcessingTask implements CommandLineRunner{

        @Override
        public void run(String... args) throws Exception {

            //parameters stationid, license plate, timestamp

            if(null != args) {
                System.out.println("Parameter length " + args.length);

                String stationId = args[0];
                String licensePlate = args[1];
                String timestamp = args[2];

                System.out.println("Station id " + stationId + ", license plate " +
                        licensePlate + ", timestamp " + timestamp);
            }

        }
    }
}
