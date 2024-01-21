package com.wheels4u.wheels4u.backend.controller;

import com.wheels4u.wheels4u.backend.model.Customer;
import com.wheels4u.wheels4u.backend.model.Reservation;
import com.wheels4u.wheels4u.backend.model.Vehicle;
import com.wheels4u.wheels4u.backend.repository.ReservationRepository;
import jakarta.persistence.EntityManager;
import org.hibernate.collection.spi.PersistentBag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
@CrossOrigin(origins = "http://localhost:3000/")
@RestController
@RequestMapping("wheels4u")
public class ReservationController {

    @Autowired
    private EntityManager entityManager;

    @Autowired
    private ReservationRepository reservationRepository;

    @GetMapping("/reservations")
    public List<Reservation> getAllReservations(){
        return entityManager.createNativeQuery("Select * from Reservation", Reservation.class).getResultList();
    }

    @GetMapping("/reservations/completed/{requestedId}/{requestedDate}")
    public List<Reservation> getCompletedReservations(@PathVariable int requestedId, @PathVariable LocalDate requestedDate)
    {
        return reservationRepository.pastReservations(requestedId, requestedDate);
    }

    @GetMapping("/reservations/upcoming/{requestedId}/{requestedDate}")
    public List<Reservation> getUpcomingReservations(@PathVariable int requestedId, @PathVariable LocalDate requestedDate)
    {
        List<Reservation> reserve = reservationRepository.futureReservations(requestedId, requestedDate);
        if(reserve==null){
            List<Reservation> newList = new ArrayList<Reservation>();
            return newList;
        }
        else return reserve;
    }

    @GetMapping("/reservations/{startDate}/{endDate}/{vType}")
    public List<Vehicle> getVehicleIdsAvailable(@PathVariable String vType, @PathVariable LocalDate startDate, @PathVariable LocalDate endDate){
        return reservationRepository.vehicleAvailable(startDate, endDate, vType);
    }

    @PostMapping("/reservations")
    public Reservation createReservation(@RequestBody Reservation reservation) {
        Reservation savedReservation=reservationRepository.save(reservation);
        return savedReservation;
    }

    @DeleteMapping("reservations/{requestedId}")
    public void deleteReservation(@PathVariable Integer requestedId){
        reservationRepository.deleteById(requestedId);
    }


}
