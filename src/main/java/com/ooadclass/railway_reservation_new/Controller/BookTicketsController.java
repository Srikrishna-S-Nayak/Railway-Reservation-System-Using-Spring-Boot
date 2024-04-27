package com.ooadclass.railway_reservation_new.Controller;

import com.ooadclass.railway_reservation_new.Model.*;
import com.ooadclass.railway_reservation_new.Security.UserPrincipal;
import com.ooadclass.railway_reservation_new.Service.ReservationService;
import com.ooadclass.railway_reservation_new.Service.TrainService;
import com.ooadclass.railway_reservation_new.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;
import java.util.Set;

@Controller
public class BookTicketsController {
    @Autowired
    private TrainService trainService;

    @Autowired
    private ReservationService reservationService;
    @Autowired
    private UserService userService;

    @GetMapping("/book-tickets")
    public String bookTickets(Model model) {
        Set<String> sources = trainService.getDistinctSources();
        Set<String> destinations = trainService.getDistinctDestinations();
        List<Train> trains = trainService.getAllTrains();

        model.addAttribute("sources", sources);
        model.addAttribute("destinations", destinations);
        model.addAttribute("trains", trains);
        model.addAttribute("reservation", new Reservation());
        return "book-tickets";
    }

    @PostMapping("/book-tickets")
    public String bookTickets(@ModelAttribute("reservation") Reservation reservation, Model model) {
        UserPrincipal userPrincipal = (UserPrincipal) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User user = userService.getUserByUsername(userPrincipal.getUsername());
        Long trainId = reservation.getBookedTrainId();
        Train train = trainService.getTrainById(trainId);

        List<Train> trains = trainService.getTrainsBySourceDestination(train.getSource(), train.getDestination());
        model.addAttribute("trains", trains);

        if (trains.isEmpty()) {
            return "book-tickets";
        }

        Reservation bookingReservation = new ReservationBuilder()
                .setUser(user)
                .setTrain(train)
                .setNumberOfSeats(reservation.getNumberOfSeats())
                .setBookedTrainID(trainId)
                .setTotalAmount(reservation.getTotalAmount())
                .setBookingTime(LocalDateTime.now())
                .setReservationTime(LocalDate.now())
                .setSource(reservation.getSource())
                .setDestination(reservation.getDestination())
                .setStatus(ReservationStatus.CONFIRMED)
                .build();

        reservationService.saveReservation(bookingReservation);
        return "redirect:/my-bookings";
    }
}