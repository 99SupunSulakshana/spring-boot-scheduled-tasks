package com.example.scheduled_task;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class ScheduledTaskApplication {

	public static void main(String[] args) {
		SpringApplication.run(ScheduledTaskApplication.class, args);
	}

}
