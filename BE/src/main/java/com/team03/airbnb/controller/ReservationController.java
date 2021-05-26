package com.team03.airbnb.controller;

import com.team03.airbnb.dto.ReservationCardDTO;
import com.team03.airbnb.dto.ReservationDetailDTO;
import com.team03.airbnb.dto.ReservationRequestDTO;
import com.team03.airbnb.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reservation")
public class ReservationController {

    @Autowired
    private ReservationService reservationService;

    @PostMapping("/create")
    public ResponseEntity save(@RequestBody ReservationRequestDTO requestDTO) {
        reservationService.save(requestDTO);
        return new ResponseEntity("success", HttpStatus.OK);
    }

    @GetMapping("/{userId}/list")
    public List<ReservationCardDTO> findAllCards(@PathVariable Long userId) {
        return reservationService.findAllCards(userId);
    }

    @GetMapping("/detail/{reservationId}")
    public ReservationDetailDTO findReservationDetail(@PathVariable Long reservationId) {
        return reservationService.findReservatonDetail(reservationId);
    }

    @DeleteMapping("/delete/{reservationId}")
    public ResponseEntity deleteReservation(@PathVariable Long reservationId) {
        reservationService.deleteReservation(reservationId);
        return new ResponseEntity("success", HttpStatus.OK);
    }
}
