package com.adonev.waurma1.controller;

import com.adonev.waurma1.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;
@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

    @Query("select c from Customer c " +
            "where lower(c.name) like lower(concat('%', :searchTerm, '%')) " +
            "or lower(c.phone) like lower(concat('%', :searchTerm, '%'))")
    List<Customer> search(@Param("searchTerm") String searchTerm);

    @Query("SELECT h FROM Customer h WHERE h.name = :customer_id")
    Customer findByName(@Param("customer_id") String login);

    @Query(value = "SELECT customer_id FROM name WHERE author = :customer_id", nativeQuery = true)
    Collection<String> findAllCustomers(@Param("customer_id") String login);

}

