package com.wheels4u.wheels4u.backend.model;

import jakarta.persistence.*;

import java.sql.Time;
import java.time.LocalDate;
import java.util.Date;
import java.time.LocalTime;

@Entity
@Table(name="Reservation")
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="pick_up_date")
    private LocalDate pick_up_date;

    @Column(name="pick_up_time")
    private LocalTime pick_up_time;

    @Column(name="pick_up_location")
    private String pick_up_location;

    @Column(name="drop_off_date")
    private LocalDate drop_off_date;

    @Column(name="need_driver")
    private String need_driver;

    @Column(name="payment")
    private int payment;

    @Column(name="vehicle")
    private String vehicle;

    @JoinColumn(name="customer")
    private int customer;

    public Reservation (){}

    public Reservation(LocalDate pick_up_date, LocalTime pick_up_time, String pick_up_location, LocalDate drop_off_date, String need_driver, int payment, String vehicle, int customer) {
        this.pick_up_date = pick_up_date;
        this.pick_up_time = pick_up_time;
        this.pick_up_location = pick_up_location;
        this.drop_off_date = drop_off_date;
        this.need_driver = need_driver;
        this.payment = payment;
        this.vehicle = vehicle;
        this.customer = customer;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDate getPick_up_date() {
        return pick_up_date;
    }

    public void setPick_up_date(LocalDate pick_up_date) {
        this.pick_up_date = pick_up_date;
    }

    public LocalTime getPick_up_time() {
        return pick_up_time;
    }

    public void setPick_up_time(LocalTime pick_up_time) {
        this.pick_up_time = pick_up_time;
    }

    public String getPick_up_location() {
        return pick_up_location;
    }

    public void setPick_up_location(String pick_up_location) {
        this.pick_up_location = pick_up_location;
    }

    public LocalDate getDrop_off_date() {
        return drop_off_date;
    }

    public void setDrop_off_date(LocalDate drop_off_date) {
        this.drop_off_date = drop_off_date;
    }

    public String getNeed_driver() {
        return need_driver;
    }

    public void setNeed_driver(String need_driver) {
        this.need_driver = need_driver;
    }

    public int getPayment() {
        return payment;
    }

    public void setPayment(int payment) {
        this.payment = payment;
    }

    public String getVehicle() {
        return vehicle;
    }

    public void setVehicle(String vehicle) {
        this.vehicle = vehicle;
    }

    public int getCustomer() {
        return customer;
    }

    public void setCustomer(int customer) {
        this.customer = customer;
    }
}
