package com.restaurant.waurma.view;

import com.restaurant.waurma.controller.CustomerRepository;
import com.restaurant.waurma.model.Customer;
import com.restaurant.waurma.model.Order;
//import com.vaadin.flow.component.applayout.DrawerToggle;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@SuppressWarnings("serial")
public class MainLayout {

    @Autowired
	public void MainLayout(CustomerRepository customerRepository) {
    	List<Customer> customerList = customerRepository.findAll();
    	createHeader(customerList);
}


    private void createHeader(List<Customer> customerList) {
        H1 logo = new H1("Restaurant");
        H1 userInfo = new H1();
        logo.addClassName("logo");

        String username = "Admin";
        String name = "ФИО не задано";

        for(Customer customer : customerList) {
        	if(customer.getName().equals(username)) {
            	name = customer.getName();
            	break;
        	}
        }

        userInfo.setText("Текущий пользователь: " + username + " / " + name + ".");
        userInfo.addClassName("logo");

        HorizontalLayout header = new HorizontalLayout( logo, userInfo);
        header.expand(logo);
        header.setWidth("100%");
        header.addClassName("header");

//        addToNavbar(header);
}
}
