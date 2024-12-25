package com.demotest.wplab1.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(path = "/eventBooking")
public class EventBookingController {

    @GetMapping
    public String eventBooking() {
        return "eventBooking";
    }
}
