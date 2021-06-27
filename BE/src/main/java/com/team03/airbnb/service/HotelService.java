package com.team03.airbnb.service;

import com.team03.airbnb.dao.CoordinateDAO;
import com.team03.airbnb.dao.HotelDAO;
import com.team03.airbnb.dto.HotelCardDTO;
import com.team03.airbnb.dto.HotelCardWithCoordinateDTO;
import com.team03.airbnb.dto.HotelDetailDTO;
import com.team03.airbnb.entity.Coordinate;
import com.team03.airbnb.entity.Hotel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class HotelService {

    @Autowired
    private HotelDAO hotelDAO;

    @Autowired
    private CoordinateDAO coordinateDAO;

    public HotelDetailDTO findHotelDetailByID(Long id) {
        Hotel hotel = hotelDAO.findHotelByID(id);
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

    public HotelCardDTO findHotelCardByHotelId(Long hotelId) {
        Hotel hotel = hotelDAO.findHotelByID(hotelId);
        return HotelCardDTO.of(hotel);
    }

    public List<HotelCardWithCoordinateDTO> findHotelsAroundCurrentLocation(Double x, Double y, Double zoom) {
        List<Coordinate> hotelIdsAroundCurrentLocation = coordinateDAO.findHotelCoordinatesAroundCurrentLocation(x, y, zoom);

        List<Hotel> hotels = new ArrayList<>();

        int count = 0;
        for (Coordinate coordinate : hotelIdsAroundCurrentLocation) {
            hotels.add(hotelDAO.findHotelByID(coordinate.getHotelId()));
            hotels.get(count).setCoordinate(coordinate);
            count++;
        }

        List<HotelCardWithCoordinateDTO> hotelCards = hotels.stream()
                .map(hotel -> HotelCardWithCoordinateDTO.of(hotel))
                .collect(Collectors.toList());

        return hotelCards;
    }
}
