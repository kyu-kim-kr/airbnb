package com.team03.airbnb.service;

import com.team03.airbnb.dao.ReservationDAO;
import com.team03.airbnb.dto.HotelDetailDTO;
import com.team03.airbnb.dto.ReservationRequestDTO;
import com.team03.airbnb.entity.Reservation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReservationService {

    @Autowired
    HotelService hotelService;

    @Autowired
    private ReservationDAO reservationDAO;

    public void save(ReservationRequestDTO requestDTO) {
        setLocationNameOfReservationRequest(requestDTO);

        Reservation reservation = Reservation.of(requestDTO);
        reservationDAO.save(reservation);
    }

    private void setLocationNameOfReservationRequest(ReservationRequestDTO requestDTO) {
        HotelDetailDTO hotelDetailDTO = hotelService.findHotelDetailById(requestDTO.getHotelId());
        requestDTO.setLocationName(hotelDetailDTO.getLocationName());
    }
}
