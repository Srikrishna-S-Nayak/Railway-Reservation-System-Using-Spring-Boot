package com.ooadclass.railway_reservation_new.Model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalTime;
import java.util.List;

@Getter
@Entity
@Table(name = "trains")
public class Train {
    @Getter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Setter
    @Getter
    private String trainName;

    @Setter
    private String source;

    @Setter
    private String destination;

    @Setter
    private LocalTime departureTime;

    @Setter
    private LocalTime arrivalTime;

    @Setter
    private int availableSeats;

    @Setter
    @OneToMany(mappedBy = "train", cascade = CascadeType.ALL)
    private List<Reservation> reservations;

    // Constructors, getters, and setters
}