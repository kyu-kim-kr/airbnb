package com.team03.airbnb.service;

import com.team03.airbnb.dao.HotelDAO;
import com.team03.airbnb.dto.HotelCardDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HotelService {

    @Autowired
    private HotelDAO hotelDAO;


    public List<HotelCardDTO> findAllHotelCardsByLocationName(String locationName) {
        return hotelDAO.findAllHotelCardsByLocationName(locationName);
    }
}
