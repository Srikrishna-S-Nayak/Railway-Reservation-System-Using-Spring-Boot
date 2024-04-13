package com.ooadclass.railway_reservation_new.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

    @RequestMapping("/home")
    public String home() {
        return "home";
    }

    @RequestMapping("/login")
    String Login() {
        return "login";
    }

    @RequestMapping("/register")
    String Register() {
        return "register";
    }

    @RequestMapping("/book-tickets")
    String BookTickets(){
        return "Test";
    }
}
