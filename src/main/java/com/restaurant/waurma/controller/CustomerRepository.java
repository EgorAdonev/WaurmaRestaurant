package com.restaurant.waurma.controller;

import com.restaurant.waurma.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Collection;
import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
    //createNamedQuery
    @Query("select c from Customer c " +
            "where lower(c.name) like lower(concat('%', :searchTerm, '%')) " +
            "or lower(c.phone) like lower(concat('%', :searchTerm, '%'))")
    List<Customer> search(@Param("searchTerm") String searchTerm);

    @Query("SELECT h FROM Customer h WHERE h.name = :customer_id")
    Customer findByUsername(@Param("customer_id") String login);

    @Query(value = "SELECT customer_id FROM name WHERE author = :customer_id", nativeQuery = true)
    Collection<String> findAllContactFiles(@Param("customer_id") String login);

}
