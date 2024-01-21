package com.wheels4u.wheels4u.backend.model;


import jakarta.persistence.*;

@Entity
@Table(name="Customer")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name = "first_name")
    private String first_name;

    @Column(name="last_name")
    private String last_name;

    @Column(name="address")
    private String address;

    @Column(name="contact_no")
    private String contact_no;

    @Column(name="email")
    private String email;

    @Column(name="password")
    private String password;

    public Customer(){}

    public Customer( String first_name, String last_name, String address, String contact_no, String email, String password) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.address = address;
        this.contact_no = contact_no;
        this.email = email;
        this.password = password;
    }

    public Customer(int id, String first_name, String last_name, String address, String contact_no, String email, String password) {
        this.id = id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.address = address;
        this.contact_no = contact_no;
        this.email = email;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getContact_no() {
        return contact_no;
    }

    public void setContact_no(String contact_no) {
        this.contact_no = contact_no;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
