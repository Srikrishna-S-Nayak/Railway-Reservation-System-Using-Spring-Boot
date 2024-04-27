package com.ooadclass.railway_reservation_new.Model;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

@Getter
@Entity
@Table(name = "reservations")
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Setter
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "UserID", nullable = false)
    private User user;

    @Setter
    @Getter
    private Long bookedTrainId;

    @Getter
    @Setter
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "TrainID", nullable = false)
    private Train train;

    @Setter
    private int numberOfSeats;

    @Getter
    private double totalAmount;

    @Getter
    @Setter
    private String source;

    @Getter
    @Setter
    private String destination;

    @Setter
    private LocalDateTime bookingTime;

    @Setter
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate reservationDate;

    @Setter
    private ReservationStatus status;

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = Math.round((bookedTrainId + totalAmount)/ 100.0)*2;
    }

}

