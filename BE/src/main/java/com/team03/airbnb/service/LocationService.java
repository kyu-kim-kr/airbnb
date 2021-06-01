package com.team03.airbnb.service;

import com.team03.airbnb.dao.LocationDAO;
import com.team03.airbnb.dto.LocationDTO;
import com.team03.airbnb.entity.Location;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class LocationService {

    @Autowired
    private LocationDAO locationDAO;

    public List<LocationDTO> findAll(Integer limit) {
        if (limit == null) {
            List<Location> list = locationDAO.findAll();
            List<LocationDTO> listDTO = list.stream()
                    .map(location -> LocationDTO.of(location))
                    .collect(Collectors.toList());
            return listDTO;
        } else {
            List<Location> list = locationDAO.findAll(limit);
            List<LocationDTO> listDTO = list.stream()
                    .map(location -> LocationDTO.of(location))
                    .collect(Collectors.toList());
            return listDTO;
        }
    }
}
