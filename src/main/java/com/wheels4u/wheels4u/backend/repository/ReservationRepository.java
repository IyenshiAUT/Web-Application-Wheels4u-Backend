package com.wheels4u.wheels4u.backend.repository;

import com.wheels4u.wheels4u.backend.model.Reservation;
import com.wheels4u.wheels4u.backend.model.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation,Integer> {

    @Query(value = "SELECT r FROM Reservation r WHERE r.customer= ?1 and r.pick_up_date<=?2")
    List<Reservation> pastReservations(int customer, LocalDate date);

    @Query(value = "SELECT r FROM Reservation r WHERE r.customer= ?1 and r.pick_up_date>?2")
    List<Reservation> futureReservations(int customer, LocalDate date);

    @Query(value = "SELECT v FROM Vehicle v WHERE v.type=?3 AND v.id NOT IN (SELECT r.vehicle FROM Reservation as r WHERE (((r.pick_up_date<=?1) AND (r.drop_off_date>=?1) AND (r.pick_up_date<=?2) AND (r.drop_off_date>=?2)) OR ((r.pick_up_date>=?1) AND (r.drop_off_date>=?1) AND (r.pick_up_date<=?2) AND (r.drop_off_date>=?2)) OR ((r.pick_up_date<=?1) AND (r.drop_off_date>=?1) AND (r.pick_up_date<=?2) AND(r.drop_off_date<=?2)) OR ((r.pick_up_date>=?1) AND (r.drop_off_date>=?1) AND (r.pick_up_date<=?2) AND (r.drop_off_date<=?2))))")
    List<Vehicle> vehicleAvailable(LocalDate startDate, LocalDate endDate, String type);

    Reservation save(Reservation reservation);

    void deleteById(Integer id);
}
