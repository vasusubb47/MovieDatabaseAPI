package com.mdb.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MovieDatabaseApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(MovieDatabaseApiApplication.class, args);
		System.out.println("Movie DataBase API Running....");
	}

}
