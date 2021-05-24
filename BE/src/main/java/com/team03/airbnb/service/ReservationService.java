package com.team03.airbnb.service;

import com.team03.airbnb.dao.ReservationDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReservationService {

    @Autowired
    private ReservationDAO reservationDAO;
}
