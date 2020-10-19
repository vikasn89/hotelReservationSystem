package com.spring.hotel.management.system.hotel.reservation.system;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.session.SessionRegistry;
import org.springframework.security.core.session.SessionRegistryImpl;

import com.spring.hotel.management.system.hotel.reservation.system.util.ActiveUserStore;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Bean
	public ActiveUserStore activeUserStore(){
	    return new ActiveUserStore();
	}
}
