package com.wheels4u.wheels4u.backend.repository;

import com.wheels4u.wheels4u.backend.model.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface VehicleRepository extends JpaRepository<Vehicle, Integer> {
    @Query(value = "SELECT v.rental_rate FROM Vehicle v WHERE v.id= ?1")
    String findRentalRate(String id);
}
