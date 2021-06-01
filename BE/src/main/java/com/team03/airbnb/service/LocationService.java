package com.team03.airbnb.service;

import com.team03.airbnb.dao.LocationDAO;
import com.team03.airbnb.entity.Location;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LocationService {

    @Autowired
    private LocationDAO locationDAO;

    public List<Location> findAll(Integer limit) {
        if (limit == null) {
            return locationDAO.findAll();
        } else {
            return locationDAO.findAll(limit);
        }
    }
}
