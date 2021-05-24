package com.team03.airbnb.dao.mapper;

import com.team03.airbnb.entity.Hotel;
import com.team03.airbnb.entity.Location;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class HotelMapper implements RowMapper<Hotel> {

    @Override
    public Hotel mapRow(ResultSet rs, int rowNum) throws SQLException {
        Hotel hotel = new Hotel();

        hotel.setId(rs.getLong("id"));
        hotel.setImageUrl(rs.getString("image_url"));
        hotel.setTitle(rs.getString("title"));
        hotel.setReviewStarPoint(rs.getDouble("review_star_point"));
        hotel.setReviewNumber(rs.getInt("review_number"));
        hotel.setLocationName(rs.getString("location_name"));
        hotel.setHostId(rs.getLong("host_id"));
        hotel.setMaximumOccupancy(rs.getInt("maximum_occupancy"));
        hotel.setNumberOfBeds(rs.getInt("number_of_beds"));
        hotel.setNumberOfBathrooms(rs.getInt("number_of_bathrooms"));
        hotel.setIsOneroom(rs.getBoolean("is_oneroom"));
        hotel.setDescription(rs.getString("description"));
        hotel.setPrice(rs.getInt("price"));

        return hotel;
    }
}
