package com.crio.RentVideo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;

@SpringBootApplication
public class RentVideoApplication {

	public static void main(String[] args) {
		SpringApplication.run(RentVideoApplication.class, args);
	}

	@GetMapping("/")
	public String welcome() {
		return " Viewing available videos!";
	}

	@GetMapping("/admins")
	@PreAuthorize("hasAuthority('ADMIN')")
	public String welcomeAdmin() {
		return "Managing available videos";
	}

}
