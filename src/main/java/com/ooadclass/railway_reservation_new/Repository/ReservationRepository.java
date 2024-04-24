package com.ooadclass.railway_reservation_new.Repository;

import com.ooadclass.railway_reservation_new.Model.Reservation;
import com.ooadclass.railway_reservation_new.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Long> {
    List<Reservation> findByUser(User user);
}