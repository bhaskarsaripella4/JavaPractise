package com.protean.flakey;

import com.protean.flakey.dto.ParkingTickets;
import com.protean.flakey.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableCaching
@EnableJpaRepositories("com.protean.flakey.repository")
public class FlakeyApplication {

//	@Autowired
//	TicketService ticketService;

	public static void main(String[] args) {
		SpringApplication.run(FlakeyApplication.class, args);
	}

}
