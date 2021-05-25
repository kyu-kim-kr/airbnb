package com.team03.airbnb.service;

import com.team03.airbnb.dao.HotelDAO;
import com.team03.airbnb.dto.HotelCardDTO;
import com.team03.airbnb.dto.HotelDetailDTO;
import com.team03.airbnb.entity.Hotel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class HotelService {

    @Autowired
    private HotelDAO hotelDAO;

    public HotelDetailDTO findHotelDetailById(Long id) {
        Hotel hotel = hotelDAO.findHotelDetailById(id);
        HotelDetailDTO hotelDetailDTO = HotelDetailDTO.of(hotel);
        return hotelDetailDTO;
    }


    public List<HotelCardDTO> findAllHotelCardsByLocationName(String locationName) {
        List<Hotel> hotels = hotelDAO.findAllHotelCardsByLocationName(locationName);
        List<HotelCardDTO> hotelCardDTOs = hotels
                .stream()
                .map(hotel -> HotelCardDTO.of(hotel))
                .collect(Collectors.toList());
        return hotelCardDTOs;
    }
}
