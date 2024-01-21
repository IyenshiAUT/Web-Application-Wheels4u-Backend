package com.wheels4u.wheels4u.backend.controller;

import com.wheels4u.wheels4u.backend.repository.VehicleRepository;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:3000/")
@RestController
@RequestMapping("wheels4u")
public class VehicleController {

    @Autowired
    private EntityManager entityManager;

    @Autowired
    private VehicleRepository vehicleRepository;

    @GetMapping("/vehicles/{id}")
    public String getRentalRate(@PathVariable String id){
        String v=null;
        v= vehicleRepository.findRentalRate(id);
        if(v==null){
            return "Email not found";
        }
        else return v;
    }



}
