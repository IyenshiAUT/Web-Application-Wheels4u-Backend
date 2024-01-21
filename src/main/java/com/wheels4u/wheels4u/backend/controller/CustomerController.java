package com.wheels4u.wheels4u.backend.controller;

import com.wheels4u.wheels4u.backend.model.Customer;
import com.wheels4u.wheels4u.backend.repository.CustomerRepository;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;

@CrossOrigin(origins = "http://localhost:3000/")
@RestController
@RequestMapping("wheels4u")
public class CustomerController {
    @Autowired
    private EntityManager entityManager;

    @Autowired
    private CustomerRepository customerRepository;

    @GetMapping("/customers")
    public List<Customer> getAllCustomers(){
        return entityManager.createNativeQuery("Select * from Customer", Customer.class).getResultList();
    }

    @GetMapping("/customers/{email}")
    public String validateLogin(@PathVariable String email){
        String s=null;
        s= customerRepository.findByEmail(email);
        if(s==null){
            return "Email not found";
        }
        else return s;
    }

    @GetMapping("/customer/{email}")
    public Integer findId(@PathVariable String email){
        Integer id=null;
        id= customerRepository.findIdByEmail(email);
        if(id==null){
            return 0;
        }
        else return id;
    }

    @PostMapping("/customers")
    public Customer createCustomer(@RequestBody Customer customer) {
        Customer savedCustomer=customerRepository.save(customer);
        return savedCustomer;
    }

    @GetMapping("/customers/find/{email}")
    public Customer getCustomerDetails(@PathVariable String email){
        Customer c=null;
        c= customerRepository.findAllDetails(email);
        return c;
    }


    @PutMapping("/customers")
    void  updateEmployee(@RequestBody Customer customer){
        //if it is there it will update the existing one
        //if its not there it will create a new record in the database
        Customer findEmployee=customerRepository.save(customer);


    }


}
