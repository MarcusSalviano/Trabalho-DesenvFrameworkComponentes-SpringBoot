package br.fa7.spring.loja;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Main {

	public static void main(String[] args) {
		System.setProperty("server.port", "8082");
		SpringApplication.run(Main.class, args);
	}
}
