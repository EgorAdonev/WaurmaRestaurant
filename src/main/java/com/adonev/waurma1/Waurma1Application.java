package com.adonev.waurma1;

import com.adonev.waurma1.controller.CustomerRepository;
import com.adonev.waurma1.model.Customer;
import com.github.javafaker.Faker;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDateTime;
import java.util.List;

@SpringBootApplication
public class Waurma1Application {

	public static void main(String[] args) {
		SpringApplication.run(Waurma1Application.class, args);
	}
	@Bean
	CommandLineRunner commandLineRunner(CustomerRepository customerRepository) {
		return args -> {
			Faker faker = new Faker();
			String name = faker.name().firstName();
			String email = String.format("%s@waurma.ru", name);
			Customer customer = new Customer(email, name, faker.phoneNumber().cellPhone());

			//customer.setEmail(email);

			customerRepository.save(customer);
			System.out.println(customerRepository.search(name));
			System.out.println(customer);

		};
	}
}
