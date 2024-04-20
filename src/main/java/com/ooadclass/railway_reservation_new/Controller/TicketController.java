package com.ooadclass.railway_reservation_new.Controller;

import com.ooadclass.railway_reservation_new.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TicketController {

    @Autowired
    private UserService userService;

    @RequestMapping("/book-tickets")
    String BookTickets(){
        return "Test";
    }
}
