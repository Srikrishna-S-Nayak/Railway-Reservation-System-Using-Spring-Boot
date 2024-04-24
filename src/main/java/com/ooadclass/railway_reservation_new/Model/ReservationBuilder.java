package com.ooadclass.railway_reservation_new.Model;

import java.awt.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class ReservationBuilder {
    private Long id;
    private User user;
    private Train train;
    private int numberOfSeats;
    private double totalAmount;
    private String source;
    private String destination;
    private LocalDateTime bookingTime;
    private LocalDate reservationDate;
    private ReservationStatus status;
    private Long bookedTrainID;

    public ReservationBuilder setUser(User user) {
        this.user = user;
        return this;
    }

    public ReservationBuilder setTrain(Train train) {
        this.train = train;
        return this;
    }

    public ReservationBuilder setNumberOfSeats(int numberOfSeats) {
        this.numberOfSeats = numberOfSeats;
        return this;
    }

    public ReservationBuilder setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
        return this;
    }

    public ReservationBuilder setBookingTime(LocalDateTime bookingTime) {
        this.bookingTime = bookingTime;
        return this;
    }

    public ReservationBuilder setReservationTime(LocalDate reservationDate) {
        this.reservationDate = reservationDate;
        return this;
    }


    public ReservationBuilder setStatus(ReservationStatus status) {
        this.status = status;
        return this;
    }

    public ReservationBuilder setSource(String source) {
        this.source = source;
        return this;
    }

    public ReservationBuilder setDestination(String destination) {
        this.destination = destination;
        return this;
    }

    public Reservation build() {
        Reservation reservation = new Reservation();
        reservation.setUser(user);
        reservation.setTrain(train);
        reservation.setNumberOfSeats(numberOfSeats);
        reservation.setBookedTrainId(bookedTrainID);
        reservation.setTotalAmount(totalAmount);
        reservation.setSource(source);
        reservation.setDestination(destination);
        reservation.setBookingTime(bookingTime);
        reservation.setReservationDate(reservationDate);
        reservation.setStatus(status);
        return reservation;
    }


    public ReservationBuilder setBookedTrainID(Long trainId) {
        this.bookedTrainID = trainId;
        return this;
    }
}