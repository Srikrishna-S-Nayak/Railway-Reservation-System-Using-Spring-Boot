package com.ooadclass.railway_reservation_new.Service;

import com.ooadclass.railway_reservation_new.Model.Reservation;
import com.ooadclass.railway_reservation_new.Model.Train;
import com.ooadclass.railway_reservation_new.Model.User;
import com.ooadclass.railway_reservation_new.Repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReservationService {
    @Autowired
    private ReservationRepository reservationRepository;

    public List<Reservation> getAllReservations() {
        return reservationRepository.findAll();
    }

    public Reservation getReservationById(Long id) {
        return reservationRepository.findById(id).orElse(null);
    }

    public Reservation saveReservation(Reservation reservation) {
        return reservationRepository.save(reservation);
    }

    public void deleteReservation(Long id) {
        reservationRepository.deleteById(id);
    }

    public List<Reservation> getReservationsByUser(User user) {
        return reservationRepository.findByUser(user);
    }

    public String getSourceDestinationForReservation(Reservation reservation) {
        Train train = reservation.getTrain();
        return train.getSource() + " -> " + train.getDestination();
    }
}