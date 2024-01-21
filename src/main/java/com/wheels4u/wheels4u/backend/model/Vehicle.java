package com.wheels4u.wheels4u.backend.model;

import jakarta.persistence.*;

@Entity
@Table(name="Vehicle")
public class Vehicle {
    @Id
    private String id;

    @Column(name="type")
    private String type;

    @Column
    private String brand;

    @Column
    private String gear;

    @Column
    private int no_of_seats;

    @Column
    private int rental_rate;

    @Column
    private String link;


    public Vehicle(){}
    public Vehicle(String id, String type, String brand, String gear, int no_of_seats,
                   int rental_rate, String link) {
        this.id = id;
        this.type = type;
        this.brand=brand;
        this.gear = gear;
        this.no_of_seats = no_of_seats;
        this.rental_rate = rental_rate;
        this.link = link;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getGear() {
        return gear;
    }

    public void setGear(String gear) {
        this.gear = gear;
    }

    public int getNo_of_seats() {
        return no_of_seats;
    }

    public void setNo_of_seats(int no_of_seats) {
        this.no_of_seats = no_of_seats;
    }


    public int getRental_rate() {
        return rental_rate;
    }

    public void setRental_rate(int rental_rate) {
        this.rental_rate = rental_rate;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }
}
