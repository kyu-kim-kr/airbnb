package com.team03.airbnb.controller;

import com.team03.airbnb.entity.Reservation;
import com.team03.airbnb.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/reservation")
public class ReservationController {

    @Autowired
    private ReservationService reservationService;

    @PostMapping("/create")
    public void save(@RequestBody Reservation reservation) {

    }

}
