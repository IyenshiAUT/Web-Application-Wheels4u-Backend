package com.wheels4u.wheels4u.backend.repository;

import com.wheels4u.wheels4u.backend.model.Customer;
import com.wheels4u.wheels4u.backend.model.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {


    @Query(value = "SELECT c.password FROM Customer c WHERE c.email= ?1")
    String findByEmail(String email);

    @Query(value = "SELECT c.id FROM Customer c WHERE c.email= ?1")
    Integer findIdByEmail(String email);

    Customer save(Customer customer);

    @Query(value = "SELECT c FROM Customer c WHERE c.email= ?1")
    Customer findAllDetails(String email);
}
