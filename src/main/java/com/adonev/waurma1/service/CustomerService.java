package com.adonev.waurma1.service;

import com.adonev.waurma1.controller.CustomerRepository;
import com.adonev.waurma1.model.Customer;
import org.springframework.stereotype.Service;

import java.util.List;
//customer context
@Service
public class CustomerService {

    private CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository){
        this.customerRepository = customerRepository;
    }

    public Customer findByName(String username) {
        return customerRepository.findByName(username);
    }

    public List<Customer> findAll() {
        return customerRepository.findAll();
    }

    public List<Customer> findAllCustomers(String filterText) {
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