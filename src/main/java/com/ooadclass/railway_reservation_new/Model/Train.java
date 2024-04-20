package com.ooadclass.railway_reservation_new.Model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "trains")
public class Train {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Setter
    @Getter
    @Column(nullable = false)
    private String trainNumber;

    @Setter
    @Getter
    @Column(nullable = false)
    private String trainName;

    @Setter
    @Getter
    @Column(nullable = false)
    private String source;

    @Setter
    @Getter
    @Column(nullable = false)
    private String destination;

    @Setter
    @Getter
    @Column(nullable = false)
    private LocalDateTime departureTime;

    @Setter
    @Getter
    @Column(nullable = false)
    private LocalDateTime arrivalTime;

    @Setter
    @Getter
    @Column(nullable = false)
    private int totalSeats;

    @Setter
    @Getter
    @Column(nullable = false)
    private double ticketPrice;

}