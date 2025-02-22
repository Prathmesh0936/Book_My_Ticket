package com.prathmesh.bookmyticket;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class BookMyTicketApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookMyTicketApplication.class, args);
	}

}
