package com.ooadclass.railway_reservation_new.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.ooadclass.railway_reservation_new.Model.User;
import com.ooadclass.railway_reservation_new.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

@Controller
public class RegisterController {

    @Autowired
    private UserService userService;

    @RequestMapping("/register")
    String Register() {
        return "register";
    }

    @PostMapping("/register")
    public String registerUser(@ModelAttribute("user") User user, Model model) {
        userService.saveUser(user);
        model.addAttribute("user", user);
        System.out.println("User registered successfully");
        return "redirect:/home";
    }
}
