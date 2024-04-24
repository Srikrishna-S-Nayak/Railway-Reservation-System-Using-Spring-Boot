package com.ooadclass.railway_reservation_new.Controller;

import com.ooadclass.railway_reservation_new.Model.Reservation;
import com.ooadclass.railway_reservation_new.Model.User;
import com.ooadclass.railway_reservation_new.Repository.UserRepository;
import com.ooadclass.railway_reservation_new.Security.UserPrincipal;
import com.ooadclass.railway_reservation_new.Service.ReservationService;
import com.ooadclass.railway_reservation_new.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class MyBookingsController {
    @Autowired
    private ReservationService reservationService;

    @Autowired
    private UserService userService;

    @GetMapping("/my-bookings")
    public String myBookings(Authentication authentication, Model model) {
        UserPrincipal userPrincipal = (UserPrincipal) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User user = userService.getUserByUsername(userPrincipal.getUsername());
        List<Reservation> reservations = reservationService.getReservationsByUser(user);
        model.addAttribute("reservations", reservations);
        model.addAttribute("user", user);
        return "my-bookings";
    }
}