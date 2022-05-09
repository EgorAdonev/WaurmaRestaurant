package com.adonev.waurma1;

import com.adonev.waurma1.controller.CustomerRepository;
import com.adonev.waurma1.model.Customer;
import com.github.javafaker.Faker;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDateTime;
import java.util.ArrayList;
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

			String name1 = faker.name().firstName();
			String email1 = String.format("%s@waurma.ru", name1);
			Customer customer1 = new Customer(email1, name1, faker.phoneNumber().cellPhone());

//			List<Customer> customers = new ArrayList<>(10);
//
//			for (int i = 0;i<customers.size(); ++i) {
//				String name0 = faker.name().firstName();
//				String phone0= faker.phoneNumber().cellPhone();
//				customers.add(new Customer(name0,String.format("%s@waurma.ru", name0),phone0));
//			}

			customerRepository.save(customer);
			customerRepository.save(customer1);

			System.out.println(customerRepository.search(name));
			System.out.println(customerRepository.findByName(name1));
			System.out.println(customerRepository.findAll());

			customerRepository.delete(customer1);

		};
	}
}
