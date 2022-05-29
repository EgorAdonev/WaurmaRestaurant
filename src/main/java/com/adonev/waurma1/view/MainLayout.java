package com.adonev.waurma1.view;

import com.adonev.waurma1.controller.CustomerRepository;
import com.adonev.waurma1.model.Customer;
import com.adonev.waurma1.model.Order;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Arrays;
import java.util.List;
@SuppressWarnings("serial")
public class MainLayout {

    @Autowired
    public void MainLayout(CustomerRepository customerRepository) {
        List<Customer> customerList = customerRepository.findAll();
        createHeader(customerList);
    }


    private void createHeader(List<Customer> customerList) {
        H1 logo = new H1("GOGA'S WAURMA");
        H1 userInfo = new H1();
        logo.addClassName("logo");

        List<String> usernameList = Arrays.asList(new String[]{"Admin"});
        String username = "";
        String name = "ФИО не задано";

        for(Customer customer : customerList) {
            for(String element : usernameList) {
                if (customer.getName().equals(element)) {
                    username = element;
                    name = customer.getName();
                    break;
                }
            }
        }

        userInfo.setText("Текущий пользователь: " + username + " / " + name + ".");
        userInfo.addClassName("logo");

        HorizontalLayout header = new HorizontalLayout( logo, userInfo);
        header.expand(logo);
        header.setWidth("100%");
        header.addClassName("header");
        header.setVisible(true);
        header.setEnabled(true);
//        addToNavbar(header);
    }
}