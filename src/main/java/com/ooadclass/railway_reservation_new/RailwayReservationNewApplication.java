package com.ooadclass.railway_reservation_new;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@RestController
@SpringBootApplication
public class RailwayReservationNewApplication {

	@RequestMapping("/")
	public ModelAndView home() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("Welcome.html");
		return modelAndView;
	}

	public static void main(String[] args) {
		SpringApplication.run(RailwayReservationNewApplication.class, args);
	}

}
