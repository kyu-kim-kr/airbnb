package com.team03.airbnb.service;

import com.team03.airbnb.dao.HotelDAO;
import com.team03.airbnb.dto.PriceDTO;
import com.team03.airbnb.entity.Hotel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PriceService {

    @Autowired
    private HotelDAO hotelDAO;

    public PriceDTO findAllPricesByLocationName(String locationName) {
        List<Hotel> hotels = hotelDAO.findAllPricesByLocationName(locationName);

        PriceDTO priceDTO = new PriceDTO();
        for (Hotel hotel : hotels) {
            priceDTO.add(hotel.getPrice());
        }

        return priceDTO;
    }
}
