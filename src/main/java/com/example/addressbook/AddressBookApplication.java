package com.example.addressbook;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import lombok.extern.slf4j.Slf4j;

@SpringBootApplication
@Slf4j
public class AddressBookApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(AddressBookApplication.class, args);
		log.info("Address Book app started in {} Environment",context.getEnvironment().getProperty("environment"));
		log.info("Address Book DB user is {} ",context.getEnvironment().getProperty("spring.datasource.username"));
	}

}
