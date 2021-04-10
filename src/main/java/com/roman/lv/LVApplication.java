package com.roman.lv;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class LVApplication {
@Autowired
WorkerBean workerBean;
//Driver for chrome is configured in web properties
	public static void main(String[] args) {

		SpringApplication.run(LVApplication.class, args);
   	}

}