package com.library;

import com.library.repository.CopyBookRepository;
import com.library.service.DbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MyLibraryApplication {

	public static void main(String[] args) {
		SpringApplication.run(MyLibraryApplication.class, args);
	}
}
