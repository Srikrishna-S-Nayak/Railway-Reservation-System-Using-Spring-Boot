package com.ooadclass.railway_reservation_new.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.ooadclass.railway_reservation_new.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

@Controller
public class LoginController {

    @Autowired
    private UserService userService;

    @RequestMapping("/login")
    String Login() {
        return "login";
    }
}
