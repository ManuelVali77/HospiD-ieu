package com.simplon.hospidieuBack;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class HospidieuBackApplication  implements CommandLineRunner {
	
	public static void main(String[] args) {
		SpringApplication.run(HospidieuBackApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("=== Bienvenue sur HospiD'ieu ===");
	}

}
