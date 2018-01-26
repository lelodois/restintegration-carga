package br.com.lelo.precos.precocarga;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootApplication
public class PrecoCargaApplication {

	public static void main(String[] args) {
		SpringApplication.run(PrecoCargaApplication.class, args);
	}

	@Bean
	public ObjectMapper createObjectMapper() {
		return new ObjectMapper();
	}

}
