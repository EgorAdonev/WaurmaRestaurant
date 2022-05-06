package com.restaurant.waurma.service;

import com.restaurant.waurma.controller.CustomerRepository;
import com.restaurant.waurma.model.Customer;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {

    private CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository){
        this.customerRepository = customerRepository;
    }

    public Customer findByUsername(String username) {
        return customerRepository.findByUsername(username);
    }

    public List<Customer> findAll() {
        return customerRepository.findAll();
    }

    public List<Customer> findAll(String filterText) {
        if(filterText == null || filterText.isEmpty()) {
            return customerRepository.findAll();
        } else  {
            return customerRepository.search(filterText);
        }
    }
    public void delete(Customer contact) {
        customerRepository.delete(contact);
    }

    public void save(Customer contact) {
        if (contact == null) {
//            LOGGER.log(Level.SEVERE,
//                    "Ошибка заполнения формы. Пожалуйста, проверьте поля.");
            System.out.println("Ошибка заполнения формы. Пожалуйста, проверьте поля.");
            return;
        }
        customerRepository.save(contact);
    }
}
