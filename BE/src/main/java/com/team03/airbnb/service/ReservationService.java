package com.team03.airbnb.service;

import com.team03.airbnb.dao.ReservationDAO;
import com.team03.airbnb.dto.HotelDetailDTO;
import com.team03.airbnb.dto.ReservationCardDTO;
import com.team03.airbnb.dto.ReservationRequestDTO;
import com.team03.airbnb.entity.Reservation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

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

    public List<ReservationCardDTO> findAllCards(Long userId) {
        List<Reservation> reservations = reservationDAO.findAllCardsByUserId(userId);

        System.out.println(reservations);

        List<ReservationCardDTO> cards = reservations.stream()
                .map(reservation -> ReservationCardDTO.of(reservation))
                .collect(Collectors.toList());

        System.out.println(cards.toString());

        setImageUrlOfReservations(cards);
        return cards;
    }

    private void setImageUrlOfReservations(List<ReservationCardDTO> cards) {
       for(ReservationCardDTO card : cards) {
            card.setImageUrl(getThumbnailUrl(hotelService.findHotelDetailById(card.getHotelId()).getImageUrl()));
       }
    }

    private String getThumbnailUrl(List<String> urls) {
        return urls.get(0);
    }
}
