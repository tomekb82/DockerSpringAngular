package com.example.demo;

import java.util.List;
import java.util.stream.Stream;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface CustomerRepository extends CrudRepository<Customer, Long> {

    //List<Customer> findByLastName(String lastName);

    @Query("select c from Customer c")
    Stream<Customer> findAllCustomers();

    @Query("select c.lastName from Customer c")
    Stream<String> findAllandShowLastName();

    @Query("select c from Customer c where c.lastName = ?1")
    Stream<Customer> findByLastName(String lastName);
}
