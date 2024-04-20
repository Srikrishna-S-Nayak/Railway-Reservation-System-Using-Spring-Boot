package com.ooadclass.railway_reservation_new.Model;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "reservations")
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ReservationId")
    private Long id;

    @Setter
    @Getter
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "UserID", nullable = false)
    private User user;

    @Setter
    @Getter
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "TrainID", nullable = false)
    private Train train;

    @Setter
    @Getter
    @Column(name = "NumberOfSeats", nullable = false)
    private int numberOfSeats;

    @Setter
    @Getter
    @Column(name = "TotalAmount", nullable = false)
    private double totalAmount;

    @Setter
    @Getter
    @Column(name = "DateOfReservation", nullable = false)
    private LocalDateTime bookingTime;

    @Setter
    @Getter
    @Column(name = "ReservationStatus", nullable = false)
    private ReservationStatus status;

}

